package codingTest.Line.Day220924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem3 {

	static class Node {
		int r,c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	
	static Queue<Node> fires;
	static Queue<Node> ices;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[][] answer = new long[1][1];
		
		fires = new LinkedList<>();
		ices = new LinkedList<>();
		
		bfs(answer);
		int nr,nc;
		
		
		Set<Node> set = new HashSet<>();
		set.add(new Node(1, 1));
		set.add(new Node(1, 1));
		set.add(new Node(1, 1));
		System.out.println(set.size());
	}


	private static boolean inArea(int nr, int nc) {
		// TODO Auto-generated method stub
		return false;
	}


	private static void bfs(long[][] answer) {
		// TODO Auto-generated method stub
		
	}


	

}
