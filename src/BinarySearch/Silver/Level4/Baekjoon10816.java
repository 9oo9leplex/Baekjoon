package BinarySearch.Silver.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10816 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int key;
		
		for(int i=0;i<m;i++) {
			key = Integer.parseInt(st.nextToken());
			sb.append(upper(key,n,arr) - lower(key,n,arr)).append(" ");
		}
		System.out.println(sb);
	}

	private static int lower(int key, int n, int[] arr) {
		int min = 0, max = n;
		
		while(min < max) {
			
			int mid = ( min + max ) / 2;
			if(key <= arr[mid]) max = mid;
			else min = mid + 1;
		}
		
		return min;
	}

	private static int upper(int key, int n, int[] arr) {
		
		int min = 0, max = n;
		
		while(min < max) {
			
			int mid = ( min + max ) / 2;
			if(key < arr[mid]) max = mid;
			else min = mid + 1;
		}
		
		return min;
	}
}
