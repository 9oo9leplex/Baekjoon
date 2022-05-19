package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1068 {

	static int N,delete,cnt, parent[];
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int now,root = 0;
		for(int i=0;i<N;i++) {
			now = Integer.parseInt(st.nextToken());
			parent[i] = now;
			if(parent[i] == -1) root = i;
		}
		
		delete = Integer.parseInt(br.readLine());
		
		deleteNode(delete);
		
		visit = new boolean[N];
		countleafNode(root);
		System.out.println(cnt);
	}

	private static void countleafNode(int root) {

		boolean isLeaf = true;
		visit[root] = true;
		
		if(parent[root] != -2) {
			for(int i=0;i<N;i++) {
				if(parent[i] == root && !visit[i]) {
					countleafNode(i);
					isLeaf = false;
				}
			}
			if(isLeaf) cnt++;
		}
		
	}

	private static void deleteNode(int d) {

		parent[d] = -2;
		for(int i=0;i<N;i++) {
			if(parent[i] == d) {
				deleteNode(i);
			}
		}
		
	}
}
