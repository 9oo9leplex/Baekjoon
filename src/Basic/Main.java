package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,k,map[][];
	static class Virus implements Comparable<Virus> {
		int r,c,n;

		public Virus(int r, int c, int n) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
		}

		@Override
		public String toString() {
			return "Virus [r=" + r + ", c=" + c + ", n=" + n + "]";
		}

		@Override
		public int compareTo(Virus o) {
			return this.n - o.n;
		}
		
	}
	static PriorityQueue<Virus> pq;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		pq = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) pq.add(new Virus(i, j, map[i][j]));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		bfs(t);
		
		System.out.println(map[r][c]);
	}

	private static void bfs(int t) {

		int time = 0,len,nr,nc;
		Virus cur;
		Queue<Virus> q = new LinkedList<>();
		while(!pq.isEmpty()) q.add(pq.poll());
		
		while(t > time) {
			
			len = q.size();
			for(int i=0;i<len;i++) {
				
				cur = q.poll();
				for(int j=0;j<4;j++) {
					nr = cur.r + dr[j];
					nc = cur.c + dc[j];
					
					if(inArea(nr,nc) && map[nr][nc] == 0) {
						map[nr][nc] = cur.n;
						q.add(new Virus(nr, nc, cur.n));
					}
				}
			}
//			for(int i=0;i<n;i++) System.out.println(Arrays.toString(map[i]));
//			System.out.println();
			time++;
		}
		
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}
}
