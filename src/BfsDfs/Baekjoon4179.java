package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon4179 {

	static int N, M;
	static boolean[][] visit;
	static char[][] map;
	
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static class Node {
		int r,c,t;

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
	static Queue<Node> fires;
	static Node jh;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		fires = new LinkedList<>();
		char[] tmp;
		for(int i=0;i<N;i++) {
			tmp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j];
				if(map[i][j] == 'J') jh = new Node(i,j,1); 
				else if(map[i][j] == 'F') fires.add(new Node(i,j,0)); 
			}
		}

		int result = bfs();
		System.out.println(result == Integer.MAX_VALUE ? "IMPOSSIBLE" : result);
	}

	private static int bfs() {
		
		Queue<Node> q = new LinkedList<>();
		q.add(jh);
		visit = new boolean[N][M];
		
		Node node;
		int nr,nc,len;
		
		
		while(!q.isEmpty()) {
			
			len = fires.size();
			for(int i=0;i<len;i++) {
				node = fires.poll();
				
				for(int j=0;j<4;j++) {
					nr = node.r + dr[j];
					nc = node.c + dc[j];
					
					if(inArea(nr,nc) && map[nr][nc] == '.') {
						map[nr][nc] = 'F';
						fires.add(new Node(nr,nc,node.t+1));
					}
				}
			}
			
			
			len = q.size();
			for(int i=0;i<len;i++) {
				node = q.poll();
				for(int j=0;j<4;j++) {
					nr = node.r + dr[j];
					nc = node.c + dc[j];
					
					if(!inArea(nr, nc)) return node.t;
					if(!visit[nr][nc] && map[nr][nc] == '.') {
						visit[nr][nc] = true;
						q.add(new Node(nr,nc,node.t+1));
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
