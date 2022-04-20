package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16509 {

	static class Horse{
		int r,c;

		public Horse(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Horse [r=" + r + ", c=" + c + "]";
		}
		
	}
	static boolean[][] visit;
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int ddr[] = {-1,-1,1,1};
	static int ddc[] = {-1,1,1,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Horse sang = new Horse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		Horse king = new Horse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		Queue<Horse> q = new LinkedList<>();
		q.add(sang);
		
		int result = 0;
		visit = new boolean[10][9];
		
		while(!q.isEmpty()) {

			int size = q.size();
			int cnt = 0;
			
			while(size > cnt) {
				Horse next = q.poll();
				cnt++;
				if(visit[next.r][next.c]) continue;
				
				visit[next.r][next.c] = true;
				
				for(int i=0;i<4;i++) {
					int nr = next.r + dr[i];
					int nc = next.c + dc[i];
					
					if(!inArea(nr,nc) || (nr == king.r && nc == king.c)) continue; 
						
						int nnr,nnc;
						
						for(int j=0;j<2;j++) {
							nnr = nr;
							nnc = nc;
							
							nnr += ddr[(i+j)%4];
							nnc += ddc[(i+j)%4];
							
							if(!inArea(nnr,nnc) || (nnr == king.r && nnc == king.c)) continue;
							
							nnr += ddr[(i+j)%4];
							nnc += ddc[(i+j)%4];
							
							if(!inArea(nnr,nnc) || visit[nnr][nnc]) continue;
							if(nnr == king.r && nnc == king.c) {
								System.out.println(result+1);
								return;
							}
							q.add(new Horse(nnr, nnc));
						}
				}
			}
			result++;
		}
		
		System.out.println(-1);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < 10 && nc < 9;
	}
}
