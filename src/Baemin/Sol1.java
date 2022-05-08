package Baemin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
4	//1150
2 100
3 120
4 180
7 250
6
	
4	//10
2 1
3 2
4 3
5 4
1

2	//7300000
1 1000
1 1000
3650
 */
public class Sol1 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] salaries = new int[n][2];
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				salaries[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int days = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int[] person : salaries) {
			if(days >= person[0]) {
				if(days % person[0] == 0) result += (person[1] * (days / person[0]));
				else result += (person[1] * (days / person[0] + 1));
			}
			else {
				result += person[1];
			}
		}
		System.out.println(result);
	}
}
