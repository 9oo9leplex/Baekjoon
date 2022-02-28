package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1 9
XXXXXXXXX
XXXHXXXXX
XXHAHXXHX


 */
public class AP {

	public static void main(String[] args) throws IOException{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int dr[] = {-1,1,0,0};
		int dc[] = {0,0,-1,1};
		
		for(int t=1;t<=T;t++) {
			// 배열 크기
			int N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][];
			for(int i=0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int nr,nc;
			
			// 기지국 찾기
			for(int r=0;r<N;r++) {
				for (int c=0;c<N;c++) {
					// 기지국이라면
					if(map[r][c]>='A' && map[r][c] <= 'C') {
						for(int k=1;k<= (map[r][c]-'A')+1;k++) {
						// 기지국 4방 탐색
							for(int d=0;d<4;d++) {
								nr = r + k*dr[d];
								nc = c + k*dc[d];
								if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc] == 'H') {
									map[nr][nc] = 'X';
								}
							}
//							nr = r;
//							nc = c;
							// 기지국의 유형만큼 칸을 탐색
//							for(int k=1;k<=(map[r][c] -'A')+1;k++) {
//								nr += dr[d];
//								nc += dc[d];
//								if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc] == 'H') {
//									map[nr][nc] = 'X';
//								}
//							}
						}
					}
				}
			}

			int hCnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 'H') hCnt++;
				}
			}
			System.out.println("#"+t+" "+hCnt);
		}
	}

}
