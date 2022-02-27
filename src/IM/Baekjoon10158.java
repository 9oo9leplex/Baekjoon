package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10158 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken()); 
		int row = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
	
		int x = (col+t) % (2*c);
		int y = (row+t) % (2*r);
		
		x = c - Math.abs(c-x);
		y = r - Math.abs(r-y);
		
		System.out.println(x+" "+y);
	}

}
