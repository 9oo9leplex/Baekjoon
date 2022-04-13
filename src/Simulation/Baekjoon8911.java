package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon8911 {

	static int maxR,minR,maxC,minC;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	static class Turtle{
		int r,c,dir;

		public Turtle(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char[] arr;
		Turtle t;
		int len;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			
			arr = br.readLine().toCharArray();
			// 0 북, 1 동, 2 남, 3 서
			t = new Turtle(0, 0, 0);
			len = arr.length;
			maxR = maxC = minR = minC = 0;
			
			for(int j=0;j<len;j++) {
				switch(arr[j]) {
				case 'F':
					t.r += dr[t.dir];
					t.c += dc[t.dir];
					update(t.r,t.c);
					break;
				case 'B':
					t.r -= dr[t.dir];
					t.c -= dc[t.dir];
					update(t.r,t.c);
					break;
				case 'L':
					t.dir -= 1;
					if(t.dir < 0) t.dir = 3;
					break;
				case 'R':
					t.dir = (t.dir+1)%4;
					break;
				}
			}
			sb.append(Math.abs(maxR-minR) * Math.abs(maxC-minC)).append("\n");
		}
		System.out.println(sb);
	}

	private static void update(int r, int c) {
		maxR = Math.max(maxR, r);
		maxC = Math.max(maxC, c);
		minR = Math.min(minR, r);
		minC = Math.min(minC, c);		
	}

}










