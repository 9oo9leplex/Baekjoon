package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2420 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long result = Math.abs(Long.parseLong(st.nextToken()) - Long.parseLong(st.nextToken()));
		
		System.out.println(result);
		
		
	}
}
