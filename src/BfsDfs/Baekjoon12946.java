package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon12946 {

	static int dr[] = {-1,-1,0,1,1,0};
	static int dc[] = {0,1,1,0,-1,-1};
	static int answer;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		char[][] map = new char[51][51];
		
		for(int i=0;i<n;i++) map[i] = br.readLine().toCharArray();	
		
		int[][] col = new int[51][51];
		for(int i=0;i<51;i++) Arrays.fill(col[i], -1);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 'X' && col[i][j] == -1) dfs(i,j,0,col,n,map);
			}
		}
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int k, int[][] col,int n,char[][] map) {
		
		col[r][c] = k;
		answer = Math.max(answer, 1);
		
		for(int i=0;i<6;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!inArea(n, nr, nc) || map[nr][nc] != 'X') continue;
			if(col[nr][nc] == -1) dfs(nr, nc, 1-k, col, n,map);
			answer  = Math.max(answer, 2);
			if(col[nr][nc] == k) answer = Math.max(answer, 3);
		}	
	}
	
	private static boolean inArea(int n, int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}
}
