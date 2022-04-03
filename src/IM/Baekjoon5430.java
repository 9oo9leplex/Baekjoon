package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon5430 {

static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;		
		ArrayDeque<Integer> deque;
		String arr;
		int len;
		
		for(int i=0;i<n;i++) {
			
			arr = br.readLine();
			len = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(),"[],");
			deque = new ArrayDeque<>();
			
			for(int j=0;j<len;j++)
				deque.add(Integer.parseInt(st.nextToken()));
			
			AC(arr,deque);
		}
		System.out.println(sb);
	}

	private static void AC(String arr, ArrayDeque<Integer> deque) {

		boolean isRight = true;
		
		for(char c : arr.toCharArray()) {
			if(c == 'R') {
				isRight = !isRight;
				continue;
			}
			
			if(isRight) {
				if(deque.pollFirst() == null) {
					sb.append("error").append("\n");
					return;
				}
			}
			else {
				if(deque.pollLast() == null) {
					sb.append("error").append("\n");
					return;
				}
			}
		}
		
		makeStringBuilder(deque,isRight);
	}

	private static void makeStringBuilder(ArrayDeque<Integer> deque, boolean isRight) {

		sb.append("[");
		
		if(deque.size() > 0) {
			if(isRight) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty())
					sb.append(",").append(deque.pollFirst());
			}
			else {
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty())
					sb.append(",").append(deque.pollLast());
			}
		}
		sb.append("]").append("\n");
		
	}
}
