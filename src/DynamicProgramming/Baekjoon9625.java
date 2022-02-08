package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9625 {

static int arr[][];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// StringTokenizer st = new StringTokenizer(br.readLine());
		// StringBuilder sb = new StringBuilder();
		arr = new int[n+1][2];
		arr[0][0] = arr[1][1] = 1;
		arr[0][1] = arr[0][1] = 0;
		p(n);
		System.out.println(arr[n][0] + " " + arr[n][1]);
	}
	
	static void p(int n) {
		
		if(n < 2) return;
		p(n-1);
		arr[n][0] = arr[n-1][0] + arr[n-2][0];
		arr[n][1] = arr[n-1][1] + arr[n-2][1];
	}

}
