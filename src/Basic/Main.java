package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			StringTokenizer st;
			
			int in,out,sum = 0,max = 0;
			
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				
				out = Integer.parseInt(st.nextToken());
				in = Integer.parseInt(st.nextToken());
				
				sum -= out;
				sum += in;
				max = Math.max(max, sum);
				
			}
			System.out.println(max);
			
	}
}














