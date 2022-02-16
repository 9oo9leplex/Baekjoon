package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,arr[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		sol(0,n);
	}

	private static void sol(int start, int end) {
		 
		if(start < end) {
			int mid = (start+end)/2;
			sol(start,mid);
			sol(mid+1,end);
			
			int p = start;
			int q = mid+1;
			int idx = p;
			
			while(p <= mid || q <= end) {
				if(q>end || (p<=mid && arr[p] < arr[q])) {
					
				}
			}
		}
		
		sol(start,end/2);
		sol(end/2,end);
	}

	private static void swap(int start, int end) {
		if(arr[start] > arr[end]) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
		}
	}

}
