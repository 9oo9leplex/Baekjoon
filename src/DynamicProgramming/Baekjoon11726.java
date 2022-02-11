package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11726 {

	static int[] dp;
	static int k;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// StringTokenizer st = new StringTokenizer(br.readLine());
		// n = Integer.parseInt(st.nextToken());
		// k = Integer.parseInt(st.nextToken());
		//StringBuilder sb = new StringBuilder();
		dp = new int[1001];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		System.out.println(sol(n));
	}

	static int sol(int cnt) {
		if (dp[cnt] != 0) return dp[cnt];
		
		for(int i=4;i<=cnt;i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			dp[i]%=10007;
		}
			
		return dp[cnt];
	}

}
