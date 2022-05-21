package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1520 {

	static int N, M, map[][], dp[][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));

	}

	private static int dfs(int r, int c) {

		if (r == N-1 && c == M-1) return 1;
		if (dp[r][c] != -1) return dp[r][c];
		else {
			dp[r][c] = 0;

			int nr, nc;

			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];

				if (inArea(nr, nc) && map[r][c] > map[nr][nc])
					dp[r][c] += dfs(nr, nc);
			}
		}
		return dp[r][c];

	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
