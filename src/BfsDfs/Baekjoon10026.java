package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10026 {

	static int N, result;
	static char map[][];
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		map = new char[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		boolean[][] v = new boolean[N][N];
		
		int[] ans = {0, 0};
	    boolean[][][] visit = new boolean[2][N][N];
//	        for (int k = 0; k < 2; k++) {
//	            for (int i = 0; i < N; i++) {
//	                for (int j = 0; j < N; j++) {
//	                    if (!visit[k][i][j]) {
//	                        dfs(i, j, visit[k], map[i][j]);
//	                        ans[k]++;
//	                    }
//	                    if (map[i][j] == 'G')
//	                        map[i][j] = 'R';
//	                }
//	            }
//	        }
//	        System.out.println(ans[0] + " " + ans[1]);
	    for(int i=0;i<2;i++) {
	    	for(int j=0;j<N;j++) {
	    		for(int k=0;k<N;k++) {
	        		if(!v[j][k]) {
	        			sol(j,k,map[j][k],v);
	        			result++;
	        		}
	        		if(map[j][k] == 'G')
	        			map[j][k] = 'R';
	    		}
	        }
	    	sb.append(result).append(" ");
	    	v = new boolean[N][N];
	    	result = 0;
	    }
	    System.out.println(sb);
	}

	static void dfs(int y, int x, boolean[][] visit, char ch) {
		visit[y][x] = true;

		for (int k = 0; k < 4; k++) {
			int ny = y + deltas[k][0];
			int nx = x + deltas[k][1];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] != ch)
				continue;
			dfs(ny, nx, visit, ch);
		}
	}

	private static void sol(int r, int c, char ex, boolean[][] v) {

		v[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int dr = r + deltas[i][0];
			int dc = c + deltas[i][1];
			// System.out.println("dr: "+dr+", dc: "+dc);
			if (!inArea(dr, dc) || v[dr][dc] || map[dr][dc] != ex)
				continue;
			sol(dr, dc, ex, v);
		}
	}

	private static boolean inArea(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
