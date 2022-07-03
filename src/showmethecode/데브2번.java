package showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 데브2번 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
//		boolean horizontal = true;
		boolean horizontal = false;
		
		int[][] map = new int[n][n];
		int idx = 1;
		map[0][0] = 1;
//		System.out.println(Arrays.toString(map[0]));
		for(int r=1;r<n;r++) {
			map[r][r] = map[r-1][r-1] +  2 * r;
//			System.out.println(Arrays.toString(map[r]));
		}
		
		for(int r=1;r<n;r++) {
			if(r % 2 == 1) {
				if(horizontal) {
					for(int c=r-1;c>=0;c--) map[r][c] = map[r][c+1] + 1;
					for(int rr=r-1;rr>=0;rr--) map[rr][r] = map[rr+1][r] - 1;
				}
				else {
					for(int c=r-1;c>=0;c--) map[r][c] = map[r][c+1] - 1;
					for(int rr=r-1;rr>=0;rr--) map[rr][r] = map[rr+1][r] + 1;
				}
			}
			else {
				if(!horizontal) {
					for(int c=r-1;c>=0;c--) map[r][c] = map[r][c+1] + 1;
					for(int rr=r-1;rr>=0;rr--) map[rr][r] = map[rr+1][r] - 1;
				}
				else {
					for(int c=r-1;c>=0;c--) map[r][c] = map[r][c+1] - 1;
					for(int rr=r-1;rr>=0;rr--) map[rr][r] = map[rr+1][r] + 1;
				}
			}
		}
	
		for(int r=0;r<n;r++) {
			System.out.println(Arrays.toString(map[r]));
		}
	}
}
