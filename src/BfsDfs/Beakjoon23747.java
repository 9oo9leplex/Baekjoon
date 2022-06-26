package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjoon23747 {

	static int N,M;
	static char[][] map, m;
	static class Point {
		int r,c;
		char ch;
		public Point(int r, int c, char ch) {
			super();
			this.r = r;
			this.c = c;
			this.ch = ch;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", ch=" + ch + "]";
		}
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		
		char[] order = br.readLine().toCharArray();
		
		Queue<Point> q = new LinkedList<>();
		
		for(char c : order) {
			
			switch(c) {
			case 'W':
				q.add(new Point(sr,sc,map[sr][sc]));
				break;
			case 'L':
				sc -= 1;
				break;
			case 'U':
				sr -= 1;
				break;
			case 'D':
				sr += 1;
				break;
			case 'R':
				sc += 1;
				break;
			}
		}
		
		m = new char[N][M];
		for(int i=0;i<N;i++) Arrays.fill(m[i], '#');
		
		int nr,nc;
		m[sr][sc] = '.';
		for(int i=0;i<4;i++) {
			nr = sr + dr[i];
			nc = sc + dc[i];
			
			if(inArea(nr,nc)) m[nr][nc] = '.';
		}
		
		bfs(q);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(m[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(Queue<Point> q) {
		
		boolean[][] visit = new boolean[N][M];
		
		Point cur;
		int nr,nc;
		
		while(!q.isEmpty()) {
			
			cur = q.poll();

			if(visit[cur.r][cur.c]) continue;
			
			visit[cur.r][cur.c] = true;
			m[cur.r][cur.c] = '.';
			
			for(int i=0;i<4;i++) {
				
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(inArea(nr,nc) && !visit[nr][nc] && map[nr][nc] == cur.ch) {
					q.add(new Point(nr, nc, cur.ch));
					m[nr][nc] = '.';
				}
			}
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
