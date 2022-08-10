package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2576 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = -1;
		int cur,min = Integer.MAX_VALUE;
		
		for(int i=0;i<7;i++) {
			cur = Integer.parseInt(br.readLine());
			if(cur % 2 != 0) {
				result += cur;
				min = Math.min(min, cur);
			}
		}
		if(result != -1) {
			System.out.println(++result);
			System.out.println(min);
		}
		else System.out.println(-1);
}
}
