package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon13265 {

	static int n,m,map[][];
	static int[] color;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int start,end;
		
		for(int t=0;t<tc;t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			color = new int[n];
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken())-1;
				end = Integer.parseInt(st.nextToken())-1;
				
				map[start][end] = map[end][start] = 1;
			}
			
			flag = false;
			bfs(0);
			// 그래프가 나뉘어있다면 나머지 탐색
			for(int i=0;i<n;i++)
				if(color[i] == 0) bfs(i);
			
			if(flag) sb.append("impossible").append("\n");
			else sb.append("possible").append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		// 초기값
		q.add(start);
		color[start] = 1;
		
		while(!q.isEmpty()) {
		
			int now = q.poll();
			
			for(int i=0;i<n;i++) {
				// 자기 자신과 같다면 통과
				if(now == i) continue;
				// 현재 - 다음 위치가 연결돼있다면
				if(map[now][i] == 1) {
					// 색을 아직 안칠했다면
					if(color[i] == 0) {
						q.add(i);
						// 현재 색과 반대 색 칠함
						color[i] = color[now] == 2 ? 1:2;
					}
					// 색을 이미 칠한 곳이라면
					else {
						// 현재 색과 비교
						if(color[now] == color[i]) {
							flag = true;
							return;
						}
					}
				}
			}
		}
	}

}
