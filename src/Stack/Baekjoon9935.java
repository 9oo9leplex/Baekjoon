package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon9935 {
public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();
		String com = br.readLine();
	
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<tmp.length();i++) {
			stack.push(tmp.charAt(i));
			
			if(stack.size() >= com.length()) {
				boolean ck = true;
				for(int j=0;j<com.length();j++) {
					if(stack.get(stack.size()-com.length()+j) != (com.charAt(j))) {
						ck = false;
						break;
					}
				}
				if(ck) {
					for(int j=0;j<com.length();j++)
						stack.pop();
				}
			}
		}
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb.reverse());
		
		
		
		
	}
}
