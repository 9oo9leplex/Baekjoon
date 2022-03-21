package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon11497 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n,arr[],index,result;
		PriorityQueue<Integer> q;
		
		for(int i=0;i<t;i++) {
			n = Integer.parseInt(br.readLine());
			q = new PriorityQueue<>();
			
			arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				q.add(Integer.parseInt(st.nextToken()));
//			System.out.println(q);
			index = 0;
			while(q.size() > 1) {
				arr[index] = q.poll();
				arr[n-index-1] = q.poll();
				index++;
			}
			if(!q.isEmpty())
				arr[n/2] = q.poll();
			
//			System.out.println(Arrays.toString(arr));
			result = Math.abs(arr[0] - arr[n-1]);
			for(int j=0;j<n-1;j++) {
				result = Math.max(result, Math.abs(arr[j] - arr[j+1]));
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
