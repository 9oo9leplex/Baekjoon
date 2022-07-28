package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int a = Integer.parseInt(br.readLine());
			char[] b = br.readLine().toCharArray();
			
			StringBuilder sb = new StringBuilder();
			int sum = 0;
			int tmp,idx = 0;
			for(int i=2;i>=0;i--) {
				tmp = a * (b[i] - '0') ;
				sb.append(tmp).append("\n");
				sum += tmp * (int)Math.pow(10, idx++);
			}
			sb.append(sum);
			System.out.println(sb);
			
	}
}














