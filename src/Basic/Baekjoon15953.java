package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15953 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] kakao2017 = { 5000000, 3000000, 2000000, 500000, 300000, 100000 };
		int[] kakao2018 = { 5120000, 2560000, 1280000, 640000, 320000 };
		int[] limit2017 = { 1, 3, 6, 10, 15, 21 };
		int[] limit2018 = { 1, 3, 7, 15, 31 };

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int first, second, result;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());

			if (first != 0) {
				for (int j = 0; j < 6; j++) {
					if (first <= limit2017[j]) {
						result += kakao2017[j];
						break;
					}
				}
			}

			if (second != 0) {
				for (int j = 0; j < 5; j++) {
					if (second <= limit2018[j]) {
						result += kakao2018[j];
						break;
					}
				}
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
