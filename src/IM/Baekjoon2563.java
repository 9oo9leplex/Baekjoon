package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2563 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[101][101];
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			for(int r=row;r<row+10;r++) {
				for(int c=col;c<col+10;c++) {
					map[r][c] = 1;
				}
			}
		}
		int sum=0;
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				if(map[i][j] == 1)
					sum += 1;
			}
		}
		System.out.println(sum);
	}

}
