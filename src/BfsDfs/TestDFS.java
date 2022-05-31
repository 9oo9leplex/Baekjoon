package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import BfsDfs.TestDFS.Gate;

public class TestDFS {

	static int N, M, K, result, map[][];

	static class Gate {
		int r, c, t;

		public Gate(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Gate [r=" + r + ", c=" + c + ", t=" + t + "]";
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		long before = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Gate> gates;

		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			gates = new LinkedList<>();

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 4) {
						// 입구라면 큐에 저장
						gates.add(new Gate(i, j, 0));
					}
				}
			}

			Gate tmp;
			boolean visit[][];
			result = Integer.MAX_VALUE;
			
			// 모든 문에서 최단 거리 값을 구해본다.
			while (!gates.isEmpty()) {
				tmp = gates.poll();
				visit = new boolean[N][M];
				dfs(tmp.r, tmp.c, tmp.t, visit);
			}
			// 목표까지의 최단 거리 result의 값이 초기값(MAX_VALUE)과 동일하다면 도착점(3)에 도달하지 못한 것이므로 -1 리턴
			// 초기값(MAX_VALUE)과 동일하지 않다면 도착점(3)에 도달한 것이므로 result 값 리턴
			sb.append("#").append(t).append(" ").append(result == Integer.MAX_VALUE ? -1 : result).append("\n");
		}
		System.out.println(sb);
		long after = System.currentTimeMillis();
		System.out.println((after - before));
	}

	private static void dfs(int r, int c, int t, boolean[][] v) {

		// 현재까지 이동한 값이 제한된 시간(K) 값보다 크다면 return
		if (t > K)	return;
		// 현재 위치가 도착점(3)이라면
		// 기존 최단 이동 값(result)와 현재까지의 이동 값(t)를 비교하여 더 작은 값을 저장한다.
		if (map[r][c] == 3) {
			result = Math.min(result, t);
			return;
		}

		// 현재 위치를 방문 처리한다.
		v[r][c] = true;
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 다음 이동할 위치가 map의 크기(N,M)를 벗어나지 않고, 방문한 적이 없으며, 벽이 아니라면 이동
			if (inArea(nr, nc) && !v[nr][nc] && map[nr][nc] != 1) {
				// 다음 위치에 동기가 서 있다면, dfs(다음 위치 행, 다음 위치 열, 이동값 + 2, 방문 배열)
				if (map[nr][nc] == 2) {
					dfs(nr, nc, t + 2, v);
					v[nr][nc] = false;
				}
				// 다음 위치에 동기가 서 없다면, dfs(다음 위치 행, 다음 위치 열, 이동값 + 1, 방문 배열)
				else {
					dfs(nr, nc, t + 1, v);
					v[nr][nc] = false;
				}
			}
		}
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
