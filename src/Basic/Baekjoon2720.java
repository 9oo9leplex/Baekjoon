package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2720 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int cur;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			cur = Integer.parseInt(br.readLine());
			
			sb.append(cur/25).append(" ");
			cur %= 25;
			sb.append(cur/10).append(" ");
			cur %= 10;
			sb.append(cur/5).append(" ");
			cur %= 5;
			sb.append(cur/1).append(" ").append("\n");
		}
		System.out.println(sb);
	}
}
