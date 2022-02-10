package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16395 {

	static int[][] dp;
	static int n,k;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		//int n = Integer.parseInt(br.readLine());
		//StringBuilder sb = new StringBuilder();
		dp = new int[n][n];
		
		sol(0);
		System.out.println(dp[n-1][k-1]);
	}
	
	static void sol(int cnt) {
		
		if(cnt == n) return;
		dp[cnt][0] = dp[cnt][cnt] = 1;
		for(int i=1;i<cnt;i++) {
			dp[cnt][i] = dp[cnt-1][i-1] + dp[cnt-1][i];
		}
		
		sol(cnt+1);
		
	}

}
