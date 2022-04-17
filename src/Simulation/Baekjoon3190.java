package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3190 {

	static int n, a, cnt, map[][], dirCnt;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class Snake {
		int r, c, dir;

		public Snake(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵 크기
		n = Integer.parseInt(br.readLine());
		// 사과 갯수
		a = Integer.parseInt(br.readLine());

		map = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			// 사과 위치 2로 표시, 맵 인덱스가 0부터 시작하므로 받아온 값 -1
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
		}

		dirCnt = Integer.parseInt(br.readLine());
		// 방향 전환 시간 저장 변수
		List<Integer> t = new ArrayList<>();
		// 방향 전환 변수
		List<Character> d = new ArrayList<>();
		for (int i = 0; i < dirCnt; i++) {
			st = new StringTokenizer(br.readLine());
			t.add(Integer.parseInt(st.nextToken()));
			d.add(st.nextToken().charAt(0));
		}
		cnt = 0;
		// 뱀 초기 위치, 방향(북0,동1,남2,서3)
		Snake snake = new Snake(0, 0, 1);
		map[0][0] = 1;

		// 움직여야 하는 공간 저장
		Queue<int[]> move = new LinkedList<int[]>();
		// 처음 위치 저장
		move.add(new int[] { 0, 0 });

		int[] next;
		int nextR = 0, nextC = 0;
		
		while (true) {
			
			// 다음 위치
			nextR += dr[snake.dir];
			nextC += dc[snake.dir];
			// 시간 증가
			cnt++;
			
			// 범위 체크, 몸통 ~ 꼬리가 움직인 위치에 있다면 종료
			if (!inArea(nextR, nextC) || map[nextR][nextC] == 1) break;
			
			// 움직인 위치 사과 없다면
			if(map[nextR][nextC] != 2) {
				// 이전 위치 삭제
				next = move.poll();
				map[next[0]][next[1]] = 0;
			}
			map[nextR][nextC] = 1;
			snake.r = nextR;
			snake.c = nextC;
			move.add(new int[] { nextR, nextC });

			// 방향(북0,동1,남2,서3)
			// 방향 변경이 남아있다면
			if (t.size() > 0) {
				// 현재 시간과 비교
				if (t.get(0) == cnt) {
					// 시간 제거
					t.remove(0);
					// 방향 꺼내오기
					switch (d.remove(0)) {
					// 좌회전
					case 'L':
						snake.dir = (snake.dir + 3) % 4;
						break;
					// 우회전
					case 'D':
						snake.dir = (snake.dir + 1) % 4;
						break;
					}

				}
			}
		}
		System.out.println(cnt);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}
}
