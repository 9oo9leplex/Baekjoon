package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13300 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		
		int[][] p = new int[7][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			p[grade][sex]++;
		}

		int r = 0;
		for(int i=1;i<=6;i++) {
			int female = p[i][0]%max == 0 ? p[i][0]/max : p[i][0]/max+1; 
			int male = p[i][1]%max == 0 ? p[i][1]/max : p[i][1]/max+1;
			r += (female + male);
		}
		System.out.println(r);
	}

}
