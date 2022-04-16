package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	// 북,동,남,서 => 서, 남, 동, 북
	// dir == 0 => 0,-1
	// dir == 1 => -1,0
	// dir == 2 => 0,1
	// dir == 3 => 1,0

	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	static int N, M, r, c, dir, map[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		dir = dir % 2 == 1 ? (dir+2)%4 : dir;
		int cnt = 1;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[r][c] = 2;

		// 현재 위치(r,c), 방향(dir)에서 좌회전, dr[dir], dc[dir]
		int nr, nc;
		boolean flag;

		while (true) {
			flag = true;
			
//			System.out.println("[r,c,dir] ["+r+","+c+","+dir+"]");
//			for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//			System.out.println();
			
			for (int i = 1; i < 5; i++) {

				nr = r + dr[(dir+i)%4];
				nc = c + dc[(dir+i)%4];
				
//				System.out.println("dir: "+dir+", i: "+i+", dir+i: "+ (dir+i)%4);
				
				if (inArea(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					r = nr;
					c = nc;
					
					dir = (dir+i)%4;
					cnt++;
					flag = false;
					break;
				}				
			}
			
			if(!flag) continue;
			// 바뀐게 없다면 기존 위치에서 후진
			r -= dr[dir];
			c -= dc[dir];
			if(map[r][c] == 1) {
				System.out.println(cnt);
				break;
			}
			
			
		}

	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nc < N && nc >= 0 && nc < M;
	}

}
