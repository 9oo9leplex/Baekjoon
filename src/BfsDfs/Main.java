package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R,C;
	static char[][] map;
	static boolean[][] visit;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static class Node{
		int r,c,cost;	

		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int min = Integer.MIN_VALUE;
		int value;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == 'L') {
					visit = new boolean[R][C];
					value = bfs(i,j);
					min = Math.max(min, value);
				}
			}
		}
		System.out.println(min);
	}

	private static int bfs(int r, int c) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c, 0));
		visit[r][c] = true;
		int day = 0;
		
		while(!q.isEmpty()) {
			
			Node tmp = q.poll();
			
			for(int i=0;i<4;i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];
				
				if(inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] == 'L') {
					day = Math.max(day, tmp.cost+1);
					visit[nr][nc] = true;
					q.add(new Node(nr, nc, tmp.cost+1));
				}
			
			}
		}
		
		return day;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
