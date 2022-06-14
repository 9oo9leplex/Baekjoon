package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16397 {

	static int N,T,G;
	static class Time {
		int num, t;

		public Time(int num, int t) {
			super();
			this.num = num;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Time [num=" + num + ", t=" + t + "]";
		}
	}
	
    
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	T = Integer.parseInt(st.nextToken());
    	G = Integer.parseInt(st.nextToken());
    	
    	bfs();
    }



	private static void bfs() {

		Queue<Time> q = new LinkedList<>();
		q.add(new Time(N,0));
		
		boolean[] visit = new boolean[100000];
		visit[N] = true;
		
		Time cur;
		int tmp,len;
		String num;
		char[] arr;
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			cur = q.poll();
//			System.out.println(cur);
			if(cur.t > T) {
				System.out.println("ANG");
				return;
			} else if(cur.num == G) {
				System.out.println(cur.t);
				return;
			}
			
			if(cur.num < G && !visit[cur.num+1]) {
				q.add(new Time(cur.num+1,cur.t+1));
				visit[cur.num+1] = true;
			}
			
			tmp = cur.num * 2;
			if( ( tmp <= 99999 ) && tmp != 0) {
				
				arr = Integer.toString(tmp).toCharArray();
				len = arr.length;
				
				for(int i=0;i<len;i++) {
					
					if(arr[i] != '0') {
						arr[i]--;
						tmp = 0;
						break;
					}
				}
				
				for(int i=0;i<len;i++) {
					if(arr[i] == 0) continue;
					sb.append(arr[i]);
				}
				
				tmp = Integer.parseInt(sb.toString());
				
				if(!visit[tmp]) {
					q.add(new Time(tmp,cur.t+1));
					visit[cur.t+1] = true;
				}
				sb.setLength(0);
			}
			
		}
		System.out.println("ANG");
	}
}
