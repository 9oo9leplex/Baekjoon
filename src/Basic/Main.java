package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,k,map[][];
	static class Virus implements Comparable<Virus> {
		int r,c,n;

		public Virus(int r, int c, int n) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
		}

		@Override
		public String toString() {
			return "Virus [r=" + r + ", c=" + c + ", n=" + n + "]";
		}

		@Override
		public int compareTo(Virus o) {
			return this.n - o.n;
		}
		
	}
	static PriorityQueue<Virus> pq;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
	}
}
