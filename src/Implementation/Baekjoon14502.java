package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14502 {

	static int N, M, max, map[][], newMap[][], selected[], com[];
	static boolean visit[][];
	static Queue<int[]> virus;
	static List<int[]> empty;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		newMap = new int[N][M];
		virus = new LinkedList<>();
		empty = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
				else if (map[i][j] == 0)
					empty.add(new int[] { i, j });
			}
		}

		int len = empty.size();
		com = new int[len];
		for (int i = 0; i < len; i++)
			com[i] = i;

		max = 0;
		selected = new int[3];
		combination(0, 0, len);

		System.out.println(max);
	}

	private static void combination(int start, int cnt, int size) {

		if (cnt == 3) {
			
			spread(selected);

			return;
		}

		for (int i = start; i < size; i++) {
			selected[cnt] = com[i];
			combination(i + 1, cnt + 1, size);
		}
	}

	private static void spread(int[] s) {

		int[] first = empty.get(s[0]);
		int[] second = empty.get(s[1]);
		int[] thrid = empty.get(s[2]);

		// 배열 상태 복사하기
		copy(map,newMap);
		
		newMap[first[0]][first[1]] = 1;
		newMap[second[0]][second[1]] = 1;
		newMap[thrid[0]][thrid[1]] = 1;
		
		// 바이러스 퍼트리기
		visit = new boolean[N][M];
		
		for(int[] a : virus)
			dfs(a[0],a[1]);
		
		// 계산
		max = Math.max(max, cal());
		
	}

	private static int cal() {
		
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(newMap[i][j] == 0) cnt++;
			}
		}
		
		return cnt;
	}

	private static void dfs(int r, int c) {

		visit[r][c] = true;
		newMap[r][c] = 2;
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(inArea(nr,nc) && !visit[nr][nc] && newMap[nr][nc] == 0) dfs(nr,nc);
		}
	}

	private static boolean inArea(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	static void copy(int[][] m, int[][] newM) {

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				newM[r][c] = m[r][c];
			}
		}
	}

}
