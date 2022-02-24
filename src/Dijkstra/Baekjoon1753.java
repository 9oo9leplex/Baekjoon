package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */
public class Baekjoon1753 {

	static Node[] adjList;
	static int n,k,start, distance[];
	static boolean visited[];
	static class Node{
		int to,weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		//int map[][] = new int[n][n];
		List<int[]>[] map = new ArrayList[n];
		for(int i=0;i<n;i++)
			map[i] = new ArrayList<>();
		
		boolean visit[] = new boolean[n];
		int u,v,w;
		adjList = new Node[n];
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map[u-1].add(new int[] {v-1,w});
			
			adjList[u-1] = new Node(v-1,w,adjList[u-1]);
		}
		
		distance = new int[n];
		visited = new boolean[n];
		
		int[] d = new int[n];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start-1] = 0;
		int min,current;
		for(int i=0;i<n;i++) {
			min = Integer.MAX_VALUE;
			current=0;
			for(int j=0;j<n;j++) {
				if(!visit[j] && min > d[j]) {
					min = d[j];
					current = j;
				}
			}
			if(min == Integer.MAX_VALUE) break;
			visit[current] = true;
			for(int[] now: map[current]){
				if (!visit[now[0]] && d[now[0]] > d[current] + now[1]) {
					d[now[0]] = d[current] + now[1];
				}
			}
			/*
			for(int j=0;j<n;j++) {
				if(!visit[j] && map[current][j] != 0 &&
						d[j] > d[current] + map[current][j] ) {
					d[j] = d[current] + map[current][j];
				}
			}
			*/
		}
		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<n;i++) {
//			if(d[i] == Integer.MAX_VALUE) sb.append("INF");
//			else sb.append(d[i]);
//			sb.append("\n");
//		}
		//System.out.println(sb);
		dijkstra();
		for(int i=0;i<n;i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		// 1. 최단거리 정보를 무한대로 채워넣기
		Arrays.fill(distance, Integer.MAX_VALUE);
		// 2. 최단 거리를 구할 기준 정점의 최단 거리를 0으로 설정
		distance[0] = 0;
		
		for (int i = 0; i < n; i++) {
			// 3. 방문하지 않은 정점 중 distance 값이 가장 작은 정점 정보 꺼내오기
			// 정점 번호를 담을 변수, distace의 최솟값 비교를 위한 변수
			int current = 0, min = Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			// 4. 방문체크 => 해당 정점의 최단거리 확정
			visited[current] = true;
			// 5. 현재 정점에서 이동 가능한 정점들의 거리 정보 갱신
			for(Node n = adjList[current]; n != null; n = n.next) {
				// to 정점이 방문처리 되지 않았고, 기존 to 정점의 최단거리보다 current 정점의 최단거리 + current 가중치 인 경우 갱신
				if(!visited[n.to] &&distance[n.to] > distance[current] + n.weight) {
					// to 정점까지의 최단거리 갱신
					distance[n.to] = distance[current] + n.weight;
				}
			}
			
			
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
