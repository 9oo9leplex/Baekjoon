package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1600 {

	static int r,c,k,map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int hr[] = {-1,-2,-2,-1,1,2,2,1};
	static int hc[] = {-2,-1,1,2,2,1,-1,-2};
	static boolean[][][] visit;
	static int min;
	
	static class Node{
		int x,y,cnt,k;

		public Node(int x, int y, int cnt, int k) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
		
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		visit = new boolean[r][c][k+1];
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		min = bfs(0,0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);

	}

	private static int bfs(int row, int col) {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(row, col, 0, k));
		visit[row][col][k] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.x == r-1 && cur.y == c-1) return cur.cnt;
			
			for(int i=0;i<4;i++) {
				int nr = cur.x + dr[i];
				int nc = cur.y + dc[i];
				if(inArea(nr, nc) && !visit[nr][nc][cur.k] && map[nr][nc] == 0) {
					visit[nr][nc][cur.k] = true;
					q.add(new Node(nr, nc, cur.cnt+1, cur.k));
				}
			}
			
			if(cur.k > 0) {
				for(int i=0;i<8;i++) {
					int nr = cur.x + hr[i];
					int nc = cur.y + hc[i];
					if(inArea(nr, nc) && !visit[nr][nc][cur.k-1] && map[nr][nc] == 0) {
						visit[nr][nc][cur.k-1] = true;
						q.add(new Node(nr, nc, cur.cnt+1, cur.k-1));
					}
				}
			}
		}

		return min;
	}

	private static boolean inArea(int row, int col) {
		return row >= 0 && row < r && col >= 0 && col < c;
	}

	

}
