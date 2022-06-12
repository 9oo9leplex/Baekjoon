package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16197 {

	static int N,M;
	static char[][] map;
	static class Coin {
		int r,c,cnt;

		@Override
		public String toString() {
			return "Coin [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

		public Coin(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static Queue<Coin> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
    
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new char[N][M];
    	q = new LinkedList<>();
    	char[] tmp;
    	for(int i=0;i<N;i++) {
    		tmp = br.readLine().toCharArray();
    		for(int j=0;j<M;j++) {
    			map[i][j] = tmp[j];
    			if(map[i][j] == 'o') q.add(new Coin(i,j,0));
    		}
    	}
    	
    	if(N == 1 && M == 1) {
    		System.out.println(-1);
    		return;
    	}
    	
    	System.out.println(bfs());
    }

	private static int bfs() {
		
		Coin a,b;
		int anr,anc,bnr,bnc;
		
		while(!q.isEmpty()) {
			a = q.poll();
			b = q.poll();

			if(a.cnt >= 10 || b.cnt >= 10) return -1;
//			if(a.r == b.r && a.c == b.c) continue;
			
			for(int i=0;i<4;i++) {
				anr = a.r + dr[i];
				anc = a.c + dc[i];
				bnr = b.r + dr[i];
				bnc = b.c + dc[i];
				
//				if(anr == b.r && anc == b.c) continue;
//				else if(bnr == a.r && bnc == a.c) continue;
				
				if(!inArea(anr,anc) && !inArea(bnr,bnc)) continue;
				else if(inArea(anr,anc) && !inArea(bnr,bnc)) return b.cnt+1;
				else if(!inArea(anr,anc) && inArea(bnr,bnc)) return a.cnt+1;
				else {
					
					if(map[anr][anc] == '#' && map[bnr][bnc] == '#') continue;
					else if(map[anr][anc] == '#' && map[bnr][bnc] != '#') {
							q.add(new Coin(a.r,a.c,a.cnt+1));
							q.add(new Coin(bnr,bnc,b.cnt+1));
					}
					else if(map[anr][anc] != '#' && map[bnr][bnc] == '#') {
							q.add(new Coin(anr,anc,a.cnt+1));
							q.add(new Coin(b.r,b.c,b.cnt+1));
					}
					else {
						q.add(new Coin(anr,anc,a.cnt+1));
						q.add(new Coin(bnr,bnc,b.cnt+1));
					}
					
				}
			}
			
		}
		
		return -1;
	}

	private static boolean inArea(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
