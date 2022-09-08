package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3058 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cur,min,sum;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			sum = 0;
			
			for(int j=0;j<7;j++) {
				cur = Integer.parseInt(st.nextToken());
				if(cur % 2 == 1) continue;
				sum += cur;
				min = Math.min(cur, min);
			}
			sb.append(sum).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
		
	}
}
