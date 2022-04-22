package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon19640 {

static int N,M,K;
	
	static class Human implements Comparable<Human>{
		int day,urgent,index;
		
		public Human(int day, int urgent, int index) {
			super();
			this.day = day;
			this.urgent = urgent;
			this.index = index;
		}

		@Override
		public int compareTo(Human o) {
			
			if(this.day == o.day) {
				if(this.urgent == o.urgent) return this.index - o.index;
				return o.urgent - this.urgent;
			}
			return o.day - this.day;
		}

		@Override
		public String toString() {
			return "Human [day=" + day + ", urgent=" + urgent + ", index=" + index + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(M > N) M = N;
		
		Queue<Human>[] line = new LinkedList[M];
		for(int i=0;i<M;i++)
			line[i] = new LinkedList<>();
		
		Human result = null;
		int day,urgent;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			urgent = Integer.parseInt(st.nextToken());
			
			if(K == i) result = new Human(day, urgent, i);
			
			line[i%M].add(new Human(day,urgent,i));
		}
		
		PriorityQueue<Human> first = new PriorityQueue<>();
		for(int i=0;i<M;i++)
			first.offer(new Human(line[i].peek().day, line[i].peek().urgent, i));
		
		
		
		int cnt = 0;
		while(true) {
			
			
			int index = first.poll().index;
			Human h = line[index].poll();
			
			if(result.day == h.day && result.urgent == h.urgent && result.index == h.index) break;
			cnt++;
			
			if(!line[index].isEmpty())
				first.offer(new Human(line[index].peek().day,line[index].peek().urgent,index));
	
		}
		System.out.println(cnt);
	}
}
