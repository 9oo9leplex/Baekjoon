package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260 {

	static int N,M,S,b[][];
	static StringBuilder sb = new StringBuilder();
	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		Node[] arr = new Node[N+1];
		b = new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from] = new Node(to, arr[from]);
			arr[to] = new Node(from, arr[to]);
			b[from][to] = b[to][from] = 1;
		}
		
		//bfs(b,S);
//		System.out.println();
		dfs(arr,new boolean[N+1],S);
		sb.append("\n");
		bfs(b,S);
		System.out.println(sb);
	}

	private static void dfs(Node[] arr, boolean[] bs, int start) {

		bs[start] = true;
		//System.out.print(i+" ");
		sb.append(start).append(" ");
		
		for(int i=1;i<=N;i++) {
			if(b[start][i] == 1 && !bs[i]) dfs(arr,bs,i);
		}
		
//		for(Node tmp=arr[i];tmp != null;tmp = tmp.next) {
//			if(!bs[tmp.vertex]) dfs(arr,bs,tmp.vertex);
//		}
	}

	private static void bfs(int[][] b, int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		
		queue.add(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			for(int j=1;j<=N;j++) {
				if(!visit[j] && b[current][j] != 0) {
					visit[j] = true;
					queue.add(j);
				}
			}
		}
		queue.clear();
	}

}
/*
4 5 1
1 2
1 3
1 4
2 4
3 4
*/