package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9550 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int n,k,sum;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			sum = 0;
			for(int j=0;j<n;j++) {
				sum += Integer.parseInt(st.nextToken()) / k;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
