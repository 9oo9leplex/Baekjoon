package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 19238
public class Main {

	static class Node implements Comparable<Node>{
		int r,c,t;
		
		public Node(int r,int c,int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.t - o.t;
		}
	}
	
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int n,map[][],index = 1;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			map = new int[n][n];
			visit = new boolean[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem ").append(index++).append(": ").append(bfs(n,map)).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int bfs(int n,int[][] map) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0,map[0][0]));
		visit[0][0] = true;
		
		Node cur;
		int nr,nc;
		
		while(!pq.isEmpty()) {
			cur = pq.poll();
			
			if(cur.r == n-1 && cur.c == n-1) return cur.t;
			
			for(int i=0;i<4;i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(inArea(n,nr,nc) && !visit[nr][nc]) {
					pq.add(new Node(nr,nc,cur.t+map[nr][nc]));
					visit[nr][nc] = true;
				}
			}
		}
		
		
		return 0;
	}



	private static boolean inArea(int N,int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}


















