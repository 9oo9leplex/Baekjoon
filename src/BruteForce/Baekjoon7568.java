package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon7568 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int p[][] = new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int result[] = new int[n];
		
		for(int i=0;i<n;i++) {
			int w = p[i][0];
			int h = p[i][1];
			
			for(int j=0;j<n;j++) {
				if(p[j][0] > w && p[j][1] > h) result[i]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a : result)
			sb.append(a+1).append(" ");
		System.out.println(sb);
	}

}
