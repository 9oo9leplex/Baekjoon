package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon4963 {

	static int map[][],w,h,result;
	static boolean visit[][];
	static Queue<Land> q;
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	static class Land{
		int x,y;

		public Land(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Land land;
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); 
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h ==0) break;
			
			map = new int[h][w];
			visit = new boolean[h][w];
			q = new LinkedList<>();
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) q.add(new Land(i, j));
				}
			}
			result = 0;
			while(!q.isEmpty()) {
				land = q.poll();
				if(visit[land.x][land.y]) continue;
				bfs(land);
				result++;
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(Land land) {
		
		if(visit[land.x][land.y] || map[land.x][land.y] == 0) return;
		visit[land.x][land.y] = true;
		
		for(int i=0;i<8;i++) {
			int nr = land.x + dr[i];
			int nc = land.y + dc[i];
			if(inArea(nr,nc) && !visit[nr][nc] && map[nr][nc] == 1)
				bfs(new Land(nr, nc));
		}
		
		/*
		while(!q.isEmpty()) {
			
			Land land = q.poll();
			if(visit[land.x][land.y] || map[land.x][land.y] == 0) continue;
			
			visit[land.x][land.y] = true;
			result++;
			
			for(int i=0;i<8;i++) {
				int nr = land.x + dr[i];
				int nc = land.y + dc[i];
				if(inArea(nr,nc) && !visit[nr][nc] && map[nr][nc] == 1)
					q.add(new Land(nr, nc));
			}
		}
		*/
	}

	private static boolean inArea(int nr, int nc) {
		return nr < h && nr >= 0 && nc < w && nc >= 0;
	}

}
