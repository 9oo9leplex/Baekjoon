package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2579 {

	static int arr[],dp[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		dp = new int[n+1];
		
		for(int i=1;i<=n;i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = arr[1];
		if(n >= 2) dp[2] = arr[1] + arr[2];
		
		System.out.println(sol(n));
	}

	static int sol(int n) {
		if(n <= 2) return dp[n];
		
		for(int i=3;i<=n;i++) {
			dp[i] = arr[i] + Math.max(dp[i-2], dp[i-3]+arr[i-1]);
		}
		return dp[n];
	}
}
