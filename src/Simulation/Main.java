package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int tmp = n;
		int cnt = 0;
		while(tmp != 0) {
			tmp /= 2;
			cnt++;
		}

		if(k == 1) {
			System.out.println((int)Math.pow(2, cnt) - n);
			return;
		}
		
		int arr[] = new int[k];
		for(int i=0;i<k;i++)
			arr[i] = cnt - i - 1;
		
//		arr[k-2] = arr[k-1] = cnt-k+1;
		
		int sum = 0;
		for(int a : arr)
			sum += Math.pow(2,a);
//		System.out.println("sum: "+sum+", n: "+n);
		if(sum >= n) System.out.println(sum - n);
		else System.out.println((int)(sum + Math.pow(2,arr[k-1]) - n));

	}

}
