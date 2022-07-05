package BinarySearch.Silver.Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1654 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
//		st = new StringTokenizer(br.readLine());
		
		long min = 0, max = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if(max < arr[i]) max = arr[i];
		}
		
		max++;
		
		while(min < max) {
			long mid = (min + max) / 2;
			long sum = 0;
			
			for(int cur : arr) {
				sum += cur / mid;  
			}
			
			if(sum < M) max = mid;
			else min = mid + 1;
		}
		
		System.out.println(min-1);
	}	
}
