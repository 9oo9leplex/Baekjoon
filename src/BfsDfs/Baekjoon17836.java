package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17836 {

	static int N,M,T,time,point,map[][];
	static boolean[][] visit;
	static boolean getSword, isFail;
	
	static class Destination{
		int r,c;

		public Destination(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		// 칼 ~ 도착지점 저장 변수
		int distance = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					// 도착 지점 ~ 칼 거리
					distance = ((N-1) - i) + ((M-1) - j);
				}
			}
		}
		
		// 칼을 얻었는지 판별 변수
		getSword = false;
		// 도착 못하는 지 저장 변수
		isFail = false;

		bfs(0,0);

		// 도착하든 못하든 칼을 얻었는지
		if(getSword) {
			// 도착 못했다면 time 변수가 초기 값 0임
			// 도착 못하고 && 칼~도착 거리 + 출발~칼 거리 > 시간 제한
			if(time == 0 && distance + point > T) System.out.println("Fail");
			// 도착 했으면 ? Math.min(걸린시간, 출발 ~ 칼 ~ 도착 거리) : 칼~도착 + 출발~칼 : 도착 못했다면 칼~도착 + 출발~칼 
			else System.out.println(time != 0 ? Math.min(time, distance + point) : distance + point);
		}
		// 칼 못 얻었으면
		else {
			// 도착 못했다면
			if(isFail) System.out.println("Fail");
			// 도착했다면
			else System.out.println(time);
		}
		
	}
	
	private static void bfs(int r, int c) {

		Queue<Destination> q = new LinkedList<>();
		q.add(new Destination(r, c));
		visit[r][c] = true;
		
		int cnt = -1;
		// 큐 사이즈, 1 사이클
		int size,loop;
		
		while(!q.isEmpty()) {
			
			size = q.size();
			loop = 0;
			cnt++;
			
			// 1사이클 끝나고 시간 제한 걸리는 지 체크
			if(cnt > T) {
				isFail = true;
				break;
			}
			// 1 사이클
			while(size > loop) {
			
				Destination d = q.poll();
				loop++;
				// 도착했다면 time에 시간 저장
				if(d.r == N-1 && d.c == M-1) {
					time = cnt;
					return;
				}
				// 4방 탐색
				for(int i=0;i<4;i++) {
					int nr = d.r + dr[i];
					int nc = d.c + dc[i];
					// 범위[N,M] 안이고, 방문한 적 없고, 벽이 아니면
					if(inArea(nr,nc) && !visit[nr][nc] && map[nr][nc] != 1) {
						// 방문 처리
						visit[nr][nc] = true;
						// 칼이면
						if(map[nr][nc] == 2) {
							// 시작 ~ 칼 거리 저장
							point = cnt+1;
							// 칼 획득 
							getSword = true;
						}
						// 다음 위치 저장
						q.add(new Destination(nr, nc));
					}
				}
			}
		}
		
		// 큐가 없어질 동안 도달 못했다면 Fail
		isFail = true;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
