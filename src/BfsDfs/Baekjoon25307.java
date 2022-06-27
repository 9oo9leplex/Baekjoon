package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon25307 {

	static int N,M,K,map[][];
	static class Point {
		int r,c,t;

		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", t=" + t + "]";
		}
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Point> q = new LinkedList<>();
		Queue<Point> manekins = new LinkedList<>();
		Queue<Point> chairs = new LinkedList<>();
		map = new int[N][M];
		int val;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				
				if(val == 4) q.add(new Point(i, j, 0));
				else if(val == 3) manekins.add(new Point(i,j,0));
				else if(val == 2) chairs.add(new Point(i, j, 0));
			}
		}
		
		if(chairs.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(bfs(q,manekins,chairs));
	}

	private static int bfs(Queue<Point> q, Queue<Point> manekins, Queue<Point> chairs) {
		
		boolean[][] visit = new boolean[N][M];
		
		Point cur = q.peek();
		visit[cur.r][cur.c] = true;
//		System.out.println(manekins);
//		System.out.println(chairs);
		int nr,nc,diff;
		boolean flag;
		
		while(!q.isEmpty()) {
			
			cur = q.poll();
//			System.out.println(cur);
			for(Point destination : chairs) {
				if(cur.r == destination.r && cur.c == destination.c) {
					return cur.t;
				}
			}
			
			for(int i=0;i<4;i++) {
				
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(inArea(nr,nc) && !visit[nr][nc] && map[nr][nc] != 1) {
					flag = false;
					for(Point manekin : manekins) {
						diff = Math.abs(nr - manekin.r) + Math.abs(nc - manekin.c);
//						System.out.println("[nr,nc,diff]: ["+nr+","+nc+","+diff+"]");
						if(diff <= K) {
							flag = true;
							break;
						}
					}
					
					if(flag) continue;
					
					visit[nr][nc] = true;
					q.add(new Point(nr, nc, cur.t+1));
				}
			}
		}
		return -1;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
