package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14696 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String who;
		
		int len;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			int[] a = new int[5];
			for(int j=1;j<=len;j++)
				a[Integer.parseInt(st.nextToken())]++;
			
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			int[] b = new int[5];
			for(int j=1;j<=len;j++)
				b[Integer.parseInt(st.nextToken())]++;
			
			who = "D";
			for(int j=4;j>0;j--) {
				if(a[j] > b[j]) {
					who = "A"; 
					break;
				} else if(a[j] < b[j]) {
					who = "B";
					break;
				}
			}
			sb.append(who).append("\n");
		}
		System.out.println(sb);
	}

}
