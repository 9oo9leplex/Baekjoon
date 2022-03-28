package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int map[][], result[][],n,s;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[n][n];
		result = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int len = n;
		List<Integer> list = new ArrayList<>();
		
		int row = 0, col = 0;
		
		while(true) {
			if(len < 1) break;
			
			for(int r=0;r<len;r+=2) {
				for(int c=0;c<len;c+=2) {
					list.add(map[r][c]);
					list.add(map[r][c+1]);
					list.add(map[r+1][c]);
					list.add(map[r+1][c+1]);
					Collections.sort(list);
					map[row][col] = list.get(2);
					col++;
					list.clear();
				}
				row++;
				col = 0;
			}
			row = 0;
			len /= 2;
		}
		
		System.out.println(map[0][0]);
	
		
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}
}
