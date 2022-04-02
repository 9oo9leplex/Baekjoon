package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,k,map[][],max;
	static Queue<int[]> apple;
	static class Snake{
		int r,c,dir;

		public Snake(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
			
		map = new int[n][n];
		apple = new LinkedList<>();
		
		StringTokenizer st;
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			apple.add(new int[] {r,c});		
		}
		
		int t = Integer.parseInt(br.readLine());
		
		Queue<Integer> time = new LinkedList<>();
		Queue<Character> dir = new LinkedList<>();
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			time.add(Integer.parseInt(st.nextToken()));
			dir.add(st.nextToken().charAt(0));
		}
		
		t = 0;
		char d;
		Snake snake = new Snake(0, 0, 3);
		while(true) {
			if(!inArea(snake.r,snake.c)) break;
//			System.out.println(t+", r: "+snake.r+", c: "+snake.c);
			// 자기몸에 부딪치면 사망
			if(!time.isEmpty() && t == time.peek()) {
				time.poll();
				switch(dir.poll()) {
				case 'L':
					snake.dir = (snake.dir + 1)%4;
					break;
				case 'D':
					snake.dir = snake.dir - 1 < 0 ? 3 : snake.dir - 1;
					break;
				}
			}
			
			snake.r += dr[snake.dir];
			snake.c += dc[snake.dir];
			
			t++;
		}
		System.out.println(t);
	}

	private static boolean inArea(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}
}
