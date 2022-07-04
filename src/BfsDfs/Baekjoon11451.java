package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11451 {

	static int N,M;
	static char[][] map;
	static class PackMan {
		int r,c,cnt;
		String str;
		
		public PackMan() {
			super();
		}
		
		public PackMan(int r, int c, int cnt, String str) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.str = str;
		}
		@Override
		public String toString() {
			return "PackMan [r=" + r + ", c=" + c + ", cnt=" + cnt + ", str=" + str + "]";
		}
	}
	static Queue<PackMan> q;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[] d = {'N','S','W','E'};
	static boolean[][][][] visit;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PackMan cur = new PackMan();
		
		for(int t=0;t<tc;t++) {
			if(sb.length() > 0) sb.append("\n");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];	
			q = new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0;j<M;j++) {
					if(map[i][j] == 'P') {
						q.add(new PackMan(i, j, 0, ""));
						map[i][j] = '.';
					}
				}
			}
			visit = new boolean[N][M][N][M];
			cur = bfs();
			if(cur == null) sb.append("IMPOSSIBLE");
			else sb.append(cur.cnt).append(" ").append(cur.str);
		}
		System.out.println(sb);
	}

	private static PackMan bfs() {
		
		PackMan p1,p2;
		int p1r,p1c,p2r,p2c;
		
		while(!q.isEmpty()) {
			
			p1 = q.poll();
			p2 = q.poll();
			
//			if(visit[p1.r][p1.c][p2.r][p2.c]) continue;
			
//			visit[p1.r][p1.c][p2.r][p2.c] = true;
			
			if(p1.r == p2.r && p1.c == p2.c) {
				
//				System.out.println(p1.cnt+" "+p1.str);
				return p1;
			}
			
			for(int i=0;i<4;i++) {
				
				p1r = (p1.r + dr[i] + N) % N;
				p1c = (p1.c + dc[i] + M) % M;
				p2r = (p2.r + dr[i] + N) % N;
				p2c = (p2.c + dc[i] + M) % M;
//				
//				p1r = inArea(p1r,N);
//				p2r = inArea(p2r,N);
//				p1c = inArea(p1c,M);
//				p2c = inArea(p2c,M);
				
//				p1r = (p1.r + dr[i] + N) % N;
//				p1c = (p1.c + dc[i] + M) % M;
//				p2r = (p2.r + dr[i] + N) % N;
//				p2c = (p2.c + dc[i] + M) % M;
				
				if(map[p1r][p1c] == 'X') {
					p1r = p1.r;
					p1c = p1.c;
				}
				
				if(map[p2r][p2c] == 'X') {
					p2r = p2.r;
					p2c = p2.c;
				}
				
				if(visit[p1r][p1c][p2r][p2c] || map[p1r][p1c] == 'G' || map[p2r][p2c] == 'G') continue;
				visit[p1r][p1c][p2r][p2c] = true;
				
				q.add(new PackMan(p1r,p1c,p1.cnt+1,p1.str+d[i]));
				q.add(new PackMan(p2r,p2c,p2.cnt+1,p2.str+d[i]));
				

			}
		}
		return null;
//		System.out.println("IMPOSSIBLE");
	}
}
