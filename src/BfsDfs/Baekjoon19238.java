package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon19238 {

	static int N, M, K, map[][];

	static class Taxi implements Comparable<Taxi> {

		int r, c, time;

		@Override
		public String toString() {
			return "Passenger [r=" + r + ", c=" + c + ", time=" + time + "]";
		}

		public Taxi(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Taxi o) {
			if (this.time == o.time) {
				if (this.r == o.r)
					return this.c - o.c;
				return this.r - o.r;
			}
			return this.time - o.time;
		}
	}

	static class Passenger {
		int sr, sc, dr, dc, idx;

		public Passenger(int sr, int sc, int dr, int dc, int idx) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.dr = dr;
			this.dc = dc;
			this.idx = idx;
		}
	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static Taxi taxi;
	static Queue<Integer>[][] passengerMap;
	static Passenger[] passengers;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		passengers = new Passenger[M];
		passengerMap = new LinkedList[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				passengerMap[i][j] = new LinkedList<>();
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int dr, dc, startTime, index;
		taxi = new Taxi(r, c, 0);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			dr = Integer.parseInt(st.nextToken()) - 1;
			dc = Integer.parseInt(st.nextToken()) - 1;

			passengerMap[r][c].add(i);
			passengers[i - 1] = new Passenger(r, c, dr, dc, i);
		}

		for (int i = 0; i < M; i++) {
			if (!searchPassenger()) {
				System.out.println(-1);
				return;
			}

			startTime = taxi.time;
			index = passengerMap[taxi.r][taxi.c].poll() - 1;

			if (!goDest(passengers[index].dr, passengers[index].dc)) {
				System.out.println(-1);
				return;
			}

			K -= taxi.time;

			if (K < 0) {
				System.out.println(-1);
				return;
			} else {
				K += (2 * (taxi.time - startTime));
				taxi.time = 0;
			}
		}
		System.out.println(K);
		return;

	}

	private static boolean goDest(int r, int c) {

		Queue<Taxi> q = new LinkedList<>();
		q.offer(taxi);
		boolean[][] visit = new boolean[N][N];
		visit[taxi.r][taxi.c] = true;

		Taxi cur;
		int nr, nc;

		while (!q.isEmpty()) {
			cur = q.poll();

			if (cur.r == r && cur.c == c) {
				taxi = cur;
				return true;
			}

			for (int i = 0; i < 4; i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];

				if (inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] != -1) {
					visit[nr][nc] = true;
					q.offer(new Taxi(nr, nc, cur.time + 1));
				}
			}
		}

		return false;
	}

	private static boolean searchPassenger() {

		ArrayList<Taxi> t = new ArrayList<>();
		Queue<Taxi> q = new LinkedList<>();
		q.offer(taxi);
		boolean visit[][] = new boolean[N][N];
		visit[taxi.r][taxi.c] = true;

		Taxi cur;
		int nr, nc;

		while (!q.isEmpty()) {
			cur = q.poll();

			if (!t.isEmpty() && t.get(0).time < cur.time)
				continue;

			if (!passengerMap[cur.r][cur.c].isEmpty()) {
				t.add(cur);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];

				if (inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] != -1) {
					visit[nr][nc] = true;
					q.offer(new Taxi(nr, nc, cur.time + 1));
				}
			}
		}

		if (t.isEmpty())
			return false;

		Collections.sort(t);
		taxi = t.get(0);

		return true;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
