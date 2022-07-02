package showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1 {

	static int N,K,map[][],numbers[],result;
	static boolean[] visit;
	static class Town implements Comparable<Town>{
		int idx,d,people;

		public Town(int idx, int d, int people) {
			super();
			this.idx = idx;
			this.d = d;
			this.people = people;
		}

		@Override
		public String toString() {
			return "Town [idx=" + idx + ", d=" + d + ", people=" + people + "]";
		}

		@Override
		public int compareTo(Town o) {
			if(this.people == o.people) {
				if(this.d == o.d) return this.idx - o.idx;
				return this.d - o.d;
			}
			return o.people - this.people;
		}
	}
	
	static PriorityQueue<Town> pq;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>();
		
		map = new int[N][2];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) map[i][0] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) map[i][1] = Integer.parseInt(st.nextToken());

		for(int i=0;i<N;i++) {
			pq.offer(new Town(i, map[i][0], map[i][1]));
		}
		
		
		
//		numbers = new int[N];
//		for(int i=0;i<N;i++) numbers[i] = i;
//		visit = new boolean[N];
//		combination(0);
		
//		do {
//			fight();
//		} while(np());
		
		
		System.out.println(result);
	}
	
	

	private static boolean np() {

		int i = N - 1;
		
		while(i > 0 && numbers[i] <= numbers[i-1]) i--;
		if(i == 0) return false;
		
		int j = N-1;
		
		while(numbers[i-1] >= numbers[j]) j--;
		
		swap(i-1,j);
		
		int k = N-1;
		
		while(i<k) swap(i++,k--);
		
		return true;
		
	}



	private static void swap(int i, int j) {
		
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}



	private static void combination(int cnt) {
		
		if(cnt == N) {

			fight();
			
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			visit[i] = true;
			numbers[cnt] = i;
			combination(cnt+1);
			visit[i] = false;
		}
		
	}

	
	private static void fight() {
		
		int life = K, sum = 0;
		
		for(int cur : numbers) {
			
			if(life - map[cur][0] < 0) break;
			
			life -= map[cur][0] * 2;
			sum += map[cur][1];
		}
		
		result = Math.max(result, sum);
	}

}
