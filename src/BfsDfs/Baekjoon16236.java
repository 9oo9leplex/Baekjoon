package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16236 {

	static class Fish {
		int x, y, d;

		public Fish(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int N, x, y, size, tmpx, tmpy, cnt, result, map[][];
	static boolean visit[][];
	static Fish shark;
	static ArrayList<Fish> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				int value = Integer.parseInt(st.nextToken());
				map[row][col] = value;
				if (value == 9) {
					shark = new Fish(row, col, 0);
					map[row][col] = 0;
//					x = row;
//					y = col;
//					visit[row][col] = true;
				}
			}
		}

		// 상어 초기 크기
		size = 2;
		// 먹이 탐색
		// 상어 크기 > 먹이크기
//		findTarget();
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<Fish> queue = new LinkedList<>();
		queue.add(shark);
		visit[shark.x][shark.y] = true;

		while (true) {
			while (!queue.isEmpty()) {
				Fish f = queue.poll();
				int d = f.d;

				for (int i = 0; i < 4; i++) {
					int nx = f.x + dr[i];
					int ny = f.y + dc[i];

					if (!inArea(nx, ny) || visit[nx][ny])
						continue;

					if (map[nx][ny] < size && map[nx][ny] != 0) {
						queue.add(new Fish(nx, ny, d + 1));
						visit[nx][ny] = true;
						list.add(new Fish(nx, ny, d + 1));
					}

					if (map[nx][ny] <= size) {
						queue.add(new Fish(nx, ny, d + 1));
						visit[nx][ny] = true;
					}
				}
			}

			if (!list.isEmpty()) {
				move();

				queue.clear();
				visit = new boolean[N][N];

				queue.add(shark);
				visit[shark.x][shark.y] = true;
			} else {
				return;
			}
		}
	}

	private static void move() {
		// 정렬을 통해 가장 거리가 짧은 먹이 선정
		Collections.sort(list, (o1,o2) -> {
			if(o1.d == o2.d) { 
				if(o1.x == o2.x) return o1.y - o2.y; 
				else return o1.x - o2.x; 
			} 
			return o1.d - o2.d; });
		
		// 최단 거리 먹이 정보 가져오기
		Fish f = list.get(0);
		shark.x = f.x;
		shark.y = f.y;

		if (++cnt == size) {
			size++;
			cnt = 0;
		}

		result += f.d;
		map[f.x][f.y] = 0;
		list.clear();
	}

	/*
	 * private static void findTarget() { d = Integer.MAX_VALUE; for(int
	 * row=0;row<N;row++) { for(int col=0;col<N;col++) { if(size > map[row][col] &&
	 * map[row][col] != 0) { getDistance(x,y,row,col,0); } } } // 움직이지 못한다면 if(d ==
	 * Integer.MAX_VALUE) return; // 상어 위치, 먹이 위치 변경, 최단 거리 초기화 map[x][y] = 0;
	 * map[tmpx][tmpy] = 9; x = tmpx; y = tmpy; result += d; //
	 * System.out.println(result); if(shark == ++cnt) { shark++; cnt = 0; } //
	 * for(int i=0;i<N;i++) // System.out.println(Arrays.toString(visit[i]));
	 * 
	 * findTarget(); }
	 */
	/*
	 * private static void getDistance(int a,int b,int r, int c, int tmpd) {
	 * 
	 * // System.out.println("shark-x: "+a+", shark-y: "+b+", r: "+r+", c: "+c);
	 * 
	 * // 범위를 벗어나는지 if(!inArea(a,b)) return; // 방문한 적이 있다면 else if(visit[a][b])
	 * return;
	 * 
	 * // 상어 크기, 이동 위치 크기 비교 else if(shark < map[a][b] && map[a][b] != 9) return;
	 * 
	 * else if(a == r && b == c) { // System.out.println("d: "+d+", tmpd: "+ tmpd);
	 * // 거리 비교, 최신화 if(d > tmpd) { d = tmpd; tmpx = r; tmpy = c; } return; }
	 * 
	 * //System.out.println(!inArea(a,b)); visit[a][b] = true;
	 * 
	 * getDistance(a-1, b,r,c, tmpd+1); getDistance(a, b+1,r,c, tmpd+1);
	 * getDistance(a+1, b,r,c, tmpd+1); getDistance(a, b-1,r,c, tmpd+1);
	 * 
	 * visit[a][b] = false; }
	 */
	private static boolean inArea(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
