package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2527 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x[] = new int[4];
		int y[] = new int[4];
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				x[j] = Integer.parseInt(st.nextToken());
				y[j] = Integer.parseInt(st.nextToken());
			}
			
			if((x[1] == x[2] && y[1] == y[2]) || (x[0] == x[3] && y[1] == y[2]) || 
					(x[1] == x[2] && y[0] == y[3]) || (x[0] == x[3] && y[0] == y[3])) sb.append("c").append("\n");
			else if((x[1] == x[2] && y[1] != y[2]) || (x[0] == x[3] && y[1] != y[2]) ||
					(x[1] != x[2] && y[0] == y[3]) || (x[0] != x[3] && y[0] == y[3])) sb.append("b").append("\n");
			else if(x[0] > x[3] || y[0] > y[3] || x[1] < x[2] || y[1] < y[2]) sb.append("d").append("\n");
			else sb.append("a").append("\n");
			
		}
		System.out.println(sb);
	}

	

}
