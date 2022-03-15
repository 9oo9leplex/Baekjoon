package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1024 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		int start = 0;
		while (true) {
			int tmp = n - func(r - 1);
			if (tmp < 0 || r > 100) {
				System.out.println(-1);
				return;
			}

			if (tmp % r == 0) {
				start = tmp / r;
				break;
			} else {
				r++;
			}
		}
		for(int i=start;i<start+r;i++) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	private static int func(int input) {

		if (input == 0)
			return 0;
		else if (input == 1)
			return 1;

		int sum = input * (input + 1) / 2;
		return sum;
	}
}
