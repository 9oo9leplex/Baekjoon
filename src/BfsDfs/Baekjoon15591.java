package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15591 {

static int N,Q,map[][],usado[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		usado = new int[N];
		
		int start,end,val,min;
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken())-1;
			end = Integer.parseInt(st.nextToken())-1;
			val = Integer.parseInt(st.nextToken());
			
			map[start][end] = map[end][start] = val;
		}
		
		for(int i=0;i<N;i++) {
			min = 1000000000;
			for(int j=0;j<N;j++) {
				if(i==j || map[i][j] == 0) continue;
				min = Math.min(min, map[i][j]);
			}
			usado[i] = min;
		}
		
		for(int i=0;i<N;i++) {
			bfs(i);
		}
		
		int k,sum;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken())-1;
		
			sum = 0;
			
			for(int j=0;j<N;j++) {
				if(k <= map[start][j]) sum++;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int start) {
		
		for(int i=0;i<N;i++) {
			if(start == i) continue;
			if(map[start][i] == 0) {
				map[start][i] = map[i][start] = Math.min(usado[start], usado[i]);
			}
		}
			
	}
}
