package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon2660 {

	static int N,dp[][];
	static boolean[] visit;
	static Set<Integer> set;
	static class Person implements Comparable<Person>{
		int index,cnt;

		public Person(int index, int cnt) {
			super();
			this.index = index;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Person [index=" + index + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Person o) {
			if(this.cnt == o.cnt) return this.index - o.index;
			return this.cnt - o.cnt;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][N+1];
		
		StringTokenizer st;
		
		int start,end;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			if(start == -1 && end == -1) break;
			
			dp[start][end] = dp[end][start] = 1;
		}
		
		List<Person> list = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			visit = new boolean[N+1];
			set = new HashSet<>();
			list.add(new Person(i, dfs(i)));
		}
		
		Collections.sort(list);
		
		int min = list.get(0).cnt;
		int cnt = 0;
		StringBuilder index = new StringBuilder();
		
		for(Person p : list) {
			if(min < p.cnt) break;
			index.append(p.index).append(" ");
			cnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(cnt);
		System.out.println(sb);
		System.out.println(index);
	}

	private static int dfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		int tmp,len,cnt = 1;
		
		while(!q.isEmpty()) {
			
			len = q.size();
			for(int i=0;i<len;i++) {
				tmp = q.poll();
				visit[tmp] = true;
				
				for(int j=1;j<=N;j++) {
					if(tmp == j) continue;
					if(dp[tmp][j] == 1 && !visit[j]) {
						q.add(j);
						set.add(j);
					}
				}
			}
			
			
			if(set.size() == N-1) break;
			
			cnt++;
		}
		
		return cnt;
	}
}
