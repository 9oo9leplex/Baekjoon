package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10569 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int v,e;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			sb.append(-(v-e) + 2).append("\n");
		}
		System.out.println(sb);
		
	}
}
