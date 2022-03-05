package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon2667 {

	static int n, cnt, result, map[][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean visit[][];
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = tmp[j] - '0';
				if(map[i][j] == 1)
					q.offer(new int[] {i,j});
			}
		}
		
		
		List<Integer> r = new ArrayList<>();
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			dfs(tmp[0],tmp[1]);
			if(cnt != 0) {
				r.add(cnt);
				cnt = 0;
			}
		}
		Collections.sort(r);
		StringBuilder sb = new StringBuilder();
		sb.append(r.size()).append("\n");
		for(int a : r)
			sb.append(a).append("\n");
		System.out.println(sb);
	}

	private static void dfs(int start, int end) {
//		System.out.println("start: "+start+", end: "+end+", area: "+inArea(start, end));
		if(!inArea(start,end) || map[start][end] == 0 || visit[start][end]) return;
//		System.out.println(cnt);
		cnt++;
		visit[start][end] = true;
		
		for(int i=0;i<4;i++) {
			int nr = start + dr[i];
			int nc = end + dc[i];
			
			dfs(nr,nc);
		}
	}

	private static boolean inArea(int start, int end) {
		return start >= 0 && start < n && end >= 0 && end < n;
	}

}
