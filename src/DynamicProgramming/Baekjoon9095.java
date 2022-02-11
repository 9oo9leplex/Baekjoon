package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9095 {

	static int[] dp;
	static int k;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// StringTokenizer st = new StringTokenizer(br.readLine());
		// n = Integer.parseInt(st.nextToken());
		// k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		dp = new int[12];
		for (int i = 0; i < n; i++) {
			k = Integer.parseInt(br.readLine());
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			// dp[4] = 7;
			// dp[5] = 13;
			
			sb.append(sol(k)).append("\n");
		}
		System.out.println(sb);
	}

	static int sol(int cnt) {
		if (dp[cnt] != 0) return dp[cnt];
		
		for(int i=4;i<=cnt;i++)
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		return dp[cnt];
	}

}
