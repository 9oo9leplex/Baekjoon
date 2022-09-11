package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17496 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int limit = Integer.parseInt(st.nextToken());
		int period = Integer.parseInt(st.nextToken());
		int spot = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		
		int cnt = limit / period;
		if(limit % period == 0) cnt--;
		
		System.out.println(cnt * spot * money);
	}
}
