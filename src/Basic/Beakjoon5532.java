package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon5532 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int l = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		
		l -= Math.max(a % c != 0 ? a/c+1 : a/c, b % d != 0 ? b/d+1 : b/d);
		
		System.out.println(l);
	}
}
