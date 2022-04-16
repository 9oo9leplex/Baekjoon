package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14503 {

	static int r,c,dir,map[][];
	static boolean flag;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		map[row][col] = 2;
		
		// 0 북, 1 동, 2 남, 3 서
		// 0 북, 1 서, 2 남, 3 동
		dir = dir % 2 == 1 ? (dir+2)%4 : dir;
		
		int nr,nc,backr,backc,cnt = 1;
		boolean flag,flag2 = true;
		
		while(true) {

			for(int i=0;i<r;i++) System.out.println(Arrays.toString(map[i]));
			System.out.println();
			
			if(!inArea(row, col) || !flag2) break;
			
			flag = true;
			for(int i=0;i<4;i++) {
				
				nr = row + dr[(i+dir)%4];
				nc = col + dc[(i+dir)%4];
				
				if(inArea(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					row = nr;
					col = nc;
					dir = (i+dir+1)%4;
					cnt++;
					flag = false;
					break;
				}
				
			}
			
			if(!flag) continue;
			
			flag2 = true;
			backr = dr[(dir+1)%4];
			backc = dc[(dir+1)%4];
			
			while(true) {
				if(!flag) break;
				
				row += backr;
				col += backc;
				
				if(!inArea(row, col) || map[row][col] == 1) {
					flag2 = false;
					break;
				}
				
				for(int i=0;i<4;i++) {
					
					nr = row + dr[(i+dir)%4];
					nc = col + dc[(i+dir)%4];
					
					if(inArea(nr, nc) && map[nr][nc] == 0) {
						map[nr][nc] = 2;
						row = nr;
						col = nc;
						dir = (i+dir+1)%4;
						cnt++;
						flag = false;
						break;
					}
					
				}
				
			}
			
		}
		
		
		System.out.println(cnt);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < r && nc < c;
	}

}
