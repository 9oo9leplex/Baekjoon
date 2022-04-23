package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C,map[][];
	static Queue<int[]> aircon;
	
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		aircon = new LinkedList<>();
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) aircon.add(new int[] {i,j});
			}
		}
		
		System.out.println( aircon.size() > 0 ? bfs() : 0);
	}


	private static int bfs() {
		
		int cnt = 0;
		int nr,nc,dir;
		
		while(!aircon.isEmpty()) {
			int[] now = aircon.poll();
			
			if(!visit[now[0]][now[1]]) {
				visit[now[0]][now[1]] = true;
				cnt++;
			}
			
			
			for(int i=0;i<4;i++) {
				dir = i;
				nr = now[0];
				nc = now[1];
				
				while(true) {

					nr += dr[dir];
					nc += dc[dir];
					
					if(!inArea(nr,nc)) break;
					if( dir == 0 || dir == 2) {
						 if(map[nr][nc] == 2 ) {
							 if(!visit[nr][nc]) {
								 visit[nr][nc] = true;
								 cnt++;
							 }						
							 break;
						 }
					} else {
						if(map[nr][nc] == 1) {
							if(!visit[nr][nc]) {
								visit[nr][nc] = true;
								cnt++;
							}
							break;
						}
					}
					
					if(map[nr][nc] != 0 && map[nr][nc] != 9) {
						
						if(dir == 0) {
							if(map[nr][nc] == 3) dir = 1;
							else if(map[nr][nc] == 4) dir = 3;
						}
						else if(dir == 1) {
							if(map[nr][nc] == 3) dir = 0;
							else if(map[nr][nc] == 4) dir = 2;
						}
						else if(dir == 2) {
							if(map[nr][nc] == 3) dir = 3;
							else if(map[nr][nc] == 4) dir = 1;
						}
						else {
							if(map[nr][nc] == 3) dir = 2;
							else if(map[nr][nc] == 4) dir = 0;
						}
					}
					
					if(!visit[nr][nc]) {
						visit[nr][nc] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}


	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}









