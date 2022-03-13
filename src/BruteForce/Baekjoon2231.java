package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2231 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1;i<n;i++) {
			int number = i;
			int result = number;
			
			while(number>0) {
				result += (number%10);
				number /= 10;
			}
			
			if(n == result) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}

}
