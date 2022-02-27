package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2669 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int[][] map = new int[101][101];
		
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			int xstart = Integer.parseInt(st.nextToken());
			int ystart = Integer.parseInt(st.nextToken());
			int xend = Integer.parseInt(st.nextToken());
			int yend = Integer.parseInt(st.nextToken());
			
			
			for(int x=xstart;x<xend;x++) {
				for(int y=ystart;y<yend;y++) {
					map[x][y] = 1;
				}
			}
		}
		int sum = 0;
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				if(map[i][j] == 1) sum++;
			}
		}
		
		System.out.println(sum);
	}

}
