package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon25304 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int result = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int sum = 0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			sum += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		}
		
		System.out.println(result == sum ? "Yes" : "No");
	}
}
