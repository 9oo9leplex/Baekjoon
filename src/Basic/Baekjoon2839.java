package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2839 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		while(n > 0) {
			if(n%5==0) break;
			n -= 3;
			result++;
		}
		if(n < 0)
			System.out.println(-1);
		else
			System.out.println(result += n/5);
	}

}
