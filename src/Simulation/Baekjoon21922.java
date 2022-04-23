package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon21922 {

	static int R,C,map[][];
	static Queue<int[]> aircon;
	
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		aircon = new LinkedList<>();
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) aircon.add(new int[] {i,j});
			}
		}
		
		System.out.println( aircon.size() > 0 ? bfs() : 0);
	}


	private static int bfs() {
		
		int cnt = 0;
		int nr,nc,dir;
		
		while(!aircon.isEmpty()) {
			int[] now = aircon.poll();
			
			if(!visit[now[0]][now[1]]) {
				visit[now[0]][now[1]] = true;
				cnt++;
			}
			
			
			for(int i=0;i<4;i++) {
				dir = i;
				nr = now[0];
				nc = now[1];
				
				while(true) {

					nr += dr[dir];
					nc += dc[dir];
					
					if(!inArea(nr,nc)) break;
					if( dir == 0 || dir == 2) {
						 if(map[nr][nc] == 2 ) {
							 if(!visit[nr][nc]) {
								 visit[nr][nc] = true;
								 cnt++;
							 }						
							 break;
						 }
					} else {
						if(map[nr][nc] == 1) {
							if(!visit[nr][nc]) {
								visit[nr][nc] = true;
								cnt++;
							}
							break;
						}
					}
					
					if(map[nr][nc] != 0 && map[nr][nc] != 9) {
						
						if(dir == 0) {
							if(map[nr][nc] == 3) dir = 1;
							else if(map[nr][nc] == 4) dir = 3;
						}
						else if(dir == 1) {
							if(map[nr][nc] == 3) dir = 0;
							else if(map[nr][nc] == 4) dir = 2;
						}
						else if(dir == 2) {
							if(map[nr][nc] == 3) dir = 3;
							else if(map[nr][nc] == 4) dir = 1;
						}
						else {
							if(map[nr][nc] == 3) dir = 2;
							else if(map[nr][nc] == 4) dir = 0;
						}
					}
					
					if(!visit[nr][nc]) {
						visit[nr][nc] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}


	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}

/* 기만자 코드
//https://www.acmicpc.net/workbook/view/7942

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static class Position {
      int x;
      int y;

      public Position(int x, int y) {
          this.x = x;
          this.y = y;
      }
  }
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  static int N, M;
  static int[][] lab;
  static List<Position> fans = new ArrayList<>();
  static boolean[][] visited;
  static int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  static void input() {
      N = scan.nextInt();
      M = scan.nextInt();
      visited = new boolean[N][M];
      lab = new int[N][M];
      fans = new ArrayList<>();
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
              int num = scan.nextInt();
              lab[i][j] = num;
              if( num == 9) {
                  fans.add(new Position(i, j));
              }
          }
      }
  }


  static int change_dir(int object, int dir) {
      if(object==1) {
          if(dir == 2) {
              return -1;
          }
          if(dir == 3) {
              return -1;
          }
      }

      if(object == 2) {
          if(dir==0) {
              return -1;
          }
          if(dir==1) {
              return -1;
          }
      }

      if(object==3) {
          if(dir==0) {
              return 3;
          }
          if(dir==1) {
              return 2;
          }
          if(dir==2) {
              return 1;
          }
          if(dir==3) {
              return 0;
          }
      }

      if(object==4) {
          if(dir==0) {
              return 2;
          }
          if(dir==1) {
              return 3;
          }
          if(dir==2) {
              return 0;
          }
          if(dir==3) {
              return 1;
          }
      }

      return dir;

  }

  static void blow(int x, int y, int dir) {
      while(true) {
          visited[x][y] = true;
          if(dir == -1) {
              break;
          }
          x += moves[dir][0]; y += moves[dir][1];
          if(!(0<= x && x < N && 0 <= y && y < M)) {
              break;
          }

          if(lab[x][y] == 9) {
             break;
          }
          if(!(0<= x && x < N && 0 <= y && y < M)  && lab[x][y] == 9) {
              break;
          }
          if( lab[x][y] >= 1) {
              dir = change_dir(lab[x][y], dir);
          }
      }
  }

  static void sol() {
      for(Position fan : fans) {
          for (int i = 0; i < 4; i++) {
              blow(fan.x, fan.y, i);
          }
      }
  }

  static void print() {
      int cnt = 0;
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
              if(visited[i][j]) {
                  cnt++;
              }
          }
      }
      System.out.println(cnt);
  }

  public static void main(String[] args) {
      input();
      sol();
      print();
  }

  static class FastReader {
      BufferedReader br;
      StringTokenizer st;

      public FastReader() {
          br = new BufferedReader(new InputStreamReader(System.in));
      }

      public FastReader(String s) throws FileNotFoundException {
          br = new BufferedReader(new FileReader(new File(s)));
      }

      String next() {
          while ( st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }

      int nextInt() {
          return Integer.parseInt(next());
      }

      long nextLong() {
          return Long.parseLong(next());
      }

      double nextDouble() {
          return Double.parseDouble(next());
      }

      String nextString() {
          String str = "";
          try {
              str = br.readLine();
          } catch (IOException e) {
              e.printStackTrace();
          }
          return str;
      }
  }
}
*/