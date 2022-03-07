package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {

	static int map[],n,sister,result;
	static boolean visit[];
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		sister = Integer.parseInt(st.nextToken());
		
		map = new int[100001];
		
		System.out.println(bfs());
	}

	private static int bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		map[n] = 1;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(tmp == sister) return map[tmp]-1;
			if(tmp-1>=0 && map[tmp-1]==0) {
				map[tmp-1] = map[tmp]+1;
				q.add(tmp-1);
			}
			if(tmp+1 <= 100000 && map[tmp+1]==0) {
				map[tmp+1] = map[tmp]+1;
				q.add(tmp+1);
			}
			if(2*tmp <= 100000 && map[tmp*2]==0) {
				map[tmp*2] = map[tmp]+1;
				q.add(tmp*2);
			}
		}
		return -1;
	}
}
