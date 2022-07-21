package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11943 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int apple = 0, orange = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		apple = Integer.parseInt(st.nextToken());
		orange = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		orange += Integer.parseInt(st.nextToken());
		apple += Integer.parseInt(st.nextToken());
		
		System.out.println(Math.min(apple, orange));
		
		
		
	}
}
