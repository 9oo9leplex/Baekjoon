package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2953 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int sum, result = 0,index = 0;
		
		for(int i=1;i<=5;i++) {
			st = new StringTokenizer(br.readLine());
			sum = 0;
			for(int j=0;j<4;j++) sum += Integer.parseInt(st.nextToken());
			if(result < sum) {
				result = sum;
				index = i;
			}
		}
		System.out.println(index + " " + result);
}
}
