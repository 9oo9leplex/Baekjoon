package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int n = Integer.parseInt(br.readLine()) - 1;
			
			int result = 0;
			for(int i=0;i<n;i++) result += Integer.parseInt(br.readLine()) - 1;
			
			System.out.println(result + Integer.parseInt(br.readLine()));
	}
}














