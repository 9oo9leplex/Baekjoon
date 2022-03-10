package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {

	static int map[][], n, m, result;
	static boolean visit[][];
	static int[] dr = { -1, -2,-2,-1, 1, 2, 2, 1};
	static int[] dc = { -2, -1, 1, 2, 2, 1,-1,-2};
	static Horse start, dest;

	static class Horse {
		int x, y;

		public Horse(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			m = Integer.parseInt(br.readLine());

			map = new int[m][m];
			visit = new boolean[m][m];

			st = new StringTokenizer(br.readLine());
			start = new Horse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			st = new StringTokenizer(br.readLine());
			dest = new Horse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			sb.append(bfs(start.x, start.y)).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y) {

		Queue<Horse> q = new LinkedList<>();
		q.add(new Horse(x, y));

		int index = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int cnt = 0;
			
			while (cnt < size) {
				Horse tmp = q.poll();
				if (visit[tmp.x][tmp.y]) {
					cnt++;
					continue;
				}
				visit[tmp.x][tmp.y] = true;
				map[tmp.x][tmp.y] = index;
				
//				System.out.println("myX: " + tmp.x + ", myY: " + tmp.y + ", index: " + index);
				if (dest.x == tmp.x && dest.y == tmp.y) return index;
				
				for (int i = 0; i < 8; i++) {
					int nr = tmp.x + dr[i];
					int nc = tmp.y + dc[i];

					if (inArea(nr, nc) && !visit[nr][nc]) {
//						map[nr][nc] = cnt + 1;
						// visit[nr][nc] = true;
						q.add(new Horse(nr, nc));
					}
				}
				cnt++;
			}
			index++;
		}
		return 0;
	}

	private static boolean inArea(int nr, int nc) {
		return nr < m && nr >= 0 && nc < m && nc >= 0;
	}

}
