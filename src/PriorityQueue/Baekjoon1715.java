package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1715 {
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int re = 0;
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			queue.add(tmp);
		}
		
		while(queue.size() > 1) {
			int a = queue.poll();
			int b = queue.poll();
			queue.add(a+b);
			re += (a+b);
		}
			
		System.out.println(re);
	}
}
