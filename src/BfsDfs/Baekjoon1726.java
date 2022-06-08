package BFS.gold.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1726 {

	static int N,M,map[][];
	static class Robot{
		int r,c,dir,cnt;

		public Robot(int r, int c, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}
	
	static Robot start,end;
	//방향 동1, 서2, 남3, 북4
	//설정 북1, 동2, 남3, 서4
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
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
		
		//방향 동0, 서1, 남2, 북3
		//설정 북0, 동1, 남2, 서3
		int r,c,dir;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		dir = Integer.parseInt(st.nextToken()) - 1;
		dir = changeDir(dir);
		
		start = new Robot(r,c,dir,0);
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		dir = Integer.parseInt(st.nextToken()) - 1;
		dir = changeDir(dir);
		
		end = new Robot(r,c,dir,0);
	
		if(N == 1 && M == 1) {
			System.out.println( start.dir == end.dir ? 0 : (start.dir+end.dir)%2 == 0 ? 2 : 1);
			return;
		}
		
		bfs();
	}

	private static int changeDir(int dir) {
		//방향 동0, 서1, 남2, 북3
		//설정 북0, 동1, 남2, 서3
		
		switch(dir) {
		case 0: return 1;
		case 1: return 3;
		case 3: return 0;
		default: return 2;
		}
	}

	private static void bfs() {

		Queue<Robot> q = new LinkedList<>();
		q.add(start);
		
		boolean[][][] visit = new boolean[N][M][4];
		visit[start.r][start.c][start.dir] = true;
		
		Robot cur;
		int nr,nc,val;
		
		while(!q.isEmpty()) {
			
			cur = q.poll();
//			System.out.println(cur);
			if(cur.r == end.r && cur.c == end.c && cur.dir == end.dir) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int i=1;i<=3;i++) {
				
				nr = cur.r + dr[cur.dir] * i;
				nc = cur.c + dc[cur.dir] * i;
				
//				if(inArea(nr,nc) && !visit[nr][nc][cur.dir] && map[nr][nc] != 1 ) {
				if(!inArea(nr,nc)) continue;
				
				if(map[nr][nc] == 0 ) {
					if(!visit[nr][nc][cur.dir]) {
						q.add(new Robot(nr,nc,cur.dir,cur.cnt+1));
						visit[nr][nc][cur.dir] = true;							
					}
				}
				else break;
			}
			
			for(int i=0;i<4;i++) {
				
				if(cur.dir == i) continue;
				val = 0;
				
				if(( cur.dir + i) % 2 == 0) val = 2;
				else val = 1;
				
				if(!visit[cur.r][cur.c][i]) {
					q.add(new Robot(cur.r,cur.c,i,cur.cnt+val));
					visit[cur.r][cur.c][i] = true;
				}
			}
		}
        
		
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
