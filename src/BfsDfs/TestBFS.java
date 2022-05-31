package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import BfsDfs.TestBFS.Gate;

public class TestBFS {

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

	static Queue<Gate> gates;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean visit[][];

	public static void main(String[] args) throws IOException {

		long before = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			gates = new LinkedList<>();

			visit = new boolean[N][M];
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 입구라면 큐에 저장
					if (map[i][j] == 4) {
						gates.add(new Gate(i, j, 0));
						visit[i][j] = true;
					}
				}
			}

			bfs();
			// 목표까지의 최단 거리 result의 값이 초기값(MAX_VALUE)과 동일하다면 도착점(3)에 도달하지 못한 것이므로 -1 리턴
			// 초기값(MAX_VALUE)과 동일하지 않다면 도착점(3)에 도달한 것이므로 result 값 리턴
			sb.append("#").append(t).append(" ").append(result == Integer.MAX_VALUE ? -1 : result).append("\n");
		}
		System.out.println(sb);
		long after = System.currentTimeMillis();
		System.out.println((after - before));
		// 925
		// 9696
	}

	private static void bfs() {

		int nr, nc, size;
		Gate move;

		while (!gates.isEmpty()) {
			// 1분 동안 이동할 수 있는 위치
			size = gates.size();
			for (int i = 0; i < size; i++) {
				// 현재 위치를 큐에서 가져옴
				move = gates.poll();
				// 현재 위치 방문 처리
				visit[move.r][move.c] = true;
				// 현재 위치까지의 이동 거리가 제한된 시간(K)값보다 크다면
				// 조건에 위배되므로 아래 로직을 수행하지 않고 continue
				if (move.t >= K)
					continue;

				// 4방 탐색
				for (int j = 0; j < 4; j++) {
					nr = move.r + dr[j];
					nc = move.c + dc[j];
					// 다음 이동할 위치가 map의 크기(N,M)를 벗어나지 않고, 방문한 적이 없으며, 벽이 아니라면 이동 
					if (inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] != 1) {
						// 다음 이동 위치가 도착점이라면
						if (map[nr][nc] == 3) {
							// 현재까지의 이동 값(move.t)에 1을 더한 값과 제한된 시간(K) 값을 비교하여 현재까지의 이동 값이 더 작다면
							// 기존 최단 이동 값과 현재까지의 이동 값을 비교, 더 작은 값을 저장한다.
							if (move.t + 1 <= K) result = Math.min(result, move.t + 1);
						} else {
							// 다음 이동 위치에 동기가 서 있다면, 큐에 다음 위치와 현재까지의 이동 값 + 2을 저장한다.
							if (map[nr][nc] == 2) gates.add(new Gate(nr, nc, move.t + 2));
							// 다음 이동 위치가 빈 공간(0),문(4)이라면 큐에 다음 위치와 현재까지의 이동 값 + 1을 저장한다.
							else gates.add(new Gate(nr, nc, move.t + 1));
						}
					}
				}
			}
		}

	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
