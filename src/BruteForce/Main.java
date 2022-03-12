package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n,r, seq[];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		seq = new int[n];
	
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(seq);
		
		do {
			System.out.println(Arrays.toString(seq));
			
		} while(np());
	}

	private static boolean np() {

		int i = n-1;
		while(i>0 && seq[i-1] >= seq[i]) i--;
		
		if(i == 0) return false;
		
		int j = n-1;
		while(seq[i-1] >= seq[j]) j--;
		
		swap(i-1,j);
		
		int k = n-1;
		while(i<k)
			swap(i++,k--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int tmp = seq[i];
		seq[i] = seq[j];
		seq[j] = tmp;
	}

}
