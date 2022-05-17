package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1916 {

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		
		for(int i=0;i<n;i++) {
//			Arrays.fill(map[i], Integer.MAX_VALUE-1);
			for(int j=0;j<n;j++) {
				if(i==j) {
					map[i][j] = 0;
					continue;
				}
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int start,end,distance;
		
		StringTokenizer st;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			distance = Integer.parseInt(st.nextToken());
			
//			map[start][end] = map[end][start] = distance;
//			if(map[start][end] == -1) map[start][end] = distance;
			if(map[start][end] > distance) map[start][end] = distance;
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		end = Integer.parseInt(st.nextToken()) - 1;
		
		long[] dist = new long[n];
		boolean[] visit = new boolean[n];
		
		for(int i=0;i<n;i++)
			dist[i] = map[start][i];
		
		visit[start] = true;
		
		int index;
		long min;
		
		for(int i=0;i<n-1;i++) {
			
			min = Integer.MAX_VALUE;
			index = 0;
			
			for(int j=0;j<n;j++) {
				if(dist[j] < min && !visit[j]) {
					min = dist[j];
					index = j;
				}
			}
			
			visit[index] = true;
			
			for(int j=0;j<n;j++) {
				if(!visit[j]) {
					if(dist[index] + map[index][j] < dist[j]) {
						dist[j] = dist[index] + map[index][j];
					}
				}
			}
		}
		
		System.out.println(dist[end]);
	}
}
