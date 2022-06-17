package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16973 {

	static int N,M,map[][];
	static class Rectangle{
		int sr,sc,cnt;

		public Rectangle(int sr, int sc, int cnt) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Rectangle [sr=" + sr + ", sc=" + sc + ", cnt=" + cnt + "]";
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
		int h = Integer.parseInt(st.nextToken()) ;
		int w = Integer.parseInt(st.nextToken()) ;
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
		int nr,nc,tmp;
		boolean flag;
		
		while(!q.isEmpty()) {
			cur = q.poll();
//			System.out.println(cur);
			if(cur.sr == r && cur.sc == c) return cur.cnt;
			
			for(int i=0;i<4;i++) {
				
				nr = cur.sr + dr[i];
				nc = cur.sc + dc[i];
				
				if(!inArea(nr,nc) || visit[nr][nc] || map[nr][nc] == 1) continue;
				
//				System.out.println("[r,c]: ["+nr+","+nc+"]");
				flag = false;
				
				// 0 북, 2 남
				if(i%2 == 0) {
					tmp = nr;
					if(i > 0) tmp += (h-1);
					
					for(int j=0;j<w;j++) {
//						System.out.println("[r,c,area]: ["+(tmp)+","+(nc+j)+","+!inArea(tmp,nc+j)+"]");
						if(!inArea(tmp,nc+j) || map[tmp][nc+j] == 1) {
							flag = true;
							break;
						}
					}
				}
				// 1 동, 3 서
				else {
					tmp = nc;
					if(i == 1) tmp += (w-1);
					
					for(int j=0;j<h;j++) {
//						System.out.println("[r,c,area]: ["+(nr+j)+","+(tmp)+","+!inArea(nr+j,tmp)+"]");
						if(!inArea(nr+j,tmp) || map[nr+j][tmp] == 1) {
							flag = true;
							break;
						}
					}
				}
//				System.out.println();
				/*
				for(int j=0;j<h;j++) {
					for(int k=0;k<w;k++) {
//						System.out.println("[r,c,area]: ["+(nr+j)+","+(nc+k)+","+!inArea(nr+j,nc+k)+"]");
						if(!inArea(nr+j,nc+k) || map[nr+j][nc+k] == 1) {
							flag = true;
							break;
						}
					}
				}
				*/
				if(flag) continue;
				
				visit[nr][nc] = true;
				q.add(new Rectangle(nr, nc, cur.cnt+1));
				
				
			}
		}
		
		return -1;
	}



	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
