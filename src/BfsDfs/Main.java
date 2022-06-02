package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 19238
public class Main {

	static int N,M,K,row,col, map[][],result = Integer.MAX_VALUE;

	static class Node {
		int r, c, gas,d;

		public Node(int r, int c, int gas, int d) {
			super();
			this.r = r;
			this.c = c;
			this.gas = gas;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", gas=" + gas + ", d=" + d + "]";
		}
	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static boolean[][] visit;
	static List<Node> list;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken()) - 1;
		col = Integer.parseInt(st.nextToken()) - 1;
		
		int r,c;
		list = new ArrayList<>();
		
		for(int i=2;i<M+2;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = i;
			
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
//			map[r][c] = i + M;
			list.add(new Node(r, c, 0, 0));
		}
		
//		for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//		System.out.println();
		
		System.out.println(bfs());
	}

	

	private static int bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(row,col,K,0));
		visit = new boolean[N][N];
		visit[row][col] = true;

		int completed = 0;
		
		Node node;
		int nr,nc,size,targetNum = 500;
		boolean flag = false;
		
		Queue<Integer> guest = new LinkedList<>();
		
		while(!q.isEmpty()) {
			
			size = q.size();
			
			for(int k=0;k<size;k++) {
				
				node = q.poll();
				System.out.println("[n,r]: ["+node.r+","+node.c+"]");
				if(node.gas == 0) return -1;
				if(completed == M) return node.gas;
				
				for(int i=0;i<4;i++) {
					nr = node.r + dr[i];
					nc = node.c + dc[i];
					
					if(inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] != 1) {
						// 손님이 없다면
						if(guest.isEmpty()) {
							if(map[nr][nc] != 0) {
								
								targetNum = Math.min(targetNum, map[nr][nc]);
								flag = true;
//								q.add(new Node(nr,nc,node.gas-1,0));
//								visit = new boolean[N][N];
//								guest.add(map[nr][nc]-2);
//								map[nr][nc] = 0;
//								visit[nr][nc] = true;							
//							break;
							}
							else {
								q.add(new Node(nr,nc,node.gas-1,0));
								visit[nr][nc] = true;							
							}
						}
						// 손님이 있다면
						else {
							if(nr == list.get(guest.peek()).r && nc == list.get(guest.peek()).c) {
								completed++;
								targetNum = 500;
								guest.poll();
								q.clear();
								q.add(new Node(nr,nc,node.gas-1+(node.d+1)*2,0));
								visit = new boolean[N][N];
								visit[nr][nc] = true;
								break;
							}
							else {							
								q.add(new Node(nr,nc,node.gas-1,node.d+1));
								visit[nr][nc] = true;
							}
						}
					}
				}
			}
			
			// target이 바꼈다면
			if(flag) {
				q.clear();
				node = list.get(targetNum-2);
				q.add(node);
				map[node.r][node.c] = 0;
				visit[node.r][node.c] = true;
				flag = false;
				guest.add(targetNum);
//				System.out.println("[n,r]: ["+node.r+","+node.c+"]");
			}
			
			
		}
		
		return -1;
	}



	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}























