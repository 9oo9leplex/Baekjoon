package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import BfsDfs.TestBFS.Gate;

public class TestBFS {

	static int N,M,K,result,map[][];
	static class Gate{
		int r,c,t;

		public Gate(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Gate [r=" + r + ", c=" + c + ", t=" + t + "]";
		}
	}
	
	static Queue<Gate> gates;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=55;t++) {
			st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		gates = new LinkedList<>();
		
		visit = new boolean[N][M];
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 4) {
					gates.add(new Gate(i, j,0));
					visit[i][j] = true;
				}
			}
		}
		
		bfs();
//		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		sb.append("#").append(t).append(" ").append(result == Integer.MAX_VALUE ? -1 : result).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		
		int nr,nc,size;
		Gate move;
		
		while(!gates.isEmpty()) {
			
			size = gates.size();
			for(int i=0;i<size;i++) {
				move = gates.poll();
				visit[move.r][move.c] = true;
				if(move.t >= K) continue;
//				System.out.println("[r,c,t]: ["+move.r+","+move.c+","+move.t+"]");
				for(int j=0;j<4;j++) {
					nr = move.r + dr[j];
					nc = move.c + dc[j];
					
					if(inArea(nr,nc) && !visit[nr][nc] && map[nr][nc] != 1) {
						if(map[nr][nc] == 3) {
//							System.out.println("[r,c,t]: ["+nr+","+nc+","+(move.t+1)+"]");
							if(move.t + 1 <= K) result = Math.min(result, move.t+1);
						}
						else {
							if(map[nr][nc] == 2) gates.add(new Gate(nr,nc,move.t+2));
							else gates.add(new Gate(nr,nc,move.t+1));
						}
					}
				}
			}
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
