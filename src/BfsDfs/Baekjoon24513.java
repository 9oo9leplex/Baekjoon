package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon24513 {

	static int N, M, zero, map[][];

	static class Node {
		int r, c, num;

		public Node(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", t=" + num + "]";
		}

	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean[][] visit;
	static Queue<Node> virus;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		virus = new LinkedList<>();
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) visit[i][j] = true;
				else if(map[i][j] == 0) zero++;
				else {
					virus.add(new Node(i,j,map[i][j]));
					visit[i][j] = true;
				}
			}
		}
		
//		System.out.println(virus);
		bfs();
		countNum();
	}

	private static void countNum() {

		int one = 0,two = 0,three = 0, val;
		
		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
			for(int j=0;j<M;j++) {
				val = map[i][j];
				if(val == -1) continue;
				else if(val == 1) one++;
				else if(val == 2) two++;
				else if(val == 3) three++;
			}
		}
		System.out.println(one+" "+two+" "+three);
	}

	private static void bfs() {

		
		int nr,nc,size;
		Node node;
		
		while(!virus.isEmpty()) {
			size = virus.size();
			for(int i=0;i<size;i++) {
				node = virus.poll();
//				visit[node.r][node.c] = true;
				if(map[node.r][node.c] == 3 ) continue;
//				System.out.println(node);
				for(int j=0;j<4;j++) {
					nr = node.r + dr[j];
					nc = node.c + dc[j];
					
					if(inArea(nr, nc) && !visit[nr][nc]) {
						if(map[nr][nc] == 0) {
							map[nr][nc] = node.num;
							virus.add(new Node(nr, nc, map[nr][nc]));
							zero--;
						}
						else {
							if(map[nr][nc] != node.num) map[nr][nc] = 3;
						}
						
					}
				}
			}
			if(zero == 0) break;
			
			for(Node n : virus)
				visit[n.r][n.c] = true;
		}
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
