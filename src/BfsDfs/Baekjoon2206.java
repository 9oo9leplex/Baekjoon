package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2206 {

	static int N,M,cnt=1,map[][], min = Integer.MAX_VALUE,dp[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][][] visit;
	static class Route{
		int r,c,life;

		public Route(int r, int c, int life) {
			super();
			this.r = r;
			this.c = c;
			this.life = life;
		}

		@Override
		public String toString() {
			return "Route [r=" + r + ", c=" + c + ", life=" + life + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(N-1 == 0 && M-1 == 0) {
			System.out.println(1);
			return;
		}
		
		map = new int[N][M];
		visit = new boolean[2][N][M];
		dp = new int[N][M];
		char[] tmp;
		for(int i=0;i<N;i++) {
			tmp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		
		bfs();
//		if(visit[N-1][M-1]) System.out.println(cnt);
//		else System.out.println(-1);
//		dfs(0,0,1,1);
//		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}


/*
	private static void dfs(int r, int c, int life, int step) {
		
		if(visit[r][c] && (map[r][c] == 1 && life == 0)) return;
		if(r == N-1 && c == M-1) {
			min = Math.min(min, step);
			return;
		}
		
		visit[r][c] = true;
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(inArea(nr, nc) && !visit[nr][nc]) {
				if(map[nr][nc] == 1) {
					if(life > 0) dfs(nr,nc,life-1,step+1);
				} else {
					dfs(nr,nc,life,step+1);
				}
			}
		}
		visit[r][c] = false;
		
	}
*/


	private static void bfs() {

		Queue<Route> q = new LinkedList<>();
		q.add(new Route(0, 0, 0));
//		int size;
		
		while(!q.isEmpty()) {
			Route tmp = q.poll();
//			size = q.size();
//			for(int i=0;i<size;i++) {
//				Route tmp = q.poll();
				
				for(int j=0;j<4;j++) {
					int nr = tmp.r + dr[j];
					int nc = tmp.c + dc[j];
					
					if(!inArea(nr,nc)) continue;
					
					if (map[nr][nc] == 1) {
						if (tmp.life == 0 && !visit[1][nr][nc]) {
							visit[tmp.life][nr][nc] = true;
							dp[nr][nc] = dp[tmp.r][tmp.c] + 1;
							q.add(new Route(nr, nc, 1));
						}
					} else {
						if(!visit[tmp.life][nr][nc]) {
							visit[tmp.life][nr][nc] = true;
							dp[nr][nc] = dp[tmp.r][tmp.c] + 1;
							q.offer(new Route(nr, nc, tmp.life));
						}
					}
					
					if(nr == N-1 && nc == M-1) {
						System.out.println(dp[nr][nc] + 1);
						return;
					}
				}
			}
		
//			cnt++;
		System.out.println(-1);
		}
	

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
