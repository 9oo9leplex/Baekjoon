package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2670 {

	static int dp[],arr[];
	static int k,n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		n = Integer.parseInt(st.nextToken());
//		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[n+1];
		dp = new int[n+1];
		for(int i=1;i<n+1;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dp[1] = 1;
		int max = dp[1];
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
