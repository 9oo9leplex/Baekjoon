package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17144 {

	static int r,c,ac,map[][],tmp[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		tmp = new int[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1)
					ac = i;
			}
		}
		
		for(int i=0;i<t;i++) {
			boom();
			refresh();
		}		
		int result = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				result += map[i][j];
			}
		}
		System.out.println(result+2);
	}

	private static void refresh() {
		
		for(int i=0;i<r;i++) {
			System.arraycopy(map[i], 0, tmp[i], 0, map[0].length);
		}

		int a = 0, b=0;
		int t = map[a][b] == -1 ? 0 : map[a][b];
		
		while(true) {
			if(a == 0 && b < c-1) {
				tmp[a][b] = tmp[a][b+1];
				b++;
			} else if(b == c-1 && a < ac-1) {
				tmp[a][b] = tmp[a+1][b];
				a++;
			} else if(a == ac-1 && b > 0) {
				if(b==1) {
					tmp[a][1] = 0;
					b--; continue;
				}
				tmp[a][b] = tmp[a][b-1];
				b--;
			} else if(a > 0 && b == 0){
				if(a == ac-1) {
					a--; continue;
				}
				tmp[a][b] = tmp[a-1][b];
				a--;
				if(a == 0 && b == 0) break;
			}
		} 
		if(ac-1 != 1 && ac-1 != 0)
			tmp[1][0] = t;
		
		if(ac == r)
			a = ac;
		else
			a = ac+1;
		b = 0;

		while(true) {
			if(b == 0 && a+1 < r) {
				tmp[a][b] = tmp[a+1][b];
				a++;
			} else if(a == r-1 && b+1 < c) {
				tmp[a][b] = tmp[a][b+1];
				b++;
			} else if(b == c-1 && a > ac) {
				tmp[a][b] = tmp[a-1][b];
				a--;
			} else if(a == ac && b > 0) {
				if(b == 1) {
					b--; tmp[a][1] = 0;
					break;
				}
				tmp[a][b] = tmp[a][b-1];
				b--;
			}
		}
		
		for(int i=0;i<r;i++) {
			System.arraycopy(tmp[i], 0, map[i], 0, tmp[0].length);
		}
	}

	private static void boom() {
		
		for(int i=0;i<r;i++) {
			System.arraycopy(map[i], 0, tmp[i], 0, map[0].length);
		}
		
		for(int row=0;row<r;row++) {
			for(int col=0;col<c;col++) {
				int now = map[row][col];
				if(now == 0 || now == -1) continue;
				int cnt=0;
				for(int i=0;i<4;i++) {
					int nr = row + dr[i];
					int nc = col + dc[i];
					if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] != -1) {
						tmp[nr][nc] += now/5;
						cnt++;
					}
				}
				tmp[row][col] -= now/5*cnt; 
			}
		}
		
		for(int i=0;i<r;i++) {
			System.arraycopy(tmp[i], 0, map[i], 0, tmp[0].length);
		}
	}
}
