package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			StringTokenizer st;
			int result = 0,max = 0;
			
			for(int i=0;i<10;i++) {
				st = new StringTokenizer(br.readLine());
				result -= Integer.parseInt(st.nextToken());
				result += Integer.parseInt(st.nextToken());
				
				max = Math.max(max, result);
			}
			System.out.println(max);
			
			
	}
}














