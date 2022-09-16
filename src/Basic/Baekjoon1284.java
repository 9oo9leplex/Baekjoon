package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1284 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int len;
		String cur;
		
		while(true) {
			cur = br.readLine();
			
			if(cur.equals("0")) break;
			len = cur.length() + 1;
			
			for(char c : cur.toCharArray()) {
				if(c == '0') len += 4;
				else if(c == '1') len += 2;
				else len += 3;
			}
			sb.append(len).append("\n");
		}
		System.out.println(sb);
	}
}
