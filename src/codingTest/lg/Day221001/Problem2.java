package codingTest.lg.Day221001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String compressed = "3(hi)";
//		String compressed = "2(3(hi)co)";
//		String compressed = "10(p)";
//		String compressed = "2(2(hi)2(co))x2(bo)";
		String compressed = "2(2(hi)2(co))3(x2(bo))";
		String answer = "";
		String tmp = "",num = "";
		int loop;
		boolean flag = false;
		String cur;
		
		Stack<Integer> si = new Stack<>();
		Stack<String> ss = new Stack<>();
		
		for(char c : compressed.toCharArray()) {
			
			if(c -'0' >= 0 && c - '0' <= 9) {
				num += c;
			}
			else if(c == '(') {
				si.push(Integer.parseInt(num));
				num = "";
				ss.push(tmp);
				tmp = "";
				flag = true;
			}
			else if(c == ')') {
				loop = si.pop();
				cur = ss.pop();
				System.out.println("[tmp,cur]: ["+tmp+","+cur+"]");
				if(tmp.equals("")) {
					tmp = answer;
					loop--;
				}
				
				if(!cur.equals("")) answer += cur;
				
				for(int i=0;i<loop;i++) {
					answer += tmp;
				}
				tmp = "";
				flag = false;
			}
			else {
				if(flag) tmp += c;
				else answer += c;
			}
		}
		
		
		System.out.println(answer);
	}
}
