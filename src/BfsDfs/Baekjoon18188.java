package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon18188 {

	static int N,M;
	static char[][] map;
	static class Point {
		int r,c,t;
		String m;
		public Point(int r, int c, int t, String m) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
			this.m = m;
		}
	}
	
	static class Restrict {
		String str;

		public Restrict(String str) {
			super();
			this.str = str;
		}
	}
	
	static Queue<Point> q;
	static Queue<Restrict> restrict;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static String answer = "";
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		int sr,sc,r,c;
		sr = sc = r = c = 0;
		char[] tmp;
		Point p;
		
		for(int i=0;i<N;i++) {
			tmp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j];
				
				if(map[i][j] == 'D') {
					sr = i;
					sc = j;
				}
				else if(map[i][j] == 'Z'){
					r = i;
					c = j;
				}
			}
		}
		
		int move = Integer.parseInt(br.readLine());
		p = new Point(sr,sc,move,"");
		
		q = new LinkedList<>();
		q.add(p);
		restrict = new LinkedList<>();
		String str;
		
		for(int i=0;i<move;i++) {
			st = new StringTokenizer(br.readLine());
			str = "";
			
			for(int j=0;j<2;j++) {
				str += st.nextToken().charAt(0);
			}
			
			restrict.add(new Restrict(str));
		}
		
		bfs(sr,sc,r,c);
		if(answer.equals("")) System.out.println("NO");
		else {
			System.out.println("YES");
			System.out.println(answer);
		}
	}

	private static void bfs(int sr, int sc, int r, int c) {

		
		Point cur;
		Restrict rest;
		int nr,nc,len,dir;
		char ch;
		
		while(!q.isEmpty()) {
			
			len = q.size();
			rest = restrict.poll();
			
			for(int i=0;i<len;i++) {
				cur = q.poll();
				
				if(cur.t == 0) {
					return;
				}
				
				for(int j=0;j<2;j++) {
					ch = rest.str.charAt(j);
					dir = 1;
					switch(ch) {
					case 'W':
						dir = 0;
						break;
					case 'A':
						dir = 3;
						break;
					case 'S':
						dir = 2;
						break;
					}
					
					nr = cur.r + dr[dir];
					nc = cur.c + dc[dir];
					
					if(inArea(nr,nc) &&  map[nr][nc] != '@') {
						
						q.add(new Point(nr, nc, cur.t-1, cur.m+ch));
						
						if(map[nr][nc] == 'Z') {
							answer = cur.m + ch;
							return;
						}
					}
				}
			}
		}
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
