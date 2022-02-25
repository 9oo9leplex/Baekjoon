package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {

	static int N,M, map[][], cnt;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
//	static Queue<int[]> q;
	static Queue<Tomato> q;
	static class Tomato{
		int x,y;

		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) cnt++;
				else if(map[i][j] == 1) q.offer(new Tomato(i, j)); //q.offer(new int[] {i,j});
			}
		}
		
		if(cnt == 0) {
			System.out.println(0);
			return;
		}
		
		
		bfs();
	}

	private static void bfs() {
		int day = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
//				int[] tmp = q.poll();
				Tomato t = q.poll();
				
				for(int i=0;i<4;i++) {
//					int nr = tmp[0] + dr[i];
//					int nc = tmp[1] + dc[i];
					int nr = t.x + dr[i];
					int nc = t.y + dc[i];
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
						map[nr][nc] = 1;
//						q.offer(new int[] {nr,nc});
						q.offer(new Tomato(nr, nc));
						cnt--;
					}
				}
			}
			day++;
			if(cnt == 0) {
				System.out.println(day);
				return;
			}
		}
		System.out.println(-1);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
