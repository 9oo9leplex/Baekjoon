package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1240 {

static int N,M,map[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int start,end,distance;
		
		map = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j] = 999999999;
		
			
		
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken())-1;
			end = Integer.parseInt(st.nextToken())-1;
			distance = Integer.parseInt(st.nextToken());
			
			map[start][end] = map[end][start] = distance;
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j) continue;
				for(int k=0;k<N;k++) {
					if(j == k || i == k) continue;
					if(map[j][k] > map[i][j] + map[i][k])
						map[k][j] = map[j][k] = (map[i][j] + map[i][k]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			
			sb.append(map[start][end]).append("\n");
		}
		System.out.println(sb);
	}
}
