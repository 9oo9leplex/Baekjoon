package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon15683 {

	static int N,M,size,map[][],result = Integer.MAX_VALUE;
	static class Cctv {
		int r,c,type;

		public Cctv(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	
	static ArrayList<Cctv> list;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static int[][][] dir = {
			{},
			{{0},{1},{2},{3}}, // [0][0][0] ~ [0][0][3]
			{{0,2},{1,3}},		// [1].length
			{{0,1},{1,2},{2,3},{3,0}},
			{{0,1,2},{0,1,3},{0,2,3},{1,2,3}},
			{{0,1,2,3}},
	};
	
	static int[][] tmp;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0 || map[i][j] == 6) continue;
				
				list.add(new Cctv(i,j,map[i][j]));
			}
		}

		size = list.size();
		tmp = new int[size][];

		dfs(0);
		
		System.out.println(result);
	}

	private static void dfs(int depth) {
		
		if(depth == size) {			
			counting();
			return;
		}
		
		Cctv cur = list.get(depth);
		int len = dir[cur.type].length;
		
		tmp[depth] = new int[len];			
		
		for(int i=0;i<len;i++) {
			tmp[depth] = dir[cur.type][i];
			dfs(depth+1);
		}
	}

	private static void counting() {

		int blank = 0;
		int[][] m = new int[N][M];
		
		// 배열 복사
		for(int i=0;i<N;i++) m[i] = map[i].clone();
		
		int nr,nc,loop;
		Cctv cur;
		
		// tmp 정보로 map 변경
		for(int i=0;i<size;i++) {
			cur = list.get(i);
			for(int j=0;j<tmp[i].length;j++) {
				loop = 1;
				while(true) {
					nr = cur.r + dr[tmp[i][j]] * loop; 
					nc = cur.c + dc[tmp[i][j]] * loop; 
					
					if(!inArea(nr,nc) || m[nr][nc] == 6) break;
					
					m[nr][nc] = 9;
					loop++;
				}
			}
		}
		
		// blank 계산
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(m[i][j] == 0) blank++;
			}
		}

		result = Math.min(blank, result);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
