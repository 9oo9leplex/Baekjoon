package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2146 {

	static int N, map[][],result;

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
	static boolean[][] visit;
	static Queue<Node> route;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		NumberingContinent();
		
//		for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//		System.out.println();
		
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		
		int d,nr,nc;
		Queue<Node> q = new LinkedList<>();
		Node now;
		result = 2 * N;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 0) continue;
				visit = new boolean[N][N];

				q.add(new Node(i,j,0));
				d = map[i][j];
				visit[i][j] = true;
				
				while(!q.isEmpty()) {
					now = q.poll();
					if(now.d >= result) continue;
//					visit[now.r][now.c] = true;
					for(int k=0;k<4;k++) {
						nr = now.r + dr[k];
						nc = now.c + dc[k];
						
						if(inArea(nr, nc) && !visit[nr][nc]  && map[nr][nc] != d) {
							visit[nr][nc] = true;
							if(map[nr][nc] == 0) q.add(new Node(nr, nc, now.d+1));
							else {
//								System.out.println("[r,c,d]: ["+nr+","+nc+","+now.d+"]");
								result = Math.min(result, now.d);
							}
				
						}
					}
				}
			}
		}
		
	}

	private static void NumberingContinent() {

		visit = new boolean[N][N];
		int index = 1,nr,nc;
		Queue<Node> q = new LinkedList<>();
		Node now;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]) continue;
				visit[i][j] = true;
				if(map[i][j] == 0) continue;
				map[i][j] = index;
				q.add(new Node(i,j,index));
				
				while(!q.isEmpty()) {
					now = q.poll();
					
					for(int k=0;k<4;k++) {
						nr = now.r + dr[k];
						nc = now.c + dc[k];
						
						if(inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] == 1) {
							visit[nr][nc] = true;
							q.add(new Node(nr,nc,index));
							map[nr][nc] = index;
						}
					}
				}
				index++;
			}
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
