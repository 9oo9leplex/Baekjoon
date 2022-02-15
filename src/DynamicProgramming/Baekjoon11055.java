package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11055 {

	static int dp[],arr[];
	static int k,n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		n = Integer.parseInt(st.nextToken());
//		k = Integer.parseInt(st.nextToken());
//		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dp[1] = arr[1];
		int max = dp[1];
		
		for(int i=1;i<=n;i++) {
			dp[i] = arr[i];
			for(int j=1;j<i;j++) {
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
