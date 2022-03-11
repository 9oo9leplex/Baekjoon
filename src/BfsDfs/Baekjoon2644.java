package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2644 {

	static int map[][], d[], n, m, result;
	static boolean visit[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		d = new int[n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		visit = new boolean[n+1];
//		visit[start] = true;
		Queue<Integer> q= new LinkedList<>();
//		for(int i=1;i<=m;i++) {
//			if(map[start][i] == 1) q.add(i);
//		}
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(tmp == end) break;
			
			for(int i=1;i<=n;i++) {
				if(d[i] == 0 && map[tmp][i] == 1) {
					q.add(i);
					d[i] = d[tmp] + 1;
				}
			}
		}
		if(d[end] == 0) System.out.println(-1);
		else System.out.println(d[end]); 
	}

}
