package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501 {

	static int dp[][],arr[];
	static int k,n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1][2];
		arr = new int[n+2];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(sol());
		
	}

	static int sol() {
		
		for(int i=n;i>0;i--) {
			int index = dp[i][0] + i;
			if(index > n+1) {
				arr[i] = arr[i+1];
			}
			else {
				arr[i] = Math.max(arr[i+1], dp[i][1]+arr[index]);
			}
		}
		
		
		
		return arr[1];
	}

}
