package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17626 {

	static int[] dp;
	static int min;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//StringBuilder sb = new StringBuilder();
		dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		solve(n);
		System.out.println(dp[n]);
	}
	
	static void solve(int n) {
		for(int i=2;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				min = Math.min(min, dp[i-j*j]);
			}
			dp[i] = min + 1;
		}
	}

}
