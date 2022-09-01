package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9325 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int sum,a,op,price;
		
		for(int i=0;i<n;i++) {
			sum = Integer.parseInt(br.readLine());
			a = Integer.parseInt(br.readLine());
			
			for(int j=0;j<a;j++) {
				st = new StringTokenizer(br.readLine());
				op = Integer.parseInt(st.nextToken());
				price = Integer.parseInt(st.nextToken());
				
				sum += (op * price);
			}
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
