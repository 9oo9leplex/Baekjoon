package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14503 {

	// dr,dc는 서남동북 탐색 
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
			// 기존 북(0), 동(1), 남(2), 서(3)
			// 변경 북(0), 서(1), 남(2), 동(3)
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
				// 4방향 탐색 후 변경된 것이 있는지 체크하는 변수
//				System.out.println("방향: "+dir);
//				for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//				System.out.println();
				
				flag = false;
				for (int i = 0; i < 4; i++) {
					// 원래 위치(r,c)에서 4방향 체크
					// *** dr,dc 는 0부터 탐색 *** 
					nr = r + dr[(dir+i)%4];
					nc = c + dc[(dir+i)%4];
					// 변경된 위치가 0이면 청소
					if (inArea(nr, nc) && map[nr][nc] == 0) {
						// 청소 0 => 2
						map[nr][nc] = 2;
						// 원래 위치,방향 최신화
						r = nr;
						c = nc;
						// *** i는 0부터 시작 ***
						// 뭔가 변경됐다면 dir 값에 1를 더한후 i 값을 더해야 맞음 ***
						dir = (dir+i+1)%4;
						cnt++;
						// 변경 사항 저장
						flag = true;
						break;
					}				
				}
				// 바뀐게 있다면 변경된 위치에서 다시 수행
				if(flag) continue;
				// 바뀐게 없다면 기존 위치에서 후진
				// *** dr,dc는 서남동북 탐색 ***   
				r += dr[(dir+1)%4];
				c += dc[(dir+1)%4];
				// 후진한 곳이 범위를 벗어나는지 ,벽인지 체크
				if(!inArea(r, c) || map[r][c] == 1) {
					System.out.println(cnt);
					break;
				}
				
				
			}

		}

		private static boolean inArea(int nr, int nc) {
			return nr >= 0 && nr < N && nc >= 0 && nc < M;
		}

}
