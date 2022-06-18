package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14923 {

	static int N,M,map[][];
	static class Node{
		int r,c,cnt,wall;

		public Node(int r, int c, int cnt, int wall) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wall = wall;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", cnt=" + cnt + ", wall=" + wall + "]";
		}
		
		
	}
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	int sr = Integer.parseInt(st.nextToken()) - 1;
    	int sc = Integer.parseInt(st.nextToken()) - 1;
    	st = new StringTokenizer(br.readLine());
    	int dr = Integer.parseInt(st.nextToken()) - 1;
    	int dc = Integer.parseInt(st.nextToken()) - 1;
    	
    	map = new int[N][M];
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	System.out.println(bfs(sr,sc,dr,dc));
    }


	private static int bfs(int sr, int sc, int r, int c) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sr,sc,0,0));
		
		boolean[][][] visit = new boolean[N][M][2];
		visit[sr][sc][0] = true;
		
		Node cur;
		int nr,nc;
		
		while(!q.isEmpty()) {
			cur = q.poll();
//			System.out.println(cur);
			if(cur.r == r && cur.c == c) return cur.cnt;
			
			
			for(int i=0;i<4;i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(inArea(nr, nc) && !visit[nr][nc][cur.wall]) {
					if(map[nr][nc] == 1) {
						if(cur.wall == 1) continue;
						
						visit[nr][nc][cur.wall] = true;
						q.add(new Node(nr,nc,cur.cnt+1,1));
					}
					else {
						
						visit[nr][nc][cur.wall] = true;
						q.add(new Node(nr,nc,cur.cnt+1,cur.wall));
					}
				}
			}
		}
		
		return -1;
	}


	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
