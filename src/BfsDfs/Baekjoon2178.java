package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {

	static int r, c, result = 0,map[][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean visit[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

//		boolean[][] map = new boolean[r][c];
		map = new int[r][c];
		visit = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
					map[i][j] = tmp[j] - '0';
			}
		}

//		dfs(0,0,1,map);
//		dfs(r-1,c-1,1);
		visit[0][0] = true;
		bfs(0, 0);
		System.out.println(map[r-1][c-1]);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int x = now[0];
			int y = now[1];
			
			for(int a=0;a<4;a++) {
				int nr = x + dr[a];
				int nc = y + dc[a];
				
				if(nr < 0 || nr >= r || nc < 0 || nc >= c || visit[nr][nc] || map[nr][nc] == 0) continue;
//				System.out.println("row: "+nr+", col: "+nc+", map: "+(map[x][y]+1));
				q.add(new int[] {nr,nc});
				map[nr][nc] = map[x][y] + 1;
				visit[nr][nc] = true;
			}
		}
	}

	// private static void dfs(int row, int col, int cnt, boolean[][] map) {
	/*
	private static void dfs(int row, int col, int cnt) {

		if (result <= cnt)
			return;
//		if(row < 0 || row <= r || col < 0 || col <= c) return;
		if (!map[row][col])
			return;

		map[row][col] = false;
		if (row == 0 && col == 0)
			result = Math.min(result, cnt);

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nr == r || nc < 0 || nc == c || !map[nr][nc])
				continue;
			dfs(nr, nc, cnt + 1);
		}
		map[row][col] = true;
		*/
		/*
		 * if(row < 0 || row == r || col < 0 || col == c) return; if(result <= cnt)
		 * return; if(!map[row][col]) return; map[row][col] = false; if(row == r-1 &&
		 * col == c-1) result = Math.min(result, cnt); //
		 * System.out.println("row: "+row+", col: "+col+", result: "+result);
		 * dfs(row-1,col,cnt+1); dfs(row,col+1,cnt+1); dfs(row+1,col,cnt+1);
		 * dfs(row,col-1,cnt+1);
		 * 
		 * map[row][col] = true;
		 */
		/*
		 * if(result <= cnt) return;
		 * 
		 * map[row][col] = false; if(row == r-1 && col == c-1) result = Math.min(result,
		 * cnt);
		 * 
		 * for(int i=0;i<4;i++) { int nr = row + dr[i]; int nc = col + dc[i];
		 * 
		 * if(nr < 0 || nr == r || nc < 0 || nc == c || !map[nr][nc]) continue;
		 * dfs(nr,nc,cnt+1); } map[row][col] = true;
		 */
//	}

}