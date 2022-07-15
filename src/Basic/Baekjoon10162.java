package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10162 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int result = Integer.parseInt(br.readLine());
		
		if(result % 10 != 0) {
			System.out.println(-1);
			return;
		}
		int tmp;
		StringBuilder sb = new StringBuilder();
		
		if(result >= 300) {
			tmp = result / 300;
			sb.append(tmp);
			result -= 300 * tmp;
		} else sb.append(0);
		sb.append(" ");
		
		if(result >= 60) {
			tmp = result / 60;
			sb.append(tmp);
			result -= 60 * tmp;
		} else sb.append(0);
		sb.append(" ");
		sb.append(result / 10);
		
		System.out.println(sb);
		
	}
}
