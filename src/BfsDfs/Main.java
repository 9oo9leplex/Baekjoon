package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][],day;

	static class Cheese {
		int r, c;

		public Cheese(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static Queue<Cheese> q;
	static Queue<Cheese> remove;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					q.add(new Cheese(i, j));
			}
		}

		bfs();
		System.out.println(day);
	}

	private static void bfs() {

		Cheese cheese;
		int nr, nc, cnt, len;

		remove = new LinkedList<>();
		
		while (!q.isEmpty()) {

			len = q.size();
			for (int j = 0; j < len; j++) {
				
				cheese = q.poll();
				cnt = 0;
				
				for (int i = 0; i < 4; i++) {
					nr = cheese.r + dr[i];
					nc = cheese.c + dc[i];

					if (map[nr][nc] == 0) cnt++;
				}
				if (cnt < 2) q.add(cheese);
				else remove.add(cheese);
			}
			while(!remove.isEmpty()) {
				cheese = remove.poll();
				map[cheese.r][cheese.c] = 0;
			}
			day++;
		}

	}
}
