package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1012 {

	static int c, r, n, cnt, result, map[][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean visit[][];
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			result = cnt = 0;

			map = new int[r][c];
			visit = new boolean[r][c];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int end = Integer.parseInt(st.nextToken());
				int start = Integer.parseInt(st.nextToken());
				map[start][end] = 1;
				q.offer(new int[] { start, end });
			}

			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				dfs(tmp[0],tmp[1]);
				result = cnt != 0 ? result+1 : result;
				cnt = 0;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int start, int end) {
		
		if(!inArea(start, end) || visit[start][end] || map[start][end] == 0) return;
		cnt++;
		visit[start][end] = true;
		
		for(int i=0;i<4;i++) {
			int nr = start + dr[i];
			int nc = end + dc[i];
			
			dfs(nr,nc);
		}

	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}

}


}
