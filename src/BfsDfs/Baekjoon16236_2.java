package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16236_2 {

	static int N,map[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class Shark {
		int r,c,size,cnt;

		public Shark(int r, int c, int size, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", size=" + size + ", cnt=" + cnt + "]";
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int r,c,time;

		public Fish(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.r == o.r) return this.c - o.c;
			return this.r - o.r;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", time=" + time + "]";
		}
	}
	
	static Shark shark;
	static Fish fish;
	static Queue<Integer>[][] fishMap;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		map = new int[N][N];
		fishMap = new LinkedList[N][N];
		
		int size = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				fishMap[i][j] = new LinkedList<>();
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) continue;
				else if(map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
				else {
					size++;
				}
			}
		}

		if(size == 0) {
			System.out.println(0);
			return;
		}
		
		int index,time = 0;
		
		for(int i=0;i<size;i++) {
			if(!searchFish()) {
				break;
			}
			
//			size--;
			time += fish.time;
//			System.out.println("time: "+time);
			map[fish.r][fish.c] = 0;
			shark.r = fish.r;
			shark.c = fish.c;
			if(shark.size == ++shark.cnt) {
				shark.size++;
				shark.cnt = 0;
			}
		}
		System.out.println(time);
	}

	private static boolean searchFish() {

//		System.out.println(shark);
		ArrayList<Fish> list = new ArrayList<>();
		Queue<Fish> q = new LinkedList<>();
		q.add(new Fish(shark.r,shark.c,0));
		
		boolean[][] visit = new boolean[N][N];
		visit[shark.r][shark.c] = true;
		
		Fish cur;
		int nr,nc,size;
		
		while(!q.isEmpty()) {
			
			size = q.size();
			for(int i=0;i<size;i++) {
				cur = q.poll();
//				System.out.println(cur);
				for(int j=0;j<4;j++) {
					nr = cur.r + dr[j];
					nc = cur.c + dc[j];
					
					if(inArea(nr,nc) && !visit[nr][nc]) {
						visit[nr][nc] = true;
						if(map[nr][nc] == 0) q.add(new Fish(nr,nc,cur.time+1));
						else {
							if(shark.size == map[nr][nc]) q.add(new Fish(nr,nc,cur.time+1));
							else if(shark.size > map[nr][nc]) {
								list.add(new Fish(nr,nc,cur.time+1));
							}
						}
					}
				}
			}
			
			if(list.size() != 0) {
				Collections.sort(list);
//				System.out.println(list);
				fish = list.get(0);
//				System.out.println(fish);
				return true;
			}
		}
		
		
		
		return false;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
