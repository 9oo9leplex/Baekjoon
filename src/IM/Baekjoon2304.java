package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon2304 {

	static class stick implements Comparable<stick>{
		int len,height;

		public stick(int len, int height) {
			super();
			this.len = len;
			this.height = height;
		}

		@Override
		public int compareTo(stick o) {
			return this.len - o.len;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		stick[] list = new stick[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list[i] = new stick(len, height);
		}
		
		Arrays.sort(list);
		
		Stack<stick> stack = new Stack<>();
		for(int i=0;i<n;i++) {
			if(stack.isEmpty()) stack.push(list[i]);
			else {
				if(stack.peek().height < list[i].height) stack.push(list[i]);
			}
		}
		
		Stack<stick> stack2 = new Stack<>();
		for(int i=n-1;i>=0;i--) {
			if(stack2.isEmpty()) stack2.push(list[i]);
			else {
				if(stack2.peek().height < list[i].height) stack2.push(list[i]);
			}
		}
		//int biggest = stack2.peek().len -stack.peek().len;
		int sum = (stack2.peek().len -stack.peek().len + 1) * stack.peek().height;
		
		while(stack.size() > 1) {
			stick now = stack.pop();
			stick next = stack.peek();

			sum += ((now.len - next.len) * next.height);
		}

		while(stack2.size() > 1) {
			stick now = stack2.pop();
			stick next = stack2.peek();
			
			sum += ((next.len - now.len) * next.height);
		}
		
		System.out.println(sum);
	}

}
