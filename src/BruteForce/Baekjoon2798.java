package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2798 {

	static int n,r,m,result, seq[],numbers[];
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = 3;
		seq = new int[n];
		numbers = new int[3];
		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		np(0);
		System.out.println(result);
	}

	private static void np(int cnt) {

		if(cnt == r) {
			int sum = 0;
			for(int i=0;i<3;i++) {
				sum += numbers[i];
			}
			
			if(sum <= m) {
				result = Math.max(result, sum);
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visit[i]) continue;
			visit[i] = true;
			numbers[cnt] = seq[i];
			np(cnt+1);
			visit[i] = false;
		}
		
	}

}
