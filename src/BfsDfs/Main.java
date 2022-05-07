package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, map[][], dp[][];
	static class Node{
		int r,c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		char[] tmp;
		for(int i=0;i<N;i++) {
			tmp = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j] = tmp[j] - '0';
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		System.out.println(dp[N-1][N-1]);
	}

	private static void bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0));
		dp[0][0] = 0;
		
		Node node;
		int nr,nc;
		
		while(!q.isEmpty()) {
			node = q.poll();
			
			for(int i=0;i<4;i++) {
				nr = node.r + dr[i];
				nc = node.c + dc[i];
				
				if(inArea(nr,nc) && dp[nr][nc] > dp[node.r][node.c]) {
					if(map[nr][nc] == 1) dp[nr][nc] = dp[node.r][node.c];
					else dp[nr][nc] = dp[node.r][node.c] + 1;
					q.add(new Node(nr,nc));
				}
			}
			
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
















