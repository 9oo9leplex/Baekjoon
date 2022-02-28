package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon2116 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n+1][7];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=6;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		HashMap<Integer, int[]> sum[] = new HashMap[n+1];
		for(int i=1;i<=n;i++) {
			sum[i] = new HashMap<Integer, int[]>();
			sum[i].put(arr[i][1], new int[] {arr[i][6],arr[i][1]+arr[i][6]});
			sum[i].put(arr[i][2], new int[] {arr[i][4],arr[i][2]+arr[i][4]});
			sum[i].put(arr[i][3], new int[] {arr[i][5],arr[i][3]+arr[i][5]});
			sum[i].put(arr[i][4], new int[] {arr[i][2],arr[i][2]+arr[i][4]});
			sum[i].put(arr[i][5], new int[] {arr[i][3],arr[i][3]+arr[i][5]});
			sum[i].put(arr[i][6], new int[] {arr[i][1],arr[i][1]+arr[i][6]});
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			for (int j = 1; j <= 6; j++) {
				int[] a = sum[i].get(arr[i][j]);
				int tmp = a[1];
				int key = a[0];
				System.out.println("층: "+i+", 아랫면: "+arr[i][j]+", 윗면: "+key+", 값: ");
				for(int k=2;k<=n;k++) {
					int[] b = sum[k].get(key);
					System.out.println("층: "+k+", 아랫면: "+key+", 윗면: "+b[0]);
					tmp += b[1];
					key = b[0];
				}
//				System.out.println(tmp);
				max = Math.max(max, tmp);
			}
		}
		System.out.println(max);
	}

}
