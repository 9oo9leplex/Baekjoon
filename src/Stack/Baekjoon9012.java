package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon9012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Stack<String> stack = new Stack<String>();
		
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split("");
			boolean ck = true;
			for(String s : arr) {
				if(s.equals("("))
					stack.push(s);
				else {
					if (stack.isEmpty()) {
						System.out.println("NO");
						ck = false;
						break;
					}
					else
						stack.pop();
				}
			}
			if(ck) {
				if(stack.isEmpty())
					System.out.println("YES");
				else
					System.out.println("NO");
			}
				
			stack.clear();
		}
	}

}
