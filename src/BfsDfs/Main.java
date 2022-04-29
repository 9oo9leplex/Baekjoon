package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static long sum;
	static Queue<Integer> q;
	
	static int[] d = {-1,1};
//	static House[] wells;
	static Queue<House> houses;
	static class House {
		int index,dir,distance;

		public House(int index, int dir, int distance) {
			super();
			this.index = index;
			this.dir = dir;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "House [index=" + index + ", dir=" + dir + ", distance=" + distance + "]";
		}		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
//		map = new int[200000001];
//		wells = new House[N];
		q = new LinkedList<>();
		houses = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		
		int well; 
		for(int i=0;i<N;i++) {
			well = Integer.parseInt(st.nextToken());
			houses.add(new House(well, 0,0));
//			map[well] = 2;
//			wells[i] = new House(well, 0);
			q.add(well);
		}
		
		bfs();
		System.out.println(sum);
	}

	private static void bfs() {

		int len = houses.size(), cnt, next, num = 0;
		House h;
		
		for(int i=0;i<len;i++) {
			h = houses.poll();
			if(inArea(h.index-1) && !q.contains(h.index-1)) {
				houses.add(new House(h.index-1, 0,1));
				q.add(h.index-1);
				sum += 1;
				num++;
			}
			
			if(K == num) return;
			
			if(inArea(h.index+1) && !q.contains(h.index+1)) {
				houses.add(new House(h.index+1, 1,1));
				q.add(h.index+1);
				sum += 1;
				num++;
			}
			
			if(K == num) return;
		}
		
//		System.out.println(houses);
		
		while(!houses.isEmpty()) {
			
			h = houses.poll();
//				System.out.println("now: "+h+", cnt: "+num);
			next = h.index+d[h.dir];
			if(inArea(next)) {
				
				houses.add(new House(next, h.dir,h.distance+1));
			
				if(!q.contains(next)) {
					q.add(next);
					num++;
	//					System.out.println("[num,sum]: ["+num+","+sum+"]");
					sum += h.distance+1;
				}
			}
			
			if(K == num) return;
			

			
		}
		
		
		
	}

	private static boolean inArea(int next) {
		return next >= -100000000 && next < 100000001;
	}
}






















