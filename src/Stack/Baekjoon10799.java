package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		
		Stack<String> stack = new Stack<String>();
		int result = 0;
		String ex = "";
		for(String s : arr) {
			if(s.equals("("))
				stack.push(s);
			else {
				if(!stack.isEmpty())
					stack.pop();
					if(ex.equals(")"))
						result += 1;
					else
						result += stack.size();
			}
			ex = s;
		}
		System.out.println(result);
	}
}
