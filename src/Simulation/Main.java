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
	
	static boolean[][][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C][4];
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
		
		int cnt = aircon.size();
		int nr,nc,dir;
		boolean flag;
		
		while(!aircon.isEmpty()) {
			int[] now = aircon.poll();
//			route.add(new int[] {now[0], now[1]});
			
//			if(visit[now[0]][now[1]]) continue;
//			visit[now[0]][now[1]] = true;
			
			
			for(int i=0;i<4;i++) {
				dir = i;
				nr = now[0];
				nc = now[1];
				
				
//				for(int j=0;j<20;j++) {
				while(true) {
					nr += dr[dir];
					nc += dc[dir];
					flag = true;
					if(!inArea(nr,nc)) break;
					if(visit[nr][nc][dir]) break;
					
					for(int j=0;j<4;j++) {
						if(visit[nr][nc][j]) flag = false;
					}
					
					if(flag) cnt++;
					
					System.out.println("[nr,nc,dir,cnt]: "+nr+","+nc+","+dir+","+cnt+"]");
					visit[nr][nc][dir] = true;
					
					
					if(map[nr][nc] == 0 || map[nr][nc] == 9) continue;
					
					if(dir == 0) {
						if(map[nr][nc] == 1) dir = 0;
						else if(map[nr][nc] == 2 ) dir = 2;
						else if(map[nr][nc] == 3) dir = 1;
						else dir = 3;
					}
					else if(dir == 1) {
						if(map[nr][nc] == 1) dir = 3;
						else if(map[nr][nc] == 2) dir = 1;
						else if(map[nr][nc] == 3) dir = 0;
						else dir = 2;
					}
					else if(dir == 2) {
						if(map[nr][nc] == 1) dir = 2;
						else if(map[nr][nc] == 2) dir = 0;
						else if(map[nr][nc] == 3) dir = 3;
						else dir = 1;
					}
					else {
						if(map[nr][nc] == 1) dir = 1;
						else if(map[nr][nc] == 2) dir = 3;
						else if(map[nr][nc] == 3) dir = 2;
						else dir = 0;
					}
					// dir == 0 && map[nr][nc] == 1 => dir = 0
					// dir == 0 && map[nr][nc] == 2 => dir = 2
					// dir == 0 && map[nr][nc] == 3 => dir = 1
					// dir == 0 && map[nr][nc] == 4 => dir = 3
					
					// dir == 1 && map[nr][nc] == 1 => dir = 3
					// dir == 1 && map[nr][nc] == 2 => dir = 1
					// dir == 1 && map[nr][nc] == 3 => dir = 0
					// dir == 1 && map[nr][nc] == 4 => dir = 2
					
					// dir == 2 && map[nr][nc] == 1 => dir = 2
					// dir == 2 && map[nr][nc] == 2 => dir = 0
					// dir == 2 && map[nr][nc] == 3 => dir = 3
					// dir == 2 && map[nr][nc] == 4 => dir = 1
					
					// dir == 3 && map[nr][nc] == 1 => dir = 1
					// dir == 3 && map[nr][nc] == 2 => dir = 3
					// dir == 3 && map[nr][nc] == 3 => dir = 2
					// dir == 3 && map[nr][nc] == 4 => dir = 0
				}
				System.out.println("cnt: "+cnt);
			}
		}
		return cnt;
	}


	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}









