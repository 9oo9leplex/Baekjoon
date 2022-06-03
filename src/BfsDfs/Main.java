package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 19238
public class Main {

	static int N, M, K, row, col, map[][], result = Integer.MAX_VALUE;

	static class Node {
		int r, c, gas, d;

		public Node(int r, int c, int gas, int d) {
			super();
			this.r = r;
			this.c = c;
			this.gas = gas;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", gas=" + gas + ", d=" + d + "]";
		}
	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean[][] visit;
	static List<Node> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken()) - 1;
		col = Integer.parseInt(st.nextToken()) - 1;

		int r, c;
		list = new ArrayList<>();

		for (int i = 2; i < M + 2; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = i;

			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
//			map[r][c] = i + M;
			list.add(new Node(r, c, 0, 0));
		}

//		for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//		System.out.println();

		System.out.println(bfs());
	}

	private static int bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(row, col, K, 0));
		visit = new boolean[N][N];
		visit[row][col] = true;

		int completed = 0;

		Node node, tmp = new Node(N, N, 0, 0);
		int nr, nc, size, targetNum = 500;
		boolean flag = false;
		boolean flag2;
		Queue<Integer> guest = new LinkedList<>();

		while (!q.isEmpty()) {

			size = q.size();
			flag2 = false;
			for (int k = 0; k < size; k++) {

				node = q.poll();
//				System.out.println("[n,r,gas]: ["+node.r+","+node.c+","+node.gas+"]");
				if (node.gas == 0)
					return -1;
				if (completed == M)
					return node.gas;

				for (int i = 0; i < 4; i++) {
					nr = node.r + dr[i];
					nc = node.c + dc[i];

					if (inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] != 1) {
						// 손님이 없다면
						if (guest.isEmpty()) {
							if (map[nr][nc] != 0) {

								if (tmp.r < nr)	continue;
								else if (tmp.r == nr) {
									if (tmp.c > nc) {// 변경
										targetNum = map[nr][nc];
										flag = true;
										tmp = new Node(nr, nc, node.gas - 1, 0);
									}
								} else {
									targetNum = map[nr][nc];
									flag = true;
									tmp = new Node(nr, nc, node.gas - 1, 0);
								}

//								if (targetNum > map[nr][nc]) {
//									targetNum = Math.min(targetNum, map[nr][nc]);
//									flag = true;
//									tmp = new Node(nr, nc, node.gas - 1, 0);
//								}
							} else {
								q.add(new Node(nr, nc, node.gas - 1, 0));
								visit[nr][nc] = true;
							}
						}
						// 손님이 있다면
						else {
//							System.out.println("[n,r]: ["+list.get(guest.peek()-2).r+","+list.get(guest.peek()-2).c+"]");
							if (nr == list.get(guest.peek() - 2).r && nc == list.get(guest.peek() - 2).c) {
//								System.out.println(guest.peek()-2);
								completed++;
								targetNum = 500;
								guest.poll();
								q.clear();
								q.add(new Node(nr, nc, node.gas - 1 + (node.d + 1) * 2, 0));
								visit = new boolean[N][N];
								visit[nr][nc] = true;
								tmp = new Node(N, N, 0, 0);
								flag2 = true;
								break;
							} else {
//								System.out.println("[n,r]: ["+nr+","+nc+"]");
								q.add(new Node(nr, nc, node.gas - 1, node.d + 1));
								visit[nr][nc] = true;
							}
						}
					}
				}
				if (flag2)
					break;
			}

			// target이 바꼈다면
			if (flag) {
				q.clear();
				q.add(tmp);
				map[tmp.r][tmp.c] = 0;
				visit = new boolean[N][N];
				visit[tmp.r][tmp.c] = true;
				guest.add(targetNum);
				flag = false;
//				System.out.println("[n,r]: ["+tmp.r+","+tmp.c+"]");
//				return 0;
			}

		}

		return -1;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
