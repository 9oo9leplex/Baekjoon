package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2458 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int map[][] = new int[n][n];
		int max = n * (n * (n - 1) / 2);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				map[i][j] = max;
		}

		int first, second;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			first = Integer.parseInt(st.nextToken()) - 1;
			second = Integer.parseInt(st.nextToken()) - 1;
			map[first][second] = 1;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (map[i][j] < max || map[j][i] < max)
					cnt++;
			}
			if (cnt == n - 1)
				result++;
		}

		System.out.println(result);
	}
}
