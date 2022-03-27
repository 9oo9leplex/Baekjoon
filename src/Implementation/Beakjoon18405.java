package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Beakjoon18405 {

	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int map[][], n,s;
	static List<Virus> q;
	
	static class Virus implements Comparable<Virus>{
		int x,y,priority;

		public Virus(int x, int y, int priority) {
			super();
			this.x = x;
			this.y = y;
			this.priority = priority;
		}

		@Override
		public int compareTo(Virus o) {
			return this.priority - o.priority;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		q = new LinkedList<>();
		int tmp;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp != 0) q.add(new Virus(i,j,tmp));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		
		bfs();
		
//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		System.out.println(map[x][y]);
	}

	private static void bfs() {

		int day = 0;
		
		while(!q.isEmpty()) {
			if(s == day) break;
			
			int size = q.size();
			int cnt = 0;
			
			Collections.sort(q);
			
			while(size > cnt) {
				Virus v = q.remove(0);
				int value = v.priority;
//				System.out.println(value);
				for(int i=0;i<4;i++) {
					int nr = v.x + dr[i];
					int nc = v.y + dc[i];
					
					if(inArea(nr,nc) && map[nr][nc] == 0) {
						map[nr][nc] = value;
						q.add(new Virus(nr,nc,value));
					}
				}
				cnt++;
			}
			day++;
//			System.out.println("s: "+s+", day: "+day+ (s > day));
		}
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}
}
