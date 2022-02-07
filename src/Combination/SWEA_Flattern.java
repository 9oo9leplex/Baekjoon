package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Flattern {

	static int arr[], N, max, min;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = new int[100];
		
		for(int t=0;t<10;t++) {
			N = Integer.parseInt(br.readLine());
			max = 0;
			min = 100;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<100;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = max <= arr[i] ? i : max;
				min = min >= arr[i] ? i : min;
			}
			
			flattern(0);
			sb.append("#").append(t+1).append(" ").append(arr[max]-arr[min]).append("\n");			
		}
		System.err.println(sb);
	}

	static void flattern(int cnt) {
		
		if(cnt == N || arr[max]-1 == arr[min]) {
			return;
		}
		
		arr[max]--;
		arr[min]++;
		
		for(int i=0;i<100;i++) {
			max = arr[max] <= arr[i] ? i : max;
			min = arr[min] >= arr[i] ? i : min;
		}
		flattern(cnt+1);
	}
	
	
	
	
	
	
	
	
}
