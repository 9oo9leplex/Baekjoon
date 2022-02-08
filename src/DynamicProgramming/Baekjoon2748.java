package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2748 {

static long[] a = new long[91];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// StringTokenizer st = new StringTokenizer(br.readLine());
		// StringBuilder sb = new StringBuilder();
		a[0] = 0;
		a[1] = a[2] = 1;

		p(n);
		System.out.println(a[n]);
	}

	static void p(int n) {

		if (n <= 2)	return;
		p(n - 1);
		a[n] = a[n - 1] + a[n - 2];
	}

}
