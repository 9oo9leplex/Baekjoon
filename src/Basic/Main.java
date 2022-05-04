package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int a,b;
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			sb.append("Case #").append(i).append(": ").append(a).append(" + ").append(b).append(" = ").append(a+b).append("\n");
			
		}
		System.out.println(sb);
	}
}
