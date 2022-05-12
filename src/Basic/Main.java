package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {		
	
	// 10953
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		int jumsu;
		for(int i=0;i<5;i++) {
			jumsu = Integer.parseInt(br.readLine());
			if(jumsu < 40) result += 40;
			else result += jumsu;
		}
		
		System.out.println(result/5);

	

	}
}
