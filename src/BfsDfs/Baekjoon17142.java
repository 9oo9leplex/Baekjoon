package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import BfsDfs.Main.Node;

public class Baekjoon17142 {

	static int N, M, size, cnt, map[][], newMap[][], day = Integer.MAX_VALUE;
	static boolean[][] visit;

	static class Node{
		int r,c,time;

		public Node(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static List<Node> virus;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int num[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
//		newMap = new int[N][N];
		num = new int[M];
		virus = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new Node(i, j, 1)); 
				else if(map[i][j] == 0) cnt++;
//				if(map[i][j] != 0) cnt++;
			}
		}
		
		if(cnt == 0) {
			System.out.println(0);
			return;
		}
		
		size = virus.size();
		com(0,0);
		System.out.println(day == Integer.MAX_VALUE ? -1 : day);

	}

	private static void com(int start, int cnt) {

		if(cnt == M) {
			day = Math.min(bfs(), day);
			return;
		}
		
		for(int i=start;i<size;i++) {
			num[cnt] = i;
			com(i+1,cnt+1);
		}
	}

	private static int bfs() {

		Queue<Node> q = new LinkedList<>();
//		Queue<Node> r = new LinkedList<>();
		// 바꿔야 할 놈들
//		Set<Node> change = new HashSet<>();
		Node node;
		visit = new boolean[N][N];
		
		for(int i=0;i<M;i++) {
			node = virus.get(num[i]);
			visit[node.r][node.c] = true;
			q.add(node);
		}
//		System.out.println(Arrays.toString(num));
		int nr,nc,d=0,len = 0, loop,time=0;
		boolean isFirst = true;
		
//		newMap = new int[N][N];
//		for(int i=0;i<N;i++) newMap[i] = map[i].clone();

//		for(int i=0;i<N;i++) System.out.println(Arrays.toString(newMap[i]));
//		System.out.println();
		
		while(!q.isEmpty()) {
			
//			loop = q.size();
//			for(int i=0;i<loop;i++) {
			node = q.poll();
//				System.out.println("[len,day]: ["+len+","+day+"]");
//				visit[node.r][node.c] = true;
				
			for(int j=0;j<4;j++) {
				nr = node.r + dr[j];
				nc = node.c + dc[j];
				
				time = node.time;
//					if(inArea(nr, nc) && !visit[nr][nc]) {// && newMap[nr][nc] != 1) {
				if(!inArea(nr, nc) || visit[nr][nc]) continue; 
//						System.out.println("[nr,nc]: ["+nr+","+nc+"]");
				if(map[nr][nc] != 1) {
					visit[nr][nc] = true;
					q.add(new Node(nr,nc,node.time+1));
					if(map[nr][nc] == 0) {
//						change.add(new Node(nr,nc,time+1));
						len++;
					}
//							len--;
				} 
				
			}
				
			
//			while(!change.isEmpty()) {
//			for(Node nn : change) {
//				len--;
//				newMap[nn.r][nn.c] = 2;
//			}
//			change.clear();
//			System.out.println("[len,day]: ["+len+","+day+"]");
			
//			for(int i=0;i<N;i++) System.out.println(Arrays.toString(newMap[i]));
//			System.out.println();
//			d++;
			if(cnt == len) {
				time++;
				break;
			}
//			if(day < d) return Integer.MAX_VALUE;
//			isFirst = false;
		}
//		if(len != 0) return Integer.MAX_VALUE;
		if(cnt != len) return Integer.MAX_VALUE;
		return time-1;//isFirst == true ? time-2 : time-1; //d-1 : d;
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
