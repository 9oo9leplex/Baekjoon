package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17135 {

	static int N,M,D,map[][],newMap[][],max,sum;
	static boolean[][] v;
	static int[] dr = {0,0,-1};
	static int[] dc = {-1,1,0};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		newMap = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i=0;i<M-2;i++) {
			for(int j=i+1;j<M-1;j++) {
				for(int k=j+1;k<M;k++) {
					int[][] copy = new int[N][];
					for(int n=0;n<N;n++)
						copy[n] = map[n].clone();
					answer = Math.max(answer, battle(copy, new int[] {i,j,k}));
				}
			}
		}
		System.out.println(answer);
	}

	private static int battle(int[][] copy, int[] archers) {
		int cnt = 0;
		
		for(int n = N; n > 0; n--) {
			// set target
			int[][] enemy = new int[3][];
			for(int i=0;i<3;i++)
				enemy[i] = target(copy,n,archers[i]);
			
			for(int i=0;i<3;i++) {
				if(enemy[i] == null) continue;
				
				int row = enemy[i][0];
				int col = enemy[i][1];
				
				if(copy[row][col] == 1) {
					copy[row][col] = 0;
					cnt++;
				}
						
			}
		}
		
		return cnt;
	}

	private static int[] target(int[][] m, int r, int c) {

		for(int d=1; d<=D; d++) {
			int row = r;
			int col = c - d;
			
			for(int i=1;i<2*d;i++) {
				row += (i>d)? 1 : -1;
				col++;
				if(!inArea(row, col)) continue;
				if(m[row][col] == 1) return new int[]{row,col};
			}
		}
		
		return null;
	}

	private static boolean inArea(int nr,int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}














