package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon11501 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			
			Stack<Integer> stack = new Stack<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				stack.add(Integer.parseInt(st.nextToken()));
			
			int top = stack.pop();
			long result = 0;
			while(!stack.isEmpty()) {
				int tmp = stack.pop();
				if(tmp > top) {
					top = tmp;
					continue;
				}
				result += (top - tmp);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
		
		
	}

}
