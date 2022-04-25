package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int total = 720;
	
	static class TimeTable implements Comparable<TimeTable>{
		int start,end,index;

		public TimeTable(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(TimeTable o) {
			if(this.start == o.start) return this.start - o.start;
			return this.start - o.start;
		}
		/*
		 * if(this.start > o.start) return this.start - o.start;
			else if(this.start < o.start) return o.start - this.start;
			else {
				if(this.end )
			}
		 */

		@Override
		public String toString() {
			return "TimeTable [start=" + start + ", end=" + end + "]";
		}
		
	}
	
	static List<TimeTable> time,sit;
	static boolean[] seat;
	static int n,t,p;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken())-1;
		
		time = new ArrayList<>();
		
		int start,end;
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			time.add(new TimeTable(start,end));
		}

		Collections.sort(time);
		
		seat = new boolean[n];
		sit = new ArrayList<>();
		
		while(!time.isEmpty()) {
			
			TimeTable now = time.remove(0);
			if(sit.isEmpty()) {
				seatFirst(now);
			} else {
				// 현재 시작 시간, 이전에 있던 놈들 끝나는 시간 비교해서 내보내기
				for(TimeTable tt : sit) {
					if(now.start >= tt.end) {
						sit.remove(tt);
						// 내보낸 놈들 자리 복구
						seat[tt.index] = false;
					}
				}
				if(sit.isEmpty()) {
					seatFirst(now);
					continue;
				} 
				
				// 남아 있는 자리 중에서 가장 먼 자리 탐색
				findSeat();
				// 선호하는 자리인지 비교
			}
			
		}
		
		
	}

	private static void findSeat() {

		if(sit.size() == 1) {
			int d = Math.max(sit.get(0).index,n-sit.get(0).index);
		} else {
			
		}
		
	}

	private static void seatFirst(TimeTable now) {
		seat[0] = true;
		now.index = 0;
		sit.add(now);
		
		if(p == 0) {
			// end - start
			cal(now);
		}
	}

	private static void cal(TimeTable now) {

		int sH = now.start / 100;
		int sM = now.start % 100;
		int eH = now.end / 100;
		int eM = now.end % 100;
		
		
		total -= ( eH * 60 + eM ) - (sH * 60 + sM);
		
	}
}









