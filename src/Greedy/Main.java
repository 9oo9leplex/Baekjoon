package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		n = 1000 - n;
		int result = 0;
		int tmp;
		int w[] = {500,100,50,10,5,1};
		
		
		for(int i=0;i<6;i++) {
			if(n < w[i]) continue;
			
			tmp = n / w[i];
			result += tmp;
			n -= (tmp*w[i]);
		}
		
		System.out.println(result);
		
	}

}
