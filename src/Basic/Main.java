package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {		
	
	// 10953
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		char[] tmp = br.readLine().toCharArray();
		
		for(int i=0;i<n;i++)
			result += tmp[i] - '0';
		
		

		System.out.println(result);

	

	}
}
