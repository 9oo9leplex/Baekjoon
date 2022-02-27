package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2491 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		int[] dm = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for(int i=1;i<=n;i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int max = 1;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			if(arr[i] >= arr[i-1]) dp[i] = dp[i-1] + 1;
			else dp[i] = 1;
			max = Math.max(max, dp[i]);
		}
		dm[1] = 1;
		for(int i=2;i<=n;i++) {
			if(arr[i] <= arr[i-1]) dm[i] = dm[i-1] + 1;
			else dm[i] = 1;
			max = Math.max(max, dm[i]);
		}
		System.out.println(max);
		
	}

}
