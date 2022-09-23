package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int r,c,result;
	static char[][] map;
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
	
	static Node jihun;
	static Queue<Node> fires;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		char[] cur;
		fires = new LinkedList<>();
		
		for(int i=0;i<r;i++) {
			cur = br.readLine().toCharArray();
			for(int j=0;j<c;j++) {
				map[i][j] = cur[j];
				if(cur[j] == 'J') {
					jihun = new Node(i, j, 0);
					map[i][j] = '.';
				}
				else if(cur[j] == 'F') fires.add(new Node(i, j, 0));
			}
		}
		bfs();
		
		if(result == 0) System.out.println("IMPOSSIBLE");
		else System.out.println(result);
	}

	private static void bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(jihun);

		boolean[][] visit = new boolean[r][c];
		
		Node cur;
		Node fire;
		int nr,nc,len;
		
		while(!q.isEmpty()) {
			
			len = fires.size();
			for(int i=0;i<len;i++) {
				fire = fires.poll();
				for(int j=0;j<4;j++) {
					nr = fire.r + dr[j];
					nc = fire.c + dc[j];
					
					if(inArea(nr,nc) && map[nr][nc] == '.')	{
						map[nr][nc] = 'F';
						fires.add(new Node(nr, nc, 0));
					}
				}
			}
			
			len = q.size();
			for(int k=0;k<len;k++) {
				cur = q.poll();
				
				for(int i=0;i<4;i++) {
					nr = cur.r + dr[i];
					nc = cur.c + dc[i];
					
//					System.out.println("[nr,nc]: ["+nr+","+nc+"]");
					
					if(!inArea(nr,nc)) {
						result = cur.t+1;
						return;
					}
					
					
					if(!visit[nr][nc] && map[nr][nc] == '.') {
						visit[nr][nc] = true;
						q.add(new Node(nr, nc, cur.t+1));
					}
				}
			}
			
		}
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}
}
