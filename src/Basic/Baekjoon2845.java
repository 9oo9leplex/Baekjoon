package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2845 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int l = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int lp = l * p;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(Integer.parseInt(st.nextToken()) - lp).append(" ");
		}

		System.out.println(sb);
	}
}
