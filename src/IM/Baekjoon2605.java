package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon2605 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		

		int[] arr = new int[n+1];
		for(int i=1;i<=n;i++)
			arr[i] = i;
		LinkedList<Integer> q = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			q.add(q.size()-tmp,arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			sb.append(q.poll()).append(" ");
		}
		System.out.println(sb);
		
		
	}

}
