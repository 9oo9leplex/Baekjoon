package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3034 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int cur, max = (int)(Math.pow(w, 2) + Math.pow(h,2));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			cur = Integer.parseInt(br.readLine());
			sb.append((int)Math.pow(cur, 2) <= max ? "DA" : "NE").append("\n");
			
		}
		System.out.println(sb);
		
	}
}
