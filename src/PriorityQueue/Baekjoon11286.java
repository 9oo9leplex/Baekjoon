package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11286 {
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) ->{
			int num1 = Math.abs(o1); 
			int num2 = Math.abs(o2);		
			
			System.out.println("o1: "+o1+", o2: "+o2+", num1: "+num1+", num2: "+num2);
			
			if(num1==num2) return o1 > o2 ? 1 : -1;
			return num1 - num2;
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if(queue.isEmpty()) sb.append("0").append("\n");
				else sb.append(queue.poll()).append("\n");
			}
			else {
				 queue.add(tmp);
			}
		}
		System.out.println(sb);
	}
}
