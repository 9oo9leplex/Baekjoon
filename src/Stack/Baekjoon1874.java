package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon1874 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			
			if(tmp > max) {
				for(int j=max;j<tmp;j++) {
					stack.push(j+1);
					sb.append("+").append("\n");
				}
					
				max = tmp;
				stack.pop();
				sb.append("-").append("\n");
			}
			else {
				if(stack.peek() != tmp) {
					sb.setLength(0);
					sb.append("NO");
					break;
				}
				else {
					stack.pop();
					sb.append("-").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
