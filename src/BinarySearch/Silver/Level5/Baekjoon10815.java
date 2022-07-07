package BinarySearch.Silver.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10815 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int num;
		
		Arrays.sort(arr);
		
		while(st.hasMoreTokens()) {
			num = Integer.parseInt(st.nextToken());
			
			sb.append(binarysearch(n,num,arr)).append(" ");
		}
		System.out.println(sb);
	}

	private static int binarysearch(int n, int num,int[] arr) {

		int min = 0, max = n - 1;
		
		while(min <= max) {
			int idx = ( min + max ) / 2;
			int mid = arr[idx];
			
			if(mid > num) max = idx - 1;
			else if(mid < num) min = idx + 1;
			else return 1;
		}
		
		return 0;
	}
}
