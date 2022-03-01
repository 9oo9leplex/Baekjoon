package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,map[][],max;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		map = new int[n][6];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				if(j==3)
					map[i][4] = Integer.parseInt(st.nextToken());
				else if(j==4)
					map[i][3] = Integer.parseInt(st.nextToken());
				else
					map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		for(int i=0;i<6;i++)
			dfs(map[0][i],0,0);
		System.out.println(max);
		
	}

	private static void dfs(int down, int index, int sum) {
		if(index == n) {
			max = Math.max(max, sum);
			return;
		}
		if(sum + (n-index)*6 <= max) return;
		
		int up=0;
		for(int i=0;i<6;i++) {
			if(map[index][i] == down) {
				up = map[index][5-i];
				break;
			}
		}
		
		int maxside = 0;
		for(int i=0;i<6;i++) {
			if(map[index][i] == down || map[index][i] == up) continue;
			maxside = Math.max(maxside, map[index][i]);
		}
		dfs(up,index+1,sum+maxside);
	}

}
