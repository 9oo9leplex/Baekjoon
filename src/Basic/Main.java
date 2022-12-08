package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int parent[];
	
	static void makeSet(int n) {
		parent = new int[n];
		for(int i=0;i<n;i++) parent[i] = i;
	}
	
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a,int b) {
		int c = find(a);
		int d = find(b);
		if(c == d) return false;
		
		parent[d] = c;
		return true;
	}
	
	static class Node implements Comparable<Node>{
		int start,end,weight;
		
		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		StringTokenizer st;
		int s,e,w;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()) - 1;
			e = Integer.parseInt(st.nextToken()) - 1;
			w = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(s,e,w));
		}
		
		Node cur;
		int answer = 0;
		makeSet(n);
		
		while(!pq.isEmpty()){
			cur = pq.poll();
			
			if(find(cur.start) != find(cur.end)) {
				answer += cur.weight;
				union(cur.start,cur.end);
			}
			
		}
		System.out.println(answer);
	}
}