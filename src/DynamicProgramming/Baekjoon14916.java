package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14916 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//StringBuilder sb = new StringBuilder();
		int result = 0;
		while(n>0) {
			if(n%5==0) break;
			n-=2;
			result++;
		}
		if(n%5==0)
			System.out.println(result+n/5);
		else
			System.out.println(-1);
	}

}
