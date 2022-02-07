package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2164 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int input = Integer.parseInt(st.nextToken());
		//st = new StringTokenizer(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<input;i++)
			queue.add(i+1);
		
		while(queue.size() > 1) {
			queue.remove();
			int tmp = queue.poll();
			queue.add(tmp);
		}
		
		System.out.println(queue.poll());
	}

}
