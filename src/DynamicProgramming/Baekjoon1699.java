package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1699 {

	static int[] dp,arr;
	static int k,n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
	//	dp[2] = 1;
		System.out.println(sol(n));
		
		
	}

	static int sol(int cnt) {
		if(cnt < 2) return cnt;
		
		for(int i=2;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++)
				min = Math.min(min, dp[i-j*j]);
				// dp[i-j*j], dp[i-1-j]
			dp[i] = min + 1;
		}
		
		return dp[cnt];
	}

}
