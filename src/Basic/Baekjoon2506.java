package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2506 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0, sum = 0;
		
		for(int i=0;i<n;i++) {
			if(Integer.parseInt(st.nextToken()) == 1) idx++;
			else {
				for(int j=1;j<=idx;j++) {
					sum += j;
				}
				idx = 0;
			}
		}
		
		for(int j=1;j<=idx;j++) {
			sum += j;
		}
		
		System.out.println(sum);
}
}
