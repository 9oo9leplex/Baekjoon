package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Beakjoon11279 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp==0) {
				if(queue.isEmpty()) sb.append("0").append("\n");
				else sb.append(queue.poll()).append("\n");
			}
			else queue.add(tmp);
		}
		System.out.println(sb);
	}
}
