package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,map[][], answer,fishes;
	static class Node implements Comparable<Node>{
		int r,c,level,cnt;

		public Node(int r, int c, int level, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", level=" + level + ", cnt=" + cnt + "]";
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.level == o.level) {
				if(this.r == o.r) return this.c - o.c;
				return this.r - o.r;
			}
			return o.level - this.level;
		}
	}
	
	static PriorityQueue<Node> pq;
	static Node shark;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cur;		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
				if(cur == 0) continue;
				else if(cur == 9) {
					shark = new Node(i,j,2,0);
					map[i][j] = 0;
				}
				else {
					pq.add(new Node(i,j,cur,0));
					fishes++;
				}
			}
		}
		
		bfs();
		
		System.out.println("result: " + answer);
	}

	private static void bfs() {

		
		
	}

	
	
}