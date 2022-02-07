package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon17413 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().toString().split("");

		Stack<String> stack1 = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		
		for (String s : arr) {
			if (s.equals("<")) {
				while(!stack1.isEmpty())
					sb.append(stack1.pop());
				tmp.append(s);
			} else if (s.equals(">")) {
				tmp.append(s);
				sb.append(tmp);
				tmp.setLength(0);
			} else if (s.equals(" ")) {
				if(tmp.length() != 0) {
					tmp.append(s);
					continue;
				}
				while (!stack1.isEmpty()) {
					sb.append(stack1.pop());
				}
				sb.append(s);
			} else {
				if (tmp.length() != 0) {
					tmp.append(s);
					continue;
				}
				stack1.push(s);
			}
		}

		while (!stack1.isEmpty())
			sb.append(stack1.pop());

		System.out.println(sb);
	}

}
