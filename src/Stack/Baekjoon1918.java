package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");

		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case "+":
			case "-":
			case "*":
			case "/":
				while (!stack.isEmpty() && priority(arr[i]) <= priority(stack.peek())) {
					sb.append(stack.pop());
				}
				stack.push(arr[i]);
				break;

			case "(":
				stack.push(arr[i]);
				break;
			case ")":
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				sb.append(arr[i]);
				break;
			}
		}

		while (!stack.isEmpty())
			sb.append(stack.pop());

		System.out.println(sb);

	}

	public static int priority(String input) {
		if (input.equals("+") || input.equals("-"))
			return 1;
		else if (input.equals("*") || input.equals("/"))
			return 2;
		else
			return 0;
	}
}
