package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 19238
public class Main {

	static int N,M,map[][];
	static class Rectangle{
		int sr,sc,cnt;

		public Rectangle(int sr, int sc, int cnt) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.cnt = cnt;
		}
	}
	
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		int dr = Integer.parseInt(st.nextToken()) - 1;
		int dc = Integer.parseInt(st.nextToken()) - 1;
		
		System.out.println(bfs(h,w,sr,sc,dr,dc));
	}

	

	private static int bfs(int h, int w, int sr, int sc, int r, int c) {

		Queue<Rectangle> q = new LinkedList<>();
		q.add(new Rectangle(sr, sc, 0));
		
		boolean[][] visit = new boolean[N][M];
		visit[sr][sc] = true;
		
		Rectangle cur;
		int nr,nc,loop;
		boolean flag;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(cur.sr == r && cur.sc == c) return cur.cnt;
			
			for(int i=0;i<4;i++) {
				
				nr = cur.sr + dr[i];
				nc = cur.sc + dc[i];
				
				if(!inArea(nr,nc) || visit[nr][nc] || map[nr][nc] == 1) continue;
				
				flag = false;
				
				if(i%2 == 0) {
					loop = w;
					if(i > 0) nr += h;
					for(int j=0;j<loop;j++) {
						if(!inArea(nr,nc+j) || map[nr][nc+j] == 1) {
							flag = true;
							break;
						}
					}
				}
				else {
					loop = h;
					if(i == 1) nc += w;
					for(int j=0;j<loop;j++) {
						if(!inArea(nr+j,nc) || map[nr+j][nc] == 1) {
							flag = true;
							break;
						}
					}
				}
				
				if(flag) continue;
				
				q.add(new Rectangle(nr, nc, cur.cnt+1));
				
				
				
			}
		}
		
		return -1;
	}



	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}


















