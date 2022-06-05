package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon5427 {

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
	static Node sk;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		
		char[] tmp;
		StringBuilder sb = new StringBuilder();
		int result;
		
		for(int t=0;t<tc;t++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visit = new boolean[N][M];
			fires = new LinkedList<>(); 
			
			for(int i=0;i<N;i++) {
				tmp = br.readLine().toCharArray();
				for(int j=0;j<M;j++) {
					map[i][j] = tmp[j];
					switch(map[i][j]) {
					case '@':
						sk = new Node(i,j,1);
						break;
					case '*':
						fires.add(new Node(i, j,0));
						break;
					}
				}
			}
			result = bfs();
			sb.append(result == Integer.MAX_VALUE ? "IMPOSSIBLE" : result).append("\n"); 	
		}
		System.out.println(sb);
	}

	private static int bfs() {
		
		Queue<Node> q = new LinkedList<>();
		q.add(sk);
		
		Node node;
		int nr,nc,len;
		
		while(!q.isEmpty()) {
			// 불 이동
			len = fires.size();
			for(int i=0;i<len;i++) {
				node = fires.poll();
				
				for(int j=0;j<4;j++) {
					nr = node.r + dr[j];
					nc = node.c + dc[j];
					
					if(inArea(nr, nc) && map[nr][nc] == '.') {
						map[nr][nc] = '*';
						fires.add(new Node(nr,nc,0));
					}
				}
			}
			
//			for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//			System.out.println();
			
			// 사람 이동
			len = q.size();
			for(int i=0;i<len;i++) {
				node = q.poll();
//				System.out.println("person: "+node);
				for(int j=0;j<4;j++) {
					nr = node.r + dr[j];
					nc = node.c + dc[j];
//					System.out.println("[nr,nc]: ["+nr+","+nc+"]");
					if(!inArea(nr, nc)) return node.t;
					
					if(visit[nr][nc]) continue;
					if(map[nr][nc] == '.') {
						q.add(new Node(nr, nc,node.t+1));
						visit[nr][nc] = true;
					}
				}
			}
//			for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//			System.out.println();
		}
		
		return Integer.MAX_VALUE;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
