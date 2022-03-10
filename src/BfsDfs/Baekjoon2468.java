package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2468 {

	static int map[][],n,result,max;
	static boolean visit[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int height = Integer.parseInt(st.nextToken());
				map[i][j] = height;
				max = Math.max(max, height);
			}
		}
		
		for(int i=0;i<=max;i++) {
			visit = new boolean[n][n];
			int tmp = 0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(!visit[j][k] && map[j][k] >= i) {
						bfs(j,k,i);
						tmp++;
					}
				}
			}
			result = Math.max(result, tmp);
		}
		System.out.println(result);
	}

	private static void bfs(int x, int y, int h) {
		
		if(visit[x][y]) return;
		visit[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if(inArea(nr, nc) && map[nr][nc] >= h && !visit[nr][nc])
				bfs(nr,nc,h);
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr < n && nr >= 0 && nc < n && nc >= 0;
	}

}
