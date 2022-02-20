package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {		
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		if(arr.length == 0) {
			System.out.println("?");
			return;
		}
		//System.out.println(arr);
		int[] dp = new int[26];
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] >= 'a') dp[arr[i] - 'a']++;
			else dp[arr[i] - 'A']++;
		}
		System.out.println(Arrays.toString(dp));
		int max = Integer.MIN_VALUE;
		char c = '?';
		for(int i=0;i<26;i++) {
//			if(dp[i] == 0) continue;
			//System.out.println("i: "+i+", max: "+max+", dp: "+dp[i]);
			if(max == dp[i]) {
				c = '?';
			} else if(max < dp[i]) {
				c = (char) (i+65);
				max = dp[i];
			}
		}
		System.out.println(c);
		
	}
}
