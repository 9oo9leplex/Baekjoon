package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1463 {

	static int[] dp;
	//static int n,k;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		//n = Integer.parseInt(st.nextToken());
		//k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		//StringBuilder sb = new StringBuilder();
		
		dp = new int[n+3];
		dp[1] = 0; 
		dp[2] = dp[3] = 1;
		
		System.out.println(sol(n));
	}
	
	static int sol(int cnt) {
		if(cnt == 1) return 0;
		if(cnt < 4) return 1;

		for(int i=4;i<=cnt;i++) {
			int a = Integer.MAX_VALUE;
			int b = a, c= a;
			
			if(i % 3 == 0) a = dp[i/3]; 
			if(i % 2 == 0) b = dp[i/2];
			c = dp[i-1];
			
			a = Math.min(a, b);
			dp[i] = Math.min(a, c) + 1;
		}
		return dp[cnt];
	}

}
