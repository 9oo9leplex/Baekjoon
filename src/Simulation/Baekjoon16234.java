package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16234 {

	static int N,MIN,MAX,map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static boolean visit[][],flag;
	static Queue<int[]> list = new LinkedList<int[]>();		
	static Queue<int[]> move = new LinkedList<int[]>();
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		MIN = Integer.parseInt(st.nextToken());
		MAX = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int day = 0;
		while(true) {
			openGate();
			if(flag) break;
			day++;
		}
		System.out.println(day);
	}

	private static void openGate() {
		
		visit = new boolean[N][N];
		flag = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]) continue;
				
				visit[i][j] = true;
				int sum = map[i][j];
				list.add(new int[] {i,j});
				move.add(new int[] {i,j});
				int cnt = 1;
				
				while(!move.isEmpty()) {
					int tmp[] = move.poll();
					
					for(int k=0;k<4;k++) {
						int nr = tmp[0] + dr[k];
						int nc = tmp[1] + dc[k];
						
						if(inArea(nr, nc) && !visit[nr][nc]) {
							int diff = Math.abs(map[nr][nc] - map[tmp[0]][tmp[1]]);
							if(diff >= MIN && diff <= MAX) {
								list.add(new int[] {nr,nc});
								move.add(new int[] {nr,nc});
								cnt++;
								sum += map[nr][nc];
								visit[nr][nc] = true;
							}
						}
					}
				}
				
				if(list.size() > 1) flag = false;
				
				int avg = sum / cnt;
				while(!list.isEmpty()) {
					int tmp[] = list.poll();
					map[tmp[0]][tmp[1]] = avg;
				}
			}
		}
		
		
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
