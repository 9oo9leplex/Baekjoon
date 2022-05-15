package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baekjoon17141 {

	static int N, M, empty, map[][], dp[][], number[], vSize, day = Integer.MAX_VALUE;

	static class Node {
		int r, c, t;

		public Node(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", t=" + t + "]";
		}

	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean[][] visit;
	static List<Node> virus;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		virus = new ArrayList<>();
		boolean zero = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

//				if (map[i][j] != 1) {
				if(map[i][j] == 0) {
					zero = false;
					empty++;
				}
				if (map[i][j] == 2) {
					empty++;
					virus.add(new Node(i, j, 0));			
				}
			}
		}

		vSize = virus.size();
		if(vSize == M && zero) {
			System.out.println(0);
			return;
		}
		
		number = new int[M];
		combination(0, 0);
		System.out.println(day == Integer.MAX_VALUE ? -1 : day);
	}

	private static void combination(int start, int cnt) {

		if (cnt == M) {
//			System.out.println(Arrays.toString(number));
			bfs();
//			System.out.println(day);
			return;
		}

		for (int i = start; i < vSize; i++) {
			number[cnt] = i;
			combination(i + 1, cnt + 1);
		}
	}

	private static void bfs() {

		Queue<Node> q = new LinkedList<>();
		Node node;
		visit = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			node = virus.get(number[i]);
			q.add(node);
			visit[node.r][node.c] = true;
		}
//		System.out.println(q);

		int nr, nc, d, len = empty - M;

		while (!q.isEmpty()) {
			node = q.poll();
			d = node.t;
			for (int i = 0; i < 4; i++) {
				nr = node.r + dr[i];
				nc = node.c + dc[i];
				if (inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] != 1) {
					visit[nr][nc] = true;
//					if(map[nr][nc] == 0) {
//						map[nr][nc] = 2;
//					}
					len--;
//					System.out.println("[nr,rc,len]: ["+nr+","+nc+","+len+"]");
					q.add(new Node(nr, nc, d + 1));
				}
			}

//			for(int j=0;j<N;j++) System.out.println(Arrays.toString(visit[j]));
//			System.out.println();

			if(day <= d+1) return;
			
			
			if (len == 0) {
//				System.out.println("[day,d+1]: ["+day+","+(d+1)+"]");
				day = Math.min(day, d + 1);
				return;
			}
		}

	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
