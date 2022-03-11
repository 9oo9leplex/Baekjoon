package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2583 {

	static int map[][], n, m, result;
	static boolean visit[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			for(int j=fy;j<sy;j++) {
				for(int k=fx;k<sx;k++)
					map[j][k] = 1;
			}
		}
		int area = 0;
		
		List<Integer> pq = new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visit[i][j] && map[i][j] == 0) {
					bfs(i,j);
					pq.add(result);
					area++;
				}
				result = 0;
			}
		}
		
		Collections.sort(pq);
		
		sb.append(area).append("\n");
		for(int a : pq)
			sb.append(a).append(" ");
		System.out.println(sb);
	}

	private static void bfs(int x,int y) {

		if(visit[x][y] || map[x][y] == 1) return;
		visit[x][y] = true;
		result++;
		for(int i=0;i<4;i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if(inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] == 0) {
				bfs(nr,nc);
			}
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr < n && nr >= 0 && nc < m && nc >= 0;
	}

}
