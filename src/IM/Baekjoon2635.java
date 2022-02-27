package IM;

import java.util.Scanner;

public class Baekjoon2635 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		StringBuilder sb = new StringBuilder();
		String x = "";
		
		for(int i=1;i<=n;i++) {
			int cnt = 2;
			int tmp = n;
			int a = i;
			int b;
			sb.append(tmp).append(" ").append(i).append(" ");
			while(true) {
				b = tmp - a;
				if(b < 0) break;
				sb.append(b).append(" ");
				tmp -= b;
				a = b;
				cnt++;
			}
			if(result < cnt) {
				x = sb.toString();
				result = cnt;
			}
			sb.setLength(0);
		}
		System.out.println(result);
		System.out.println(x);
	}

}
