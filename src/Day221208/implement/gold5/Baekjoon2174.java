package Day221208.implement.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon2174 {

	static class Robot {
		int r,c,d;

		public Robot(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}
	
//	static int[] dr = {0,1,0,-1};
//	static int[] dc = {-1,0,1,0};
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int r,c;
		char d;
		
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put('N', 0);	hm.put('E', 1);	hm.put('S', 2);	hm.put('W', 3);
		
		Robot[] robots = new Robot[n];
		int map[][] = new int[b][a];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			// N,E,S,W
			c = Integer.parseInt(st.nextToken()) - 1;
			r = (b - Integer.parseInt(st.nextToken())) % b;
			d = st.nextToken().charAt(0);
			robots[i] = new Robot(r,c,hm.get(d));
			
			map[r][c] = i+1;
		}
		
		
//		System.out.println(Arrays.toString(robots));
		Robot cur;
		int nr,nc,tmp;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken()) - 1;
			d = st.nextToken().charAt(0);
			c = Integer.parseInt(st.nextToken());
			
			cur = robots[r];
			if(d == 'L') {
				c %= 4;
				tmp = c * 3;
				cur.d = (cur.d + tmp) % 4;
//				System.out.println(cur);
			}
			else if(d == 'R') {
				cur.d = (cur.d + c) % 4;
//				System.out.println(cur);
			}
			else {
				nr = cur.r;
				nc = cur.c;
				for(int j=0;j<c;j++) {
					nr += dr[cur.d];
					nc += dc[cur.d];
					
//					System.out.println("[nr,nc]: ["+nr+","+nc+"]");
					
					if(!inArea(a,b,nr,nc)) {
						System.out.printf("Robot %d crashes into the wall",(r+1));
						return;
					}
					else if(map[nr][nc] != 0) {
						System.out.printf("Robot %d crashes into robot %d",(r+1),map[nr][nc]);
						return;
					}
				}
				map[cur.r][cur.c] = 0;
				cur.r = nr;
				cur.c = nc;
				map[cur.r][cur.c] = r + 1;
				
				
//				for(int j=0;j<b;j++) System.out.println(Arrays.toString(map[j]));
//				System.out.println();
			}
		}
		System.out.println("OK");
	}
	
	static boolean inArea(int a, int b, int nr, int nc) {
		return nr >= 0 && nr < b && nc >= 0 && nc < a;
	}

}
