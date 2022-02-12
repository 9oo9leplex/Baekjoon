package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baakjoon2193 {

	static long[] dp,arr;
	static int k,n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
	//	dp[2] = 1;
		System.out.println(sol(n));
		
		
	}

	static long sol(int cnt) {
		if(cnt < 2) return dp[cnt];
		
		for(int i=2;i<=n;i++)
			dp[i] = dp[i-2] + dp[i-1];
		//dp[cnt] = sol(cnt-1) + sol(cnt-2);
		return dp[cnt];
	}
}
