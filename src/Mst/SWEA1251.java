package Mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1251 {

	static class Edge implements Comparable<Edge>{
		int x,y;
		double d;
		
		public Edge(int x, int y, double d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.d - o.d > 0) return 1;
			else if(this.d - o.d < 0) return -1;
			return 0;
		}
	}
	
	static int n,parent[];
	
	static void makeSet() {
		parent = new int[n+1];
		for(int i=1;i<=n;i++)
			parent[i] = i;
	}
	
	static int findSet(int a) {
		if(a == parent[a]) return a;
		return parent[a] = findSet(parent[a]);
	}
	
	static boolean union(int a,int b) {
		int roota = findSet(a);
		int rootb = findSet(b);
		if(roota == rootb) return false;
		
		parent[rootb] = roota;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine());
		
			int[] x = new int[n];
			int[] y = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
				x[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
				y[i] = Integer.parseInt(st.nextToken());
			
			double e = Double.parseDouble(br.readLine());
			
			int size = (n*n-n)/2;
			Edge[] list = new Edge[size];
			int cnt=0;
			for(int i=0;i<size;i++) {
				double d = 0.0;
				for(int j=i+1;j<n;j++) {
					d = (Math.pow((x[i] - x[j]),2) + Math.pow((y[i] - y[j]), 2)) * e;
					list[cnt++] = new Edge(i, j, d);
				}
			}
			
			makeSet();
			Arrays.sort(list);
			
			double result = 0.0;
			cnt = 0;
			for(Edge edge : list) {
				if(union(edge.x,edge.y)) {
					result += edge.d;
					if(++cnt == n-1) break;
				}
			}
			sb.append("#").append(t).append(" ").append(String.format("%.0f", result)).append("\n");
		}
		System.out.println(sb);
	}

}
