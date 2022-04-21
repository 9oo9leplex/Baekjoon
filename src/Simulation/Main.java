package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,K;
	static class Human{
		int day,urgent;
		
		public Human(int day, int urgent) {
			super();
			this.day = day;
			this.urgent = urgent;
		}

		@Override
		public String toString() {
			return "Human [day=" + day + ", urgent=" + urgent + "]";
		}
	}
	
	static class First implements Comparable<First>{
		int day,urgent,num;

		public First(int day, int urgent, int num) {
			super();
			this.day = day;
			this.urgent = urgent;
			this.num = num;
		}

		@Override
		public int compareTo(First o) {
			
			if(this.day > o.day) return -1;
			else if(this.day < o.day) return 1;
			else {
				if(this.urgent > o.urgent) return -1;
				else if(this.urgent < o.urgent) return 1;
				else return 1;
			}
		}

		@Override
		public String toString() {
			return "First [day=" + day + ", urgent=" + urgent + ", num=" + num + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		Queue<Human>[] line = new LinkedList[M];
		for(int i=0;i<M;i++)
			line[i] = new LinkedList<>();
		
		First result = null;
		int day,urgent;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			urgent = Integer.parseInt(st.nextToken());
			
			if(i == K) result = new First(day, urgent,K);
			
			line[i%M].add(new Human(day,urgent));
			
		}
		
		if(M > N) M = N;
		PriorityQueue<First> first = new PriorityQueue<>();
		for(int i=0;i<M;i++)
			first.offer(new First(line[i].peek().day, line[i].peek().urgent, i));
		
		
		
		int cnt = 0;
		while(true) {
			
			
			int index = first.poll().num;
			Human h = line[index].poll();
			
			if(result.day == h.day && result.urgent == h.urgent && result.num == index) break;
			cnt++;
			
			if(!line[index].isEmpty())
				first.offer(new First(line[index].peek().day,line[index].peek().urgent,index));
			
		
			
		}
		System.out.println(cnt);
	}
}









