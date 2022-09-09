package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4504 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int cur;
		
		while(true) {
			cur = Integer.parseInt(br.readLine());
			if(cur == 0) break;
			
			sb.append(cur).append(cur % n == 0 ? " is a multiple of " :" is NOT a multiple of ").append(n).append(".\n");
		}
		
		
		System.out.println(sb);
		
	}
}
