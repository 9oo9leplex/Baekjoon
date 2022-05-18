package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int min = Integer.MAX_VALUE;
		int tmp;
		
		for(int i=0;i<3;i++) {
			tmp = Integer.parseInt(br.readLine());
			if(min > tmp) min = tmp;
		}

		int coke = Integer.parseInt(br.readLine());
		tmp = Integer.parseInt(br.readLine());
		
		coke = Math.min(coke, tmp);
		System.out.println(min + coke - 50);
	}
}





























