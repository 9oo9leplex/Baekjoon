package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7569 {

	static int map[][][] , n, m, h, result;
	static boolean visit[][][];
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] dh = {-1,1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[n][m][h];
		visit = new boolean[n][m][h];
		q = new LinkedList<int[]>();
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<m;k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if(map[j][k][i] == 1) q.add(new int[] {j,k,i});
				}
			}
		}
		
		int day = bfs();
		System.out.println(check()?day-1:-1);
	}

	private static boolean check() {
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(map[j][k][i] == 0) return false;
				}
			}
		}
		return true;
	}

	private static int bfs() {

		int day = 0;
		while(!q.isEmpty()) {
			int len = q.size();
			int cnt = 0;
			
			while(len > cnt) {
				int[] tmp = q.poll();
				
				for(int i=0;i<4;i++) {
					int nr = tmp[0] + dr[i];
					int nc = tmp[1] + dc[i];
					
					if(inArea(nr,nc) && !visit[nr][nc][tmp[2]] && map[nr][nc][tmp[2]] == 0) {
						visit[nr][nc][tmp[2]] = true;
						map[nr][nc][tmp[2]] = 1;						
						q.add(new int[] {nr,nc,tmp[2]});
					}
				}
				
				for(int i=0;i<2;i++) {
					int nh = tmp[2] + dh[i];
					
					if(inHeight(nh) && !visit[tmp[0]][tmp[1]][nh] && map[tmp[0]][tmp[1]][nh] == 0) {
						visit[tmp[0]][tmp[1]][nh] = true;
						map[tmp[0]][tmp[1]][nh] = 1;
						q.add(new int[] {tmp[0],tmp[1],nh});
					}
				}
				cnt++;
			}
			day++;
		}
		return day;
	}

	private static boolean inHeight(int nh) {
		return nh >= 0 && nh < h;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < m;
	}
}
