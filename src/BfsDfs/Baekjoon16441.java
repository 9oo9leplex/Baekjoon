package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16441 {

	static int N,M;
	static char[][] map;
	static class Wolf {
		int r,c;

		public Wolf(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Wolf [r=" + r + ", c=" + c + "]";
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
		Queue<Wolf> q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j] == 'W') {
					q.add(new Wolf(i, j));
//					map[i][j] = '.';
				}
			}
		}
		
		System.out.println(bfs(q));
		
	}

	private static String bfs(Queue<Wolf> q) {

		boolean[][] visit = new boolean[N][M];
		
		Wolf cur;
		int nr,nc;
		
		while(!q.isEmpty()) {
			
			cur = q.poll();
			
			visit[cur.r][cur.c] = true;
			
			for(int i=0;i<4;i++) {
				
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(inArea(nr,nc) && !visit[nr][nc] && map[nr][nc] != '#') {
					if(map[nr][nc] != '+') {
						visit[nr][nc] = true;
						q.add( new Wolf(nr, nc));
					}
					else {
//						idx = 1;
						while(true) {
						
							nr += dr[i];// * idx;
							nc += dc[i];// * idx++;
							
							if(map[nr][nc] == '#') {
								if(visit[nr-=dr[i]][nc-=dc[i]]) break;
								visit[nr][nc] = true;
								q.add(new Wolf(nr, nc));
								break;
							} else if(map[nr][nc] == '.') {
								if(visit[nr][nc]) break;
								visit[nr][nc] = true;
								q.add(new Wolf(nr, nc));
								break;
							}
							
							
						}
						
						
					}
					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == '.' && !visit[i][j]) {
					map[i][j] = 'P';
				}
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
