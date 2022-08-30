package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10103 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int changyoung = 100, sangduk = 100;
		StringTokenizer st;
		int a,b;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(a > b) sangduk -= a;
			else if(b > a) changyoung -= b;
		}
		
		System.out.println(changyoung);
		System.out.println(sangduk);
	}
}
