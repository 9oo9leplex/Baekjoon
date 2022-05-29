package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon17425 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		long[] dp = new long[1000001];
		long[] fx = new long[1000001];
		
		Arrays.fill(fx, 1);
		int len = fx.length;
		
		for(int i=2;i<len;i++) {
			for(int j=1;j*i<len;j++)
				fx[i*j] += i;
		}
		
		for(int i=1;i<len;i++)
			dp[i] = dp[i-1] + fx[i];
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<tc;i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}

}
