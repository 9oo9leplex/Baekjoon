package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10157 {
	
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()) + 1;
		int pick = Integer.parseInt(br.readLine());
		
		if(R*C <pick) {
			System.out.println(0);
			return;
		}
		
		int d = -1;
		int i = 0;
		int x = 0;
		int y = 1;
		int check = 1;
		
		while(check > 0) {
			d = (d + 1) % 4;
			
			if(d%2==0) R--;
			else C--;
			
			check = d % 2 == 0 ? R : C;
			for(int j=0;j<check;j++) {
				i++;
				x += dr[d];
				y += dc[d];
				if(i == pick) {
					System.out.println(y +" "+ x);
//					System.out.println(x +" "+ y);
					return;
				}
			}
		}
		
		
	}
}
