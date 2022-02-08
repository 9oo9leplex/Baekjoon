package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2577 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int re = a*b*c;
		int[] arr = new int[10];
		
		while(re>0) {
			arr[re%10]++;
			re /= 10;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

}
