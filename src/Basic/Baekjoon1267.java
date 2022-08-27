package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1267 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = 0,m = 0,cur;
		for(int i=0;i<n;i++) {
			cur = Integer.parseInt(st.nextToken());
			
			y += 10 * (cur / 30);
			m += 15 * (cur / 60);
			
			if(cur % 29 != 0) y += 10;
			if(cur % 59 != 0) m += 15;
		}
		
		if(y > m) System.out.println("M "+ m);
		else if(y < m) System.out.println("Y " + y);
		else System.out.println("Y M "+m);
}
}
