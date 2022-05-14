package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 24513, 틀렸음
public class Main {

	static int N, M, zero, map[][];

	static class Node {
		int r, c, d;

		public Node(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", d=" + d + "]";
		}

	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean[][][] visit;
	static Queue<Node> route;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		route = new LinkedList<>();
		visit = new boolean[2][N][M];
		
		char tmp[];
		
		for(int i=0;i<N;i++) {
			tmp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		
		bfs();
	}

	

	private static void bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,0));
		visit[0][0][0] = true;
		
		Node node;
		int nr,nc;
		
		while(!q.isEmpty()) {
			node = q.poll();
			
			for(int i=0;i<4;i++) {
				nr = node.r + dr[i];
				nc = node.c + dc[i];
				
				
			}
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}























