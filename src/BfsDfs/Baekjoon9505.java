package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon9505 {

	static int K,W,H;
	static char[][] map;
	static class Ship implements Comparable<Ship> {
		int r,c,jumsu;
		
		public Ship(int r, int c, int jumsu) {
			super();
			this.r = r;
			this.c = c;
			this.jumsu = jumsu;
		}

		@Override
		public int compareTo(Ship o) {
			if(this.jumsu == o.jumsu) {
				if(this.r == o.r) return this.c - o.c;
				return this.r - o.r;
			}
			return this.jumsu - o.jumsu;
		}
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int tc = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		HashMap<Character, Integer> hm;
		char[] tmp;
		
		PriorityQueue<Ship> q;
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tc;t++) {
			
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
//			if(W == 1 || H == 1) {
//				sb.append(0).append("\n");
//				continue;
//			}
			
			map = new char[H][W];
			hm = new HashMap<>();
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				hm.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
			}
			
			q = new PriorityQueue<>();
			for(int i=0;i<H;i++) {
				tmp = br.readLine().toCharArray();
				for(int j=0;j<W;j++) {
					map[i][j] = tmp[j];
					if(tmp[j] == 'E') q.offer(new Ship(i, j, 0));
				}
			}
//			System.out.println(q);
//			System.out.println(hm);
			sb.append(bfs(q,hm)).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(Queue<Ship> q,HashMap<Character, Integer> hm) {
		
		boolean[][] visit = new boolean[H][W];
//		System.out.println(q);
		Ship cur = q.peek();
		int nr,nc,tmp;
		long sum = Long.MAX_VALUE;
		
		visit[cur.r][cur.c] = true;
		
		while(!q.isEmpty()) {
			
			cur = q.poll();
			
			
			for(int i=0;i<4;i++) {
				
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(!inArea(nr,nc)) {
					return cur.jumsu;
				}
				
				if(visit[nr][nc]) continue;
				tmp = cur.jumsu + hm.get(map[nr][nc]);
				if(cur.jumsu >= sum) continue;
				
				visit[nr][nc] = true;
//				System.out.println(cur.jumsu);
//				System.out.println(hm.get(map[nr][nc]));
				q.offer(new Ship(nr, nc, tmp));
			}
		}
		return -1;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < H && nc >= 0 && nc < W;
	}
}
