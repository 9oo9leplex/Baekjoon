package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		n /= 3;
		n -= 3;
		
		int result = 1;
		for(int i=0;i<n;i++)
			result += (i+2);
		System.out.println(result);
	}	

}
