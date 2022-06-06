package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 19238
public class Main {

	static int N,M,K,map[][];
	static class Taxi implements Comparable<Taxi>{
		
		int r,c,time;

		public Taxi(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Taxi o) {
			if(this.time == o.time) {
				if(this.r == o.r) return this.c - o.c;
				return this.r - o.r;
			}
			return this.time - o.time;
		}
	}
	
	static class Passenger {
		int r,c,dr,dc,index;

		public Passenger(int r, int c, int dr, int dc, int index) {
			super();
			this.r = r;
			this.c = c;
			this.dr = dr;
			this.dc = dc;
			this.index = index;
		}
	}
	
	static Queue<Integer>[][] passengerMap;
	static Passenger[] passengers;
	static Taxi taxi;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		passengerMap = new LinkedList[N][N];
				
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				passengerMap[i][j] = new LinkedList<>();
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) map[i][j] = -1;
			}
		}
		
		passengers = new Passenger[M];
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int dr,dc;
		
		taxi = new Taxi(r, c, 0);
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			dr = Integer.parseInt(st.nextToken()) - 1;
			dc = Integer.parseInt(st.nextToken()) - 1;
			passengerMap[r][c].add(i);
			passengers[i-1] = new Passenger(r, c, dr, dc, i); 
		}
		
		int startTime,index;
		
		for(int i=0;i<M;i++) {
			
			if(!searchPassenger()) {
				System.out.println(-1);
				return;
			}
			
			startTime = taxi.time;
			index = passengerMap[taxi.r][taxi.c].poll() - 1;
			
			if(!goDest(passengers[index].dr,passengers[index].dc)) {
				System.out.println(-1);
				return;
			}
			
			K -= taxi.time;
			if(K < 0) {
				System.out.println(-1);
				return;
			}
			
			K += ( 2 * (taxi.time - startTime));
			taxi.time = 0;
		}
		System.out.println(K);
	}

	private static boolean goDest(int r, int c) {

		Queue<Taxi> q = new LinkedList<>();
		q.offer(taxi);
		boolean[][] visit = new boolean[N][N];
		visit[taxi.r][taxi.c] = true;
		
		Taxi cur;
		int nr,nc;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(cur.r == r && cur.c == c) {
				taxi = cur;
				return true;
			}
			
			for(int i=0;i<4;i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(inArea(nr, nc) && !visit[nr][nc] && map[nr][nc] != -1) {
					visit[nr][nc] = true;
					q.add(new Taxi(nr,nc,cur.time+1));
				}
			}
		}
		
		return false;
	}

	private static boolean searchPassenger() {

		ArrayList<Taxi> list = new ArrayList<>();
		Queue<Taxi> q = new LinkedList<>();
		q.add(taxi);
		
		boolean[][] visit = new boolean[N][N];
		visit[taxi.r][taxi.c] = true;
		
		Taxi cur;
		int nr,nc;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(!list.isEmpty() && list.get(0).time < cur.time) continue;
			if(!passengerMap[cur.r][cur.c].isEmpty()) {
				list.add(cur);
				continue;
			}
			
			for(int i=0;i<4;i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				
				if(inArea(nr,nc) && !visit[nr][nc] && map[nr][nc] != -1) {
					visit[nr][nc] = true;
					q.offer(new Taxi(nr,nc,cur.time+1));
				}
			}
		}
		
		if(list.isEmpty()) return false;
		
		Collections.sort(list);
		taxi = list.get(0);
		return true;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}


















