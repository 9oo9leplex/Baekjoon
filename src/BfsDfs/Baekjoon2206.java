package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2206 {

	static int N,M,map[][];
	static class Node{
		int r,c,life;

		public Node(int r, int c, int life) {
			super();
			this.r = r;
			this.c = c;
			this.life = life;
		}
		
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if(N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		
		map = new int[N][M];
		char[] tmp;
		for(int i=0;i<N;i++) {
			tmp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		
		bfs();
	}

	private static void bfs() {

		int dp[][] = new int[N][M];
		boolean visit[][][] = new boolean[2][N][M];
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0));
		
		Node node;
		int nr,nc;
		while(!q.isEmpty()) {
			node = q.poll();
			
			for(int i=0;i<4;i++) {
				nr = node.r + dr[i];
				nc = node.c + dc[i];
				
				if(!inArea(nr,nc)) continue;
				
				if(map[nr][nc] == 1) {
					if(node.life == 0 && !visit[1][nr][nc]) {
						visit[1][nr][nc] = true;
						dp[nr][nc] = dp[node.r][node.c] + 1;
						q.add(new Node(nr, nc, 1));
					}
				}
				else {
					if(!visit[node.life][nr][nc]) {
						visit[node.life][nr][nc] = true;
						dp[nr][nc] = dp[node.r][node.c] + 1;
						q.add(new Node(nr, nc, node.life));
					}
				}
				
				if(nr == N-1 && nc == M-1) {
					System.out.println(dp[nr][nc] + 1);
					return;
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
