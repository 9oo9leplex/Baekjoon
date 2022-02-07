package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2161 {
public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList();
		Queue<Integer> queue2 = new LinkedList();
		for(int i=1;i<=n;i++)
			queue.add(i);
		
		while(queue.size() > 1) {
			queue2.add(queue.poll());
			queue.add(queue.poll());
		}
		queue2.add(queue.poll());
		
		while(!queue2.isEmpty())
			System.out.print(queue2.poll()+" ");
		
	}
}
