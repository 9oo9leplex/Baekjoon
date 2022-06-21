package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon19952 {

static int H,W, map[][];
	
	static class Node {
		int r,c,power;

		public Node(int r, int c, int power) {
			super();
			this.r = r;
			this.c = c;
			this.power = power;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", power=" + power + "]";
		}
		
		
	}
	
	static Queue<Node> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visit;
		
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int tc = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int z=0;z<tc;z++) {
    		
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	
	    	H = Integer.parseInt(st.nextToken());
	    	W = Integer.parseInt(st.nextToken());
	    	int o = Integer.parseInt(st.nextToken());
	    	int f = Integer.parseInt(st.nextToken());
	    	int sr = Integer.parseInt(st.nextToken()) - 1;
	    	int sc = Integer.parseInt(st.nextToken()) - 1;
	    	int dr = Integer.parseInt(st.nextToken()) - 1;
	    	int dc = Integer.parseInt(st.nextToken()) - 1;
	    	
	    	map = new int[H][W];
	    	int r,c,l;
	    	for(int i=0;i<o;i++) {
	    		st = new StringTokenizer(br.readLine());
	    		r = Integer.parseInt(st.nextToken()) - 1;
	    		c = Integer.parseInt(st.nextToken()) - 1;
	    		l = Integer.parseInt(st.nextToken());
	    		
	    		map[r][c] = l;
	    	}
	    	
	    	q = new LinkedList<>();
	    	q.add(new Node(sr,sc,f));
	    	visit = new boolean[H][W];
	    	visit[sr][sc] = true;
	    	
	//    	for(int i = 0;i<H;i++) System.out.println(Arrays.toString(map[i]));
	//    	System.out.println();
	    	
	    	if(bfs(dr,dc)) sb.append("잘했어!!").append("\n");
	    	else sb.append("인성 문제있어??").append("\n");
    	}
    	System.out.println(sb);
    }

	private static boolean bfs(int r, int c) {
		
		Node cur;
		int nr,nc,diff;
		
		while(!q.isEmpty()) {
			cur = q.poll();
//			System.out.println(cur);
			if(cur.r == r && cur.c == c) return true;
			if(cur.power == 0) return false;
			
			for(int i=0;i<4;i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(inArea(nr,nc) && !visit[nr][nc]) {
					
					if(map[cur.r][cur.c] < map[nr][nc]) {
						diff = map[nr][nc] - map[cur.r][cur.c];
						if(cur.power >= diff) {
							q.add(new Node(nr,nc, cur.power-1));
							visit[nr][nc] = true;
						}
					} 
					else {
						q.add(new Node(nr,nc, cur.power-1));
						visit[nr][nc] = true;
					}
					
				}
			}
		}
		
		return false;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < H && nc >= 0 && nc < W;
	}
}
