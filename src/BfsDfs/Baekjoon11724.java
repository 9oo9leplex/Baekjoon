package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11724 {

	static int map[][],n,m,result;
	static boolean visit[];
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = map[end][start] = 1;
		}
		
		for(int i=1;i<=n;i++) {
			if(visit[i]) continue;
			dfs(i);
			result++;
		}
		System.out.println(result);
	}

	private static void dfs(int index) {
		
		if(visit[index]) return;
		visit[index] = true;
		
		for(int i=1;i<=n;i++) {
			if(map[index][i] == 1 && !visit[i]) dfs(i);
		}
		
		
		
	}

}
