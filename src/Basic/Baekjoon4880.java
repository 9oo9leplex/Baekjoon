package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4880 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int a,b,c;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if( a == 0 && b == 0 && c == 0) break;
			
			if(c - b == b - a) sb.append("AP ").append(c + (c-b));
			else sb.append("GP ").append(c * (c/b));
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
