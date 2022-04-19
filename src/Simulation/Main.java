package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	
	static int N,K,belt[];
	static boolean robot[];
	static class Horse{
		int r,c;

		public Horse(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static boolean[][] visit;
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int ddr[] = {-1,-1,1,1};
	static int ddc[] = {-1,1,1,-11};
	
	
//	static int dr[] = {-3,-3,-2,2,3,3,2,-2};
//	static int dc[] = {-2,2,3,3,2,-2,-3,-3};
	
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
				if(visit[next.r][next.c]) {
					cnt++;
					continue;
				}
				
				System.out.println(result+": now["+next.r+","+next.c+"], king["+king.r+","+king.c+"]");
				
				if(next.r == king.r && next.c == king.c) {
					System.out.println(result);
					return;
				}
				
				visit[next.r][next.c] = true;
				
				for(int i=0;i<4;i++) {
					int nr = next.r + dr[i];
					int nc = next.c + dc[i];
					
					if(inArea(nr,nc) && (nr != king.r && nc != king.c)) {
						
						int nnr,nnc;
						boolean flag;
						for(int j=0;j<2;j++) {
							nnr = nr;
							nnc = nc;
							System.out.println("[nr,nc]: ["+nr+","+nc+"]");
							flag = true;
							for(int k=0;k<2;k++) {
								nnr += ddr[(i+j)%4];
								nnc += ddc[(i+j)%4];
								System.out.println("[nnr,nnc]: ["+nnr+","+nnc+"]");
								// 첫번째는 왕과 만나면 안되고
								// 두번째는 만나도 됨
								if(!inArea(nnr,nnc)) flag = false;
								if(k==1 && (nnr == king.r && nnc == king.c)) flag = false;
							}
							
							if(flag) q.add(new Horse(nnr, nnc));
							
						}
					}
				}
				cnt++;
			}
			result++;
		}
		
		System.out.println(-1);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < 10 && nc < 9;
	}
}









