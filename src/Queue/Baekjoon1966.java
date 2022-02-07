package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon1966 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			LinkedList<int[]> queue = new LinkedList<int[]>();

			st = new StringTokenizer(br.readLine());
			int result = 0;

			for (int j = 0; j < n; j++)
				queue.add(new int[] { j, Integer.parseInt(st.nextToken()) });

			while (!queue.isEmpty()) {
				int[] tmp = queue.poll();
				boolean ck = true;
				for (int j = 0; j < queue.size(); j++) {
					if (tmp[1] < queue.get(j)[1]) {
						queue.add(tmp);
						ck = false;
						break;
					}
				}

				if (ck) {
					result++;
					if (tmp[0] == index) {
						System.out.println(result);
						break;
					}
				}
			}
		}
	}
}
