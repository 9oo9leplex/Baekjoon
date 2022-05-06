package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3055 {

	static int N, M, day;
	static boolean[][] visit;
	static char[][] map;
	
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	static Node end;
	static Queue<Node> starts,waters;
	static List<Node> rocks;
	
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		char[] tmp;
		
		starts = new LinkedList<>();
		waters = new LinkedList<>();
		rocks = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j];
				if(tmp[j] != '.') {
					switch(tmp[j]) {
					case 'S':
						starts.add(new Node(i, j));
						break;
					case 'D':
						end = new Node(i,j);
						break;
					case '*':
						waters.add(new Node(i,j));
						break;
					case 'X':
						rocks.add(new Node(i,j));
						break;
					}
				}
			}
		}

		visit = new boolean[N][M];
		int result = bfs();
		System.out.println(result == 0 ? "KAKTUS" : day);
		
	}

	private static int bfs() {

		int nr,nc,len;
		Node start,water;
		
		while(!starts.isEmpty()) {
			// 물 뿌리기
			day++;
			len = waters.size();
			for(int i=0;i<len;i++) {
				water = waters.poll();
				
				for(int j=0;j<4;j++) {
					nr = water.r + dr[j];
					nc = water.c + dc[j];
					
					if(inArea(nr,nc) && map[nr][nc] == '.') {
						map[nr][nc] = '*';
						waters.add(new Node(nr,nc));
					}
				}
			}
			
			// 고슴도치 이동
			len = starts.size();
			for(int i=0;i<len;i++) {	
				start = starts.poll();
				
				for(int j=0;j<4;j++) {
					nr = start.r + dr[j];
					nc = start.c + dc[j];
					
					if(inArea(nr,nc) && !visit[nr][nc]) {
						
						if(nr == end.r && nc == end.c) return day+1;
						
						if(map[nr][nc] == '.') {
							starts.add(new Node(nr,nc));
							visit[nr][nc] = true;
						}
					}
					
				}
			}
		}
		return 0;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
