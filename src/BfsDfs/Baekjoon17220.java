package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17220 {

	static int N,M,map[][],root[],result;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int start,end;
		
		map = new int[N][N];
		root = new int[N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			start = st.nextToken().charAt(0) - 'A';
			end = st.nextToken().charAt(0) - 'A';
			
			map[start][end] = 1;
			root[end] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		
		for(int i=0;i<m;i++) {
			start = st.nextToken().charAt(0) - 'A';
			
			visit[start] = true;
		}
		
		for(int i=0;i<N;i++) {
//			System.out.println("[root,visit]: ["+root[i]+","+!visit[i]);
			if(root[i] == 0 && !visit[i]) arrest(i);
		}
		
		System.out.println(result);
		
	}

	private static void arrest(int start) {
		
		visit[start] = true;
		
		for(int i=0;i<N;i++) {
			
			if(visit[i]) continue;
			
			if(map[start][i] == 1) {
				arrest(i);
				result++;
			}
		}
		
	}
}
