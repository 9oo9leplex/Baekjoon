package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon2573 {

	static int N, M, day, cnt, map[][];
	static boolean[][] visit;

	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
	}

	static List<Node> q;

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
				if (map[i][j] != 0) {
					q.add(new Node(i, j,map[i][j]));
					cnt++;
				}
			}
		}

//		visit = new boolean[N];
		System.out.println(bfs());

	}

	private static int bfs() {

		Node node;
		int nr, nc, cnt, len, size;
		Set<Node> sub = new HashSet<>();
		Queue<Node> list = new LinkedList<>();
//		list.add(q.get(0));
		boolean isFirst;

//		for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//		System.out.println();

		while (!q.isEmpty()) {

			size = q.size();
			len = 0;
			list.add(q.get(0));
			visit = new boolean[N][M];
			visit[q.get(0).r][q.get(0).c] = true;
			isFirst = true;
			
			while (!list.isEmpty()) {
				cnt = 0;
				node = list.poll();
//				visit[node.r][node.c] = true;
				
				for (int j = 0; j < 4; j++) {
					nr = node.r + dr[j];
					nc = node.c + dc[j];

					if (inArea(nr, nc)) {
						if (map[nr][nc] == 0) cnt++;
						else if(!visit[nr][nc]){
							list.add(new Node(nr, nc,map[nr][nc]));
							visit[nr][nc] = true;
							len++;
						}
					}
				}
//				System.out.println("[node,cnt]: "+node+","+cnt);
				sub.add(new Node(node.r, node.c, cnt));
			}
//			for(Node n : sub) System.out.println(n);
//			System.out.println(sub.size());
			// 날짜 + 1
			day++;
			if(size != sub.size()) {
				if(isFirst) day--;
				return day;
			}
			isFirst = false;
			
			q.clear();
			// 빼기
//			for (int i = 0; i < len; i++) {
			for(Node n : sub) {
//				node = sub.poll();
//				System.out.println(n);
				map[n.r][n.c] -= n.cnt; 
				if (map[n.r][n.c] <= 0)
					map[n.r][n.c] = 0;
				else
					q.add(n);
			}
			sub.clear();
			
//			for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//			System.out.println();
		}
		return 0;

	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
