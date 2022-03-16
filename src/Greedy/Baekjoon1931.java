package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1931 {

	static class MeetingRoom implements Comparable<MeetingRoom>{
		int start, end;

		public MeetingRoom(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(MeetingRoom o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		MeetingRoom[] list = new MeetingRoom[n];
		List<MeetingRoom> schedule = new LinkedList<>();

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[i] = new MeetingRoom(start, end);
		}
		
		schedule = getSchedule(list);
		System.out.println(schedule.size());
	}

	private static List<MeetingRoom> getSchedule(MeetingRoom[] list) {

		List<MeetingRoom> tmp = new LinkedList<>();
		Arrays.sort(list);
		tmp.add(list[0]);
		
		for(int i=1, size = list.length;i<size;i++) {
			if(tmp.get(tmp.size()-1).end <= list[i].start)
				tmp.add(list[i]);
		}
		
		return tmp;
	}

}
