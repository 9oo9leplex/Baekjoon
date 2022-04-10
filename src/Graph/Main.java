package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11725
public class Main {

	static int N;
	static int[] parent;
	
	static void makeSet() {
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
	}
	
	static int findParent(int a) {
		if(a == parent[a]) return a;
		return findParent(parent[a]);
	}
	
	static void union(int a, int b) {
		int rootA = findParent(a);
		int rootB = findParent(b);
		
		if(rootA == rootB) return;
		if(rootA == 1) parent[b] = a;
		else parent[a] = b;
		
		return;
	}
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int a,b;
		makeSet();
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=N;i++)
			sb.append(parent[i]).append("\n");
		System.out.println(sb);
	}

}
