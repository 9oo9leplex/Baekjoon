package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2234 {

	static int N, M, map[][], dp[][];
	static class Node{
		int r,c,d;

		public Node(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}		
	}
	
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}

	private static void bfs() {

		Queue<Node> q = new LinkedList<>();
		Node node;
		int nr,nc,size,max = Integer.MIN_VALUE,room=0;
		
		// map과 똑같은 크기의 배열을 하나 더 만들고 i입력
		int[][] test = new int[N][M];
		// i 갯수 카운팅해서 따로 가지고 있고
		List<Integer> dp = new ArrayList<>();
		// 배열 사방 탐색해서 max 값 초기화 visit 써서 이미 더한 곳 제외
		
		int index = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(visit[i][j]) continue;
				q.add(new Node(i, j, map[i][j]));
				test[i][j] = ++index;
				visit[i][j] = true;
				room++;
				size = 1;

				while(!q.isEmpty()) {
					node = q.poll();
					

					for(int d=0;d<4;d++) {
						
						if((node.d & ( 1 << d)) != 0) continue;
						
						nr = node.r + dr[d];
						nc = node.c + dc[d];
						
						if(inArea(nr,nc) && !visit[nr][nc]) {
							test[nr][nc] = index;
							visit[nr][nc] = true;
							q.add(new Node(nr, nc, map[nr][nc]));
							size++;
						}
					}
				}
				dp.add(size);
				max = Math.max(max, size);
			}
		}
		
		visit = new boolean[room+1][room+1];
		int doubleRoom = 1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				size = test[i][j];
				for(int k=0;k<4;k++) {
					nr = i + dr[k];
					nc = j + dc[k];
					
					if(!inArea(nr,nc)) continue;
					if(size == test[nr][nc]) continue;
					if(visit[size][test[nr][nc]]) continue;
//					System.out.println("[start,end]: ["+size+","+test[nr][nc]+"]");
					visit[size][test[nr][nc]] = visit[test[nr][nc]][size] = true;
					doubleRoom = Math.max(dp.get(size-1)+dp.get(test[nr][nc]-1), doubleRoom);
					
//					if(inArea(nr,nc) && !visit[nr][nc] && size != test[nr][nc]) {
//						doubleRoom = Math.max(dp.get(size-1)+dp.get(test[i][j]-1), doubleRoom);
//						size = test[i][j];
//						visit[size][test[i][j]] = visit[test[i][j]][size] = true;
//					}
				}
				
//				if(size != test[i][j] && !visit[size][test[i][j]]) {
//					doubleRoom = Math.max(dp.get(size-1)+dp.get(test[i][j]-1), doubleRoom);
//					size = test[i][j];
//					visit[size][test[i][j]] = visit[test[i][j]][size] = true; 
//				}
				
			}
		}
		
//		for(int i=0;i<N;i++)System.out.println(Arrays.toString(map[i]));
		
//		for(int i=0;i<N;i++)System.out.println(Arrays.toString(test[i]));
//		System.out.println(dp);
		StringBuilder sb = new StringBuilder();
		sb.append(room).append("\n").append(max).append("\n").append(doubleRoom);
		System.out.println(sb);
		
		
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
