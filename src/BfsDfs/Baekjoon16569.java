package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16569 {

	static int N,M,V,map[][],v[][];
	static boolean[][] visit,volcano;
	static class Point{
		int r,c,t;

		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		
		map = new int[N][M];
		v = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				v[i][j] = Integer.MAX_VALUE;
			}
		}
		
		volcano = new boolean[N][M];
		int x,y,t;
		Queue<Point> q = new LinkedList<>();
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			t = Integer.parseInt(st.nextToken());
			
			q.add(new Point(x, y));
			volcano[x][y] = true;
			v[x][y] = t;
		}
		
		Point cur;
		int nr,nc;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int i=0;i<4;i++) {
				
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(!inArea(nr,nc) || v[nr][nc] <= v[cur.r][cur.c] + 1 ) continue;
				
				q.add(new Point(nr, nc));
				v[nr][nc] = v[cur.r][cur.c] + 1; 
			}
		}
		
		q.clear();
		q.add(new Point(r, c,0));
		
		visit = new boolean[N][M];
		visit[r][c] = true;
		
		int mh = 0, mt = 0;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(mh < map[cur.r][cur.c]) {
				mh = map[cur.r][cur.c];
				mt = cur.t;
			} else if(mh == map[cur.r][cur.c] && mt > cur.t) {
				mt = cur.t;
			}
			
			for(int i=0;i<4;i++) {
				
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(!inArea(nr, nc) || visit[nr][nc] || volcano[nr][nc] || v[nr][nc] <= cur.t + 1) continue;
				
				q.add(new Point(nr, nc,cur.t+1));
				visit[nr][nc] = true;
			}
		}
		System.out.println(mh+" "+mt);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
