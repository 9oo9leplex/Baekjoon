package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1927 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int n = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			
			if(input==0) System.out.println(queue.isEmpty() ? 0 : queue.poll());
			else
				queue.add(input);
			
			
			
		}
		
		
		
	}

}
