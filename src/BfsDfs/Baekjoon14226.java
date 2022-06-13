package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon14226 {

	static int N;
	static class Emozy {
		int len, clip, cnt;

		public Emozy(int len, int clip, int cnt) {
			super();
			this.len = len;
			this.clip = clip;
			this.cnt = cnt;
		}
	}
    
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	N = Integer.parseInt(br.readLine());
    	
    	bfs();
    }

	private static void bfs() {

		Queue<Emozy> q = new LinkedList<>();
		q.add(new Emozy(1,0,0));
		
		boolean[][] visit = new boolean[1001][1001];
		visit[1][0] = true;
		
		Emozy e;
		
		while(!q.isEmpty()) {
			e = q.poll();
			
			if(e.len == N) {
				System.out.println(e.cnt);
				return;
			}
			
			// 클립 보드 복사
			if(e.len > 0 && !visit[e.len][e.len]) {
				q.add(new Emozy(e.len, e.len, e.cnt+1));
				visit[e.len][e.len] = true;
			}
			// 붙여 넣기
			if(e.clip > 0 && (e.len + e.clip) <= 1000 && !visit[e.len + e.clip][e.clip]) {
				q.add(new Emozy(e.len+e.clip, e.clip, e.cnt+1));
				visit[e.len+e.clip][e.clip] = true;
			}
			// 삭제
			if(e.len > 1 && !visit[e.len-1][e.clip]) {
				visit[e.len-1][e.clip] = true;
				q.add(new Emozy(e.len-1, e.clip, e.cnt+1));
			}
			
		}
	}
}
