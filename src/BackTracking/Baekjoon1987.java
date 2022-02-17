package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1987 {

	static int R,C,max;
	static char map[][];
	static String s;
	static boolean[] visit;
	static int[][] deltas = {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[26];
		
		for(int i=0;i<R;i++)
			map[i] = br.readLine().toCharArray();
		
		sol(0,0,1);
		System.out.println(max);
	}
	private static void sol(int r, int c, int cnt) {
		
		visit[map[r][c] - 'A'] = true;
		
		for(int i=0;i<4;i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
		
			if(inArea(nr,nc))
				if(!visit[map[nr][nc] - 'A']) sol(nr,nc,cnt+1);
		}
		visit[map[r][c] - 'A'] = false;
		max = Math.max(max, cnt);
		
	}
	
	private static boolean inArea(int nr, int nc) {
		return nr < R && nc < C && nr >= 0 && nc >= 0;
	}

}
