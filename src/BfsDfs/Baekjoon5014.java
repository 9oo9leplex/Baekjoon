package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon5014 {

	static int F,S,G,U,D,min;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 총 높이
		S = Integer.parseInt(st.nextToken()); // 현재 위치
		G = Integer.parseInt(st.nextToken()); // 가야할 층
		U = Integer.parseInt(st.nextToken()); // UP
		D = Integer.parseInt(st.nextToken()); // DOWN
		
		visit = new boolean[F+1];
		
		bfs();
	}

	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(S);

		
		int time = 0;
		while(!q.isEmpty()) {
			int cnt = 0;
			int size = q.size();
			while(size > cnt) {
				
				int now = q.poll();
//				System.out.println(now);
				if(visit[now]) {
					cnt++;
					continue;
				}
				visit[now] = true;
				if(now == G) {
					System.out.println(time);
					System.exit(0);
				}
				
//				System.out.println(inArea(now+U));
//				System.out.println(inArea(now-D));
				
				if(inArea(now+U)) q.add(now+U);
				if(inArea(now-D)) q.add(now-D);
				
				cnt++;
			}
			time++;
		}
		System.out.println("use the stairs");
	}

	private static boolean inArea(int now) {
		return now <= F && now >= 1;
	}
}
