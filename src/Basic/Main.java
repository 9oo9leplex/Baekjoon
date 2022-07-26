package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			String input = br.readLine();
			
			int len = input.length();
			if(len % 2 == 0) {
//				System.out.println(Integer.parseInt(input.substring(0)));
//				System.out.println(Integer.parseInt(input.substring(len/2)));
				System.out.println(Integer.parseInt(input.substring(0,len/2)) + Integer.parseInt(input.substring(len/2)));
				return;
			}
			else {
				int first = Integer.parseInt(input.substring(0,2));
				int second = Integer.parseInt(input.substring(1,3));
				
				if(first > 10) System.out.println(input.charAt(0) - '0' + second);
				else System.out.println(first + input.charAt(2) - '0');
				
			}
			
	}
}














