package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import BfsDfs.TestDFS.Gate;

public class TestDFS {

	static int N, M, K, result, map[][];

	static class Gate {
		int r, c, t;

		public Gate(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Gate [r=" + r + ", c=" + c + ", t=" + t + "]";
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Gate> gates;

		for (int t = 1; t <= 55; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			gates = new LinkedList<>();

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 4) {
						gates.add(new Gate(i, j, 0));
//					visit[i][j] = true;
					}
				}
			}

			Gate tmp;
			boolean visit[][];
			result = Integer.MAX_VALUE;
			
			while (!gates.isEmpty()) {
				tmp = gates.poll();
				visit = new boolean[N][M];
//			visit[tmp.r][tmp.c] = true;
				dfs(tmp.r, tmp.c, tmp.t, visit);
			}
			sb.append("#").append(t).append(" ").append(result == Integer.MAX_VALUE ? -1 : result).append("\n");
//			System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		}
		System.out.println(sb);
	}

	private static void dfs(int r, int c, int t, boolean[][] v) {

//		System.out.println("[r,c,t]: ["+r+","+c+","+t+"]");
		if (t > K)	return;
		if (map[r][c] == 3) {
			result = Math.min(result, t);
			return;
		}

		v[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (inArea(nr, nc) && !v[nr][nc] && map[nr][nc] != 1) {
				if (map[nr][nc] == 2) {
					dfs(nr, nc, t + 2, v);
					v[nr][nc] = false;
				}
				else {
					dfs(nr, nc, t + 1, v);
					v[nr][nc] = false;
				}
			}
		}
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
