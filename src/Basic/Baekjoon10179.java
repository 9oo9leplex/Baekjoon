package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10179 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		double cur;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			
			cur = Double.parseDouble(br.readLine()) * 0.8;
			sb.append("$").append(String.format("%.2f", cur)).append("\n");
		}
		System.out.println(sb);
		
	}
}
