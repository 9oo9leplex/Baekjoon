package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3020 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] down = new int[h+2];
		int[] up = new int[h+2];
		
		int len = n/2;
		
		for(int i=1;i<=len;i++) {
			down[Integer.parseInt(br.readLine())]++;
			up[h-Integer.parseInt(br.readLine())+1]++;
		}
		
		for(int i=1;i<=h;i++)
			down[i] += down[i-1];
		
		for(int i=h;i>0;i--)
			up[i] += up[i+1];
		
		
		int min = n;
		int cnt = 0;
		int dif;
		
		for(int i=1;i<=h;i++) {
			dif = (down[h] - down[i-1]) + (up[1] - up[i+1]);
			if(dif < min) {
				min = dif;
				cnt = 1;
			} else if(min == dif) cnt++;
		}
		System.out.println(min+" "+cnt);
	}

}
