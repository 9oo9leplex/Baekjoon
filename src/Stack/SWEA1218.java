package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<10;i++) {
			int len = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			boolean ck = false;
			Stack<Character> stack = new Stack<>();
			
			for(int j=0;j<len;j++) {
				switch(arr[j]) {
				case '}':
					if(stack.isEmpty() || stack.peek() != '{') {
						sb.append("#").append(i+1).append(" ").append(0).append("\n");
						ck = true;
					}
					else
						stack.pop();
					break;
				case ']':
					if(stack.isEmpty() || stack.peek() != '[') {
						sb.append("#").append(i+1).append(" ").append(0).append("\n");
						ck = true;
					}
					else
						stack.pop();					
					break;
				case ')':
					if(stack.isEmpty() || stack.peek() != '(') {
						sb.append("#").append(i+1).append(" ").append(0).append("\n");
						ck = true;
					}
					else
						stack.pop();
					break;
				case '>':
					if(stack.isEmpty() || stack.peek() != '<') {
						sb.append("#").append(i+1).append(" ").append(0).append("\n");
						ck = true;
					}
					else
						stack.pop();
					break;
				default:
					stack.push(arr[j]);
					break;
				}
				if(ck)
					break;
			}
			if(stack.isEmpty() && !ck) sb.append("#").append(i+1).append(" ").append(1).append("\n");
		}
		System.out.println(sb);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
