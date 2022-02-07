package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon15828 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int size = Integer.parseInt(br.readLine());
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == -1)
				break;
			else if (n == 0) {
				queue.poll();
				continue;
			} else {
				if (size > queue.size())
					queue.add(n);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty())
			sb.append(queue.poll()).append(" ");
		System.out.println(sb.length() == 0 ? "empty" : sb);
	}
}
