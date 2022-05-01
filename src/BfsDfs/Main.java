package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N,Q,map[][],usado[],value[][];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		value = new int[N][N];
		usado = new int[N];
		
		int start,end,val,min;
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken())-1;
			end = Integer.parseInt(st.nextToken())-1;
			val = Integer.parseInt(st.nextToken());
			
			map[start][end] = map[end][start] = val;
		}
		
//		List<Tube> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			min = 1000000000;
			for(int j=0;j<N;j++) {
				if(i==j || map[i][j] == 0) continue;
				min = Math.min(min, map[i][j]);
			}
			usado[i] = min;
		}
		
		for(int i=0;i<N;i++) {
			bfs(i);
		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				if(map[i][j] == 0) continue;
//				value[i][map[i][j]-1]++; 
//			}
//		}
		
//		for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//		System.out.println();
		
//		for(int i=0;i<N;i++) {
//			for(int j=N-2;j>=0;j--) {
//				value[i][j] += value[i][j+1];
//			}
//		}
			
//		for(int i=0;i<N;i++) System.out.println(Arrays.toString(value[i]));
//		System.out.println();
		
		int k,sum;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken())-1;
		
			sum = 0;
			
			for(int j=0;j<N;j++) {
//				if(value[start][j] != 0) {
//					sb.append(value[start][j]).append("\n");
//					sum = value[start][j];
//					break;
//				}
				
//				System.out.println("[k,map[start][j]: ["+k+","+map[start][j]+"]");
//				System.out.println(k <= map[start][j]);
//				System.out.println(value[start][j] == 0);
				if(k <= map[start][j]) sum++;
//				if(map[start][j] != 0 && value[start][j] == 0) value[start][j] = sum;
			}
			sb.append(sum).append("\n");
		}
//		for(int i=0;i<N;i++) System.out.println(Arrays.toString(value[i]));
//		System.out.println();
		System.out.println(sb);
		

//		for(int i=0;i<N;i++) System.out.println("유사도: "+usado[i]);
	}

	private static void bfs(int start) {
		
		for(int i=0;i<N;i++) {
			if(start == i) continue;
			if(map[start][i] == 0) {
				map[start][i] = map[i][start] = Math.min(usado[start], usado[i]);
			}
		}
			
	}
}






















