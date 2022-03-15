package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1037 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		if(n == 1) {
			System.out.println((int)Math.pow(Integer.parseInt(st.nextToken()), 2));
			return;
		}
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		System.out.println(arr[0] * arr[arr.length-1]);
	}

}
