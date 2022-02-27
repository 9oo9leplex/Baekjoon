package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2578 {

	static int cnt;
	static int[][] bingo;
	static boolean[][] board;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		bingo = new int[5][5];
		board = new boolean[5][5];
		q = new LinkedList<>();

		for (int j = 0; j < 5; j++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < 5; k++) {
				bingo[j][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		cnt = 0;
		while (!q.isEmpty()) {
			int pick = q.poll();
			
			pick(pick);
			
			if(cnt >= 12) {
				int q,w,e,r;
				q = w = e = r = 0;
				boolean a,b;
				a = b = true;
				for(int i=0;i<5;i++) {
					boolean row,col;
					row = col = true;
					for(int j=0;j<5;j++) {
						if(!board[i][j]) row = false;
						if(!board[j][i]) col = false;
						if(i==0) {
							if(!board[j][j]) a = false;
							if(!board[j][4-j]) b = false;
						}
					}
					if(row) q++; 
					if(col) w++;
					if(i == 0) {
						if(a) e++;
						if(b) r++;
					}

					if(q+w+e+r >= 3) {
						System.out.println(cnt);
						return;
					}
				}
			}
		}
	}

	private static void pick(int pick) {

		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(bingo[i][j] == pick) {
					board[i][j] = true;
					cnt++;
					return;
				}
			}
		}
		
	}

}
