package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3190 {

	static int n, k, map[][], max;

	static class Snake {
		int headR, headC, dir, size;

		public Snake(int headR, int headC, int dir, int size) {
			super();
			this.headR = headR;
			this.headC = headC;
			this.dir = dir;
			this.size = size;
		}

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		map = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r - 1][c - 1] = 2;
		}

		int t = Integer.parseInt(br.readLine());

		Queue<Integer> time = new LinkedList<>();
		Queue<Character> dir = new LinkedList<>();

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			time.add(Integer.parseInt(st.nextToken()));
			dir.add(st.nextToken().charAt(0));
		}

		t = 0;
		Snake snake = new Snake(0, 0, 3, 1);
		Queue<int[]> tailRoute = new LinkedList<>();
		int[] tmp;
		int nextR, nextC;

		map[0][0] = 1;
		tailRoute.add(new int[] { 0, 0 });
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (true) {
			t++;
			// 다음 이동 위치
			nextR = snake.headR + dr[snake.dir];
			nextC = snake.headC + dc[snake.dir];
			// 움직인 곳이 범위를 벗어나거나, 자기몸에 부딪치면 종료
//			if (!inArea(nextR, nextC) || map[nextR][nextC] == 1) {
			if (!inArea(nextR, nextC) || q.contains(nextR*n+nextC)) {
//				t++;
				break;
			}
			
			if(map[nextR][nextC] == 2) {
				map[nextR][nextC] = 0;
				q.add(nextR*n+nextC);
			} else {
				q.add(nextR*n+nextC);
				q.poll();
			}
/*
			if (k > 0) {
				// 사과 위치에 도달하면 몸길이 증가
				if (map[nextR][nextC] == 2) {
					map[nextR][nextC] = 1;
					snake.headR = nextR;
					snake.headC = nextC;
					tailRoute.add(new int[] { nextR, nextC });
					t++;
					k--;
					snake.size++;
					continue;
				}
			}

			if (snake.size > 1) {
				// 꼬리 이동
				tmp = tailRoute.poll();
				map[tmp[0]][tmp[1]] = 0;

				for (int[] a : tailRoute)
					map[a[0]][a[1]] = 1;

				tailRoute.add(new int[] { nextR, nextC });
			} else {
				map[snake.headR][snake.headC] = 0;
			}
			// 머리 이동
			snake.headR = nextR;
			snake.headC = nextC;
			map[nextR][nextC] = 1;
			t++;
*/
			// 방향 전환
			if (!time.isEmpty() && t == time.peek()) {
				time.poll();
				switch (dir.poll()) {
				case 'L':
					snake.dir = (snake.dir + 1) % 4;
					break;
				case 'D':
					snake.dir = snake.dir - 1 < 0 ? 3 : snake.dir - 1;
					break;
				}
			}
			
			snake.headR = nextR;
			snake.headC = nextC;
		}
		System.out.println(t);
	}

	private static boolean inArea(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}

}
