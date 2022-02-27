package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beakjoon2309 {

	static int arr[];
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		
		for(int i=0;i<9;i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int cnt=0;
		int p[] = new int[9];
		int tmp[] = new int[7];
		while(++cnt <= 7)
			p[9-cnt] = 1;
		
		do {
			int sum = 0;
			cnt = 0;
			for(int i=0;i<9;i++) {
				if(p[i] == 1) {
					sum += arr[i];
					tmp[cnt++] = arr[i];
				}
			}
			if(sum == 100) break;
		}while(combination(p));
		
		Arrays.sort(tmp);
		StringBuilder sb = new StringBuilder();
		for(int a : tmp)
			sb.append(a).append("\n");
		System.out.println(sb);
		
	}
	private static boolean combination(int[] p) {
		int i = 8;
		while(i > 0 && p[i-1] >= p[i]) i--;
		if(i == 0) return false;
		int j = 8;
		while(p[i-1] >= p[j]) j--;
		swap(p,i-1,j);
		int k = 8;
		while(i<k)
			swap(p,i++,k--);
		return true;
	}
	private static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}

}
