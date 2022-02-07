package Recursion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2001 {

	static int[][] arr;
	//static int[][] range;
	static int[][] sum;
	static int max = 0 ;
	static int n = 0;
	static int m = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<n;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
				//System.out.println(Arrays.toString(arr[j]));
			}
			
			//range = new int[m][m];
			sum = new int[n][n-m+1];
			sum();
			top();
			sb.append("#").append(i+1).append(" ").append(max).append("\n");
			max = 0;
		}
		System.out.println(sb);
	}
	
	private static void top() {
		int tmp = 0;
		for(int i=0;i<sum.length-m+1;i++) {
			for(int j=0;j<sum.length-m+1;j++) {
				tmp = 0;
				for(int k=j;k<m+j;k++) {
					//System.out.println("k: "+k+", i: "+i);
					tmp += sum[k][i];
				}
				if(max < tmp) max = tmp;
			}
		}
	}

	private static void sum() {
		int tmp = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-m+1;j++) {
				tmp = 0;
				for(int k=j;k<m+j;k++) {
					tmp += arr[i][k];
				}
				sum[i][j] = tmp;
			}
			//System.out.println(Arrays.toString(sum[i]));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
