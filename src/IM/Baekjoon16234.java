package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon16234 {

	static int n,min,max;
	static int map[][];
	static boolean visit[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static boolean flag;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
	
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
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
		
		visit = new boolean[n][n];
		List<int[]> list = new ArrayList<>();
		List<int[]> move = new ArrayList<>();
		int nr,nc,cnt,sum,avg,tmp[],value,diff;
		flag = true;
		// dfs로 연결되는 모든 놈들 리스트에 추가
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]) continue;
				list.add(new int[] {i,j});
				move.add(new int[] {i,j});
				visit[i][j] = true;
				value = map[i][j];
				sum = value;
				cnt = 1;
			
				while(!move.isEmpty()) {
					tmp = move.remove(0);
					for(int k=0;k<4;k++) {
						nr = tmp[0] + dr[k];
						nc = tmp[1] + dc[k];
						
						if(inArea(nr, nc) && !visit[nr][nc]) {
							diff = Math.abs(map[tmp[0]][tmp[1]] - map[nr][nc]);

							if(diff >= min && diff <= max) {
								list.add(new int[] {nr,nc});
								move.add(new int[] {nr,nc});							
								visit[nr][nc] = true;
								sum += map[nr][nc];
								cnt++;
								
							}
						}
					}
				}
		
				if(list.size() > 1) flag = false;
				
				avg = sum / cnt;
				while(!list.isEmpty()) {
					tmp = list.remove(0);
					map[tmp[0]][tmp[1]] = avg;
				}
			}
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < n && nc < n;
	}
}
