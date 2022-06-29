package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1941 {

	static char[][] map;
	static int num[], answer;
	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static boolean[] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		for(int i=0;i<5;i++) map[i] = br.readLine().toCharArray();
		
		num = new int[7];
		
		combination(0,0,0);
		
		System.out.println(answer);
	}
	private static void combination(int start, int cnt, int group) {

		if(cnt - group > 3) return;
		
		if(cnt == 7) {
			visit = new boolean[7];
			visit[0] = true;
			check(num[0]/5,num[0]%5);
			return;
		}
		
		for(int i=start;i<25;i++) {
			int r = i / 5, c = i % 5;
			num[cnt] = i;
			combination(i+1, cnt+1, map[r][c] == 'S' ? group+1 : group);
		}
	}
	private static void check(int r, int c) {
		
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(r, c));
		
		Point cur;
		int nr,nc,cnt = 1,idx;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int i=0;i<4;i++) {
				
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(!inArea(nr,nc)) continue;
				
				idx = nr * 5 + nc;
				
				for(int j=0;j<7;j++) {
					if(!visit[j] && idx == num[j] ) {
						visit[j] = true;
						q.add(new Point(nr, nc));
						cnt++;
					}
				}
			}
		}
		if(cnt == 7) answer++;
		
	}
	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < 5 && nc >= 0 && nc < 5;
	}
}
