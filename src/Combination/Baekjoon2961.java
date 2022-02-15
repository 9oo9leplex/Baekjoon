package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2961 {

	static int b[], s[] ,numbers[], n;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		b = new int[n];
		s = new int[n];

		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}

		int ms = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int cnt = 0;
			numbers = new int[n];
			while(++cnt <= (i+1)) numbers[n-cnt] = 1;
			
			do {
				int ts = 1, tb = 0;
				for(int j=0;j<n;j++) {
					if(numbers[j] == 1) {
						ts *= s[j];
						tb += b[j];
					}
				}
				ms = Math.min(ms, Math.abs(ts-tb));
			}while(sol(numbers));
		}
		System.out.println(ms);
	}

	private static boolean sol(int[] p) {
		
		int i = n-1;
		while(i > 0 && p[i-1] >= p[i]) i--;
		
		if(i==0) return false;
		
		int j = n-1;
		while(p[i-1] >= p[j]) j--;
		
		swap(p,i-1,j);
		
		int k = n-1;
		while(i<k)
			swap(p,i++,k--);
		
		return true;
	}

	private static void swap(int[] p,int i, int j) {
		int swap = p[i];
		p[i] = p[j];
		p[j] = swap;
	}

}
