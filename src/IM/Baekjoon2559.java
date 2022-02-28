package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2559 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] dp = new int[n-day+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int i=0;i<day;i++)
			sum += arr[i];
		dp[0] = sum;
		int max = dp[0];
		for(int i=1;i<n-day+1;i++) {
			sum = sum - arr[i-1] + arr[day-1+i];
			dp[i] = sum;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
