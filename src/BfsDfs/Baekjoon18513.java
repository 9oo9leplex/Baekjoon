package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon18513 {

	static int N,K;
	static long sum;
	static Queue<Integer> q;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		
		int well; 
		for(int i=0;i<N;i++) {
			well = Integer.parseInt(st.nextToken());
			q.offer(well);
			set.add(well);
		}
		
		bfs();
		System.out.println(sum);
	}

	private static void bfs() {

		int index,left,right,dist = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				index = q.poll();
				left = index-1;
				right = index+1;
				
				if(!set.contains(right)) {
					q.offer(right);
					sum += dist;
					set.add(right);
					if(--K == 0) return;
				}
				
				if(!set.contains(left)) {
					q.offer(left);
					sum += dist;
					set.add(left);
					if(--K == 0) return;
				}				
			}
			dist++;
		}
	}
}
