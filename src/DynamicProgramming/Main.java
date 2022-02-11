package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp,arr;
	static int k,n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		System.out.println(sol(n));
		
		
	}

	static int sol(int cnt) {
		if(dp[cnt] != 0) return dp[cnt];
		
		for(int i=2;i<=n;i++)
			dp[i] = dp[i-2] + dp[i-1];
		return dp[cnt];
	}
}
