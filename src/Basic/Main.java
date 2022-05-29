package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long l = Integer.parseInt(st.nextToken());
		long p = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append(l/p).append("\n").append(l%p);
		
		System.out.println(sb);
		

	

	}
}
