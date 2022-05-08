package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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
	
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
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
		List<Integer> next = new ArrayList<>();
		String convert;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(visit[i][j]) continue;
				q.add(new Node(i, j, map[i][j]));
				room++;
				size = 1;
				while(!q.isEmpty()) {
					node = q.poll();
					convert = Integer.toBinaryString((node.d & 15));
					
					System.out.println(convert);
					for(int d=0;d<4;d++) {
//						System.out.println((byte)15);
//						convert = node.d & (byte)15;
//						System.out.println("c: "+convert);
//						if(node.d & (1 << (d+1)) == 1 ) continue;
						nr = node.r + dr[d];
						nc = node.c + dc[d];
						
						if(inArea(nr,nc) && !visit[nr][nc]) {
							visit[nr][nc] = true;
							q.add(new Node(nr, nc, map[nr][nc]));
							size++;
						}
					}
				}
				max = Math.max(max, size);
			}
		}
		System.out.println("room: "+room);
		System.out.println("max: "+max);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
















