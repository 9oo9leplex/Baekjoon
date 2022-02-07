package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		Stack<String> stack = new Stack<String>();
		Stack<String> stack2 = new Stack<String>();
		
		for (int t = 0; t < n; t++) {
			String[] arr = br.readLine().toString().split("");
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].equals(">")) {
					if(!stack.isEmpty())
						stack2.push(stack.pop());
				} else if(arr[i].equals("<")) {
					if(!stack2.isEmpty())
						stack.push(stack2.pop());
				} else if(arr[i].equals("-")) {
					if(!stack2.isEmpty())
						stack2.pop();
				} else
					stack2.push(arr[i]);
			}
			while(!stack.isEmpty())
				stack2.push(stack.pop());
			
			while(!stack2.isEmpty())
				sb.append(stack2.pop());
			
			System.out.println(sb.reverse());
		}

	}

}
