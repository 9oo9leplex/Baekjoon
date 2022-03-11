package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int[n];
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];
		if(n > 1) dp[1] = arr[1];
		if(n > 2) dp[2] = arr[2] + Math.max(arr[0],arr[1]);
		
		if(n <= 3) {
			System.out.println(n == 1 ? dp[0] : n == 2 ? dp[0] + dp[1] : Math.max(dp[1], dp[2]));
			return;
		}
		
		for(int i=3;i<n;i++) {
			dp[i] = arr[i] + Math.max(dp[i-3]+arr[i-2], dp[i-3]+arr[i-1]);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(Math.max(dp[n-2], dp[n-1]));
	}
}
