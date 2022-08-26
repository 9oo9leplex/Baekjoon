package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9085 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int c,sum;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			c = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			sum = 0;
			
			for(int j=0;j<c;j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
}
}
