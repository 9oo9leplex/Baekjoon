package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2606 {

	static int n, k, result = 0,map[][];
	static boolean visit[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

//		boolean[][] map = new boolean[r][c];
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			map[start][end] = map[end][start]= 1;
		}
		
		dfs(1);
		System.out.println(result - 1);
	}

	private static void dfs(int start) {

		visit[start] = true;
		result++;
		
		for(int i=1;i<=n;i++) {
			if(map[start][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

}
