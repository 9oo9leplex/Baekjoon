package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10178 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int candy, son;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			candy = Integer.parseInt(st.nextToken());
			son = Integer.parseInt(st.nextToken());
			
			sb.append("You get ").append(candy/son).append(" piece(s) and your dad gets ").append(candy%son).append(" piece(s).\n");
		}
		System.out.println(sb);
		
	}
}
