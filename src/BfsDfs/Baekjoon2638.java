package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2638 {

	static int N, M, map[][],dp[][],day,count;
	static boolean[][] visit;
	
	static class Cheese {
		int r, c;

		public Cheese(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) count++;
			}
		}

		while(count != 0) {
			visit = new boolean[N][M];
			dp = new int[N][M];
			bfs();			
			refreshMap();
			day++;
		}
		System.out.println(day);
	}

	private static void refreshMap() {

		for(int i=1;i<N-1;i++) {
			for(int j=1;j<M-1;j++) {
				if(dp[i][j] >= 2) {
					map[i][j] = 0;
					count--;
				}
			}
		}
		
	}

	private static void bfs() {

		Queue<Cheese> q = new LinkedList<>();
		
		q.add(new Cheese(0, 0));
		visit[0][0] = true;

		Cheese c;
		int nr,nc;
		
		while(!q.isEmpty()) {
			
			c = q.poll();
			
			for(int i=0;i<4;i++) {
				nr = c.r + dr[i];
				nc = c.c + dc[i];
				
				if(inArea(nr,nc)) {
					if(!visit[nr][nc] && map[nr][nc] == 0) {
						q.add(new Cheese(nr, nc));
						visit[nr][nc] = true;
					} else if(map[nr][nc] == 1) dp[nr][nc]++;
				}
			}
		}
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
