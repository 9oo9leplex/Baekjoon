package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9610 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int x,y,axis = 0, q1 = 0, q2 = 0, q3 = 0, q4 = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(x == 0 || y == 0) axis++;
			else if(x > 0 && y > 0) q1++;
			else if(x > 0 && y < 0) q4++;
			else if(x < 0 && y > 0) q2++;
			else q3++;
		}
		sb.append("Q1: ").append(q1).append("\n");
		sb.append("Q2: ").append(q2).append("\n");
		sb.append("Q3: ").append(q3).append("\n");
		sb.append("Q4: ").append(q4).append("\n");
		sb.append("AXIS: ").append(axis);
		System.out.println(sb);
	}
}
