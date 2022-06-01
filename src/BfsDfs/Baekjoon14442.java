package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14442 {

	static int N,M,K, map[][],result = Integer.MAX_VALUE;

	static class Node {
		int r, c, cnt,life;

		public Node(int r, int c, int cnt, int life) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.life = life;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", cnt=" + cnt + ", life=" + life + "]";
		}
	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		char[] tmp;
		
		for(int i=0;i<N;i++) {
			tmp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		
		if(N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		
		bfs();
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static void bfs() {
		
		visit = new boolean[K+1][N][M];
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1,0));
		visit[0][0][0] = true;
		
		
		Node node;
		int nr,nc;
		
		while(!q.isEmpty()) {
			node = q.poll();
			
			if(node.r == N-1 && node.c == M-1) {
				result = Math.min(result, node.cnt);
				return;
			}
			
			for(int i=0;i<4;i++) {
				nr =  node.r + dr[i];
				nc =  node.c + dc[i];
				if(inArea(nr, nc)) {
//					System.out.println("[r,c]: ["+nr+","+nc+"]");
					if(map[nr][nc] == 1 && node.life < K && !visit[node.life+1][nr][nc]) {
						q.add(new Node(nr,nc,node.cnt+1,node.life+1));
						visit[node.life+1][nr][nc] = true;
					} 
					else if(map[nr][nc] == 0 && !visit[node.life][nr][nc]){
						q.add(new Node(nr,nc,node.cnt+1,node.life));
						visit[node.life][nr][nc] = true;
					}
				}
			}
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
