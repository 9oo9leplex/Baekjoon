package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16953 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int result = 1;
		while(true) {
			if(start <= n) break;
//			if(start%2 != 0 && start%10 != 1) {
//				System.out.println(-1);
//				return;
//			}
			if(start%2==0) start /= 2;
			else {
				if(start%10 != 1) break;
				start -= 1;
				start /= 10;
			}
			result++;
		}
		System.out.println(start == n ? result : -1);
		
	}

}
