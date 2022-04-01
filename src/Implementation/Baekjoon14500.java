package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14500 {

	static int r,c,dir,map[][],min;
	static boolean visit[][];
	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	static int[][][] oh =
		{
				{{0,0},{-1,0},{0,-1},{0,1}}, // ㅗ
				{{0,0},{0,-1},{0,1},{1,0}}, // ㅜ
				{{0,0},{-1,0},{0,1},{1,0}}, // ㅏ
				{{0,0},{0,-1},{-1,0},{1,0}} // ㅓ
		};
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		visit = new boolean[r][c];
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = 0;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				visit[i][j] = true;
				dfs(i,j,0,0);
				visit[i][j] = false;
				
				checkOh(i,j);
			}
		}
		System.out.println(min);
		
	}

	private static void checkOh(int row, int col) {

		for(int i=0;i<4;i++) {
			int[][] o = oh[i];
			int result = 0;
			
			for(int j=0;j<4;j++) {
				int nr = row + o[j][0];
				int nc = col + o[j][1];
				
				if(!inArea(nr, nc)) break;
				
				result += map[nr][nc];
			}
			
			min = Math.max(min, result);
		}
		
	}

	private static void dfs(int row, int col, int depth, int score) {
		
		if(depth == 4) {
			min = Math.max(min, score);
			return;
		}

		score += map[row][col];
		
		for(int i=0;i<4;i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(inArea(nr, nc) && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr, nc, depth+1, score);
				visit[nr][nc] = false;
			}
		}
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < r && nc < c;
	}

}
