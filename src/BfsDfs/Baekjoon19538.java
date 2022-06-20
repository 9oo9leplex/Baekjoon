package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon19538 {

	static int N,M,result[],neighbor[];
	static ArrayList<Integer>[] graph;
	static Queue<Integer> q;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	int tmp;

    	graph = new ArrayList[N];
    	neighbor = new int[N];
    	result = new int[N];
    	
    	for(int i=0;i<N;i++) {
    		graph[i] = new ArrayList<>();
    		result[i] = -1;
    		st = new StringTokenizer(br.readLine());
    		while(true) {
    			tmp = Integer.parseInt(st.nextToken());
    			if(tmp == 0) break;
    			graph[i].add(tmp-1);
    		}
    	}
    	
    	M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	q = new LinkedList<>();
    	
    	for(int i=0;i<M;i++) {
    		tmp = Integer.parseInt(st.nextToken()) - 1;
    		result[tmp] = 0;
    		q.add(tmp);
    	}
    	
    	bfs();
    	
    	StringBuilder sb = new StringBuilder();
    	for(int cur : result) sb.append(cur).append(" ");
    	System.out.println(sb);

    }


	private static void bfs() {
		
		int cur;
		
		while(!q.isEmpty()) {
			
			cur = q.poll();
			for(int next : graph[cur]) {
				neighbor[next]++;
				
				if(result[next] == -1 && (graph[next].size()+1)/2 <= neighbor[next]) {
					q.add(next);
					result[next] = result[cur] + 1;
				}
			}
		}
	}
}
