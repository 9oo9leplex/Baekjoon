package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10833 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int person,apple,result = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			person = Integer.parseInt(st.nextToken());
			apple = Integer.parseInt(st.nextToken());
			
			result += (apple % person);
		}
		System.out.println(result);
		
}
}
