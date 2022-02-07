package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().toString().split("");
		Stack<String> stack = new Stack<String>();

		int mul = 1;
		boolean ck = true;
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case "(":
				stack.push(arr[i]);
				mul *= 2;
				break;
			case "[":
				stack.push(arr[i]);
				mul *= 3;
				break;
			case ")":
				if (stack.isEmpty() || !stack.peek().equals("(")) {
					ck = false;
					break;
				}
				if (arr[i - 1].equals("("))
					result += mul;

				stack.pop();
				mul /= 2;

				break;
			case "]":
				if (stack.isEmpty() || !stack.peek().equals("[")) {
					ck = false;
					break;
				}
				if (arr[i - 1].equals("["))
					result += mul;

				stack.pop();
				mul /= 3;

				break;
			}
		}
		if (!ck || !stack.isEmpty())
			System.out.println(0);
		else
			System.out.println(result);
	}
}