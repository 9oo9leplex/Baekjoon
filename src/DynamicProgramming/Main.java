package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static double[] dp,result;
	static double r;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//StringBuilder sb = new StringBuilder();
		dp = new double[n];
		result = new double[n];
		r = 0;
		for(int i=0;i<n;i++)
			dp[i] = Double.parseDouble(br.readLine());
		result[0] = dp[0];
		solve(n);
		
		System.out.printf("%.3f",r);
	}
	
	static void solve(int n) {
		
		for(int i=1;i<n;i++) {
			double max = dp[i];
			//for(int j=1;j<=i;j++) {
			max = Math.max(max, dp[i]* Math.max(dp[i-1], result[i-1]));
			//}
			result[i] = max;
			r = r > max ? r : max;
		}
	}
}
