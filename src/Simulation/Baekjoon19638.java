package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon19638 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<n;i++)
			pq.add(Integer.parseInt(br.readLine()));
		
		boolean flag = true;
		int tmp, cnt = 0;
		while(true) {
//			System.out.println("t: "+t+", cnt: "+cnt);
			tmp = pq.peek();
//			System.out.println("tmp: "+tmp);
			if(tmp < h) break;
			if(t == cnt || tmp == 1) {
				flag = false;
				break;
			}
			
			pq.add(pq.poll()/2);
//			System.out.println(pq);
			cnt++;
		}
		
		if(flag) {
			System.out.println("YES");
			System.out.println(cnt);
		} else {
			System.out.println("NO");
			System.out.println(pq.poll());
		}
		
	}
}
