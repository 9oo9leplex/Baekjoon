package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1010 {

static int min, max, arr[][] = new int[30][30];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<n;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			min = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			sb.append(com(max,min)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int com(int n,int r) {
		
		if(arr[n][r] > 0) return arr[n][r];
		
		if(n==r || r==0) return arr[n][r] = 1;
		
		return arr[n][r] = com(n-1,r-1) + com(n-1,r);
	}

}
