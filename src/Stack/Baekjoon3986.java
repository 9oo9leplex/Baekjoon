package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon3986 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testcase = Integer.parseInt(st.nextToken());
		Stack<String> stack = new Stack<>();
		int result = 0;
		
		for(int i=0;i<testcase;i++) {
			String[] arr = br.readLine().split("");
			for(int j=0;j<arr.length;j++) {
				if(stack.isEmpty())
					stack.push(arr[j]);
				else {
					if(stack.peek().equals(arr[j])) {
						stack.pop();
					}
					else {
						stack.push(arr[j]);
					}
				}
			}
			if(stack.size() == 0) result++;
			stack.clear();
		}
		System.out.println(result);
	}

}
