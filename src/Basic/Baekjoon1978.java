package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1978 {

	static int result = 0;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int t = Integer.parseInt(st.nextToken());
			abcd(t);
		}
		
		System.out.println(result);
	}

	static void abcd(int n) {
		if(n == 1) return;
		
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) return;
		}
		result++;
	}

}
