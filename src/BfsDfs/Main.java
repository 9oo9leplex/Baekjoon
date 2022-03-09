package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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
			bfs(0,0,i);
		}
		
	}

	private static void bfs(int x, int y, int h) {
		
		if(visit[x][y]) return;
		visit[x][y] = true;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visit[i][j] && map[i][j] >= h) bfs(i,j,h);
			}
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr < n && nr >= 0 && nc < n && nc >= 0;
	}
}
