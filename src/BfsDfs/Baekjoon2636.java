package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2636 {

	static int map[][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int r, c, cheese;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int tmp;
		
		cheese = 0;
		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if (tmp != 0) cheese++;
			}
		}

		int cheeseCount = 0;
		int day = 0;
		while(cheese != 0) {
			cheeseCount = cheese;
			day++;
			visit = new boolean[r][c];
			sol();
		}
		System.out.println(day);
		System.out.println(cheeseCount);
	}

	private static void sol() {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i=0;i<4;i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				
				if(inArea(nr, nc) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					if(map[nr][nc] == 0)
						q.add(new int[] {nr,nc});
					else {
						cheese--;
						map[nr][nc] = 0;
					}
				}
			}
		}
	}


	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}

}
