package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15726 {

	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			long r1 = a * b / c;
			long r2 = a / b * c;
			System.out.println(Math.max(r1,r2));
			
	}

}
