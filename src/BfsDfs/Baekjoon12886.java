package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12886 {
		
		static boolean[][] visit;
		static int result;
		
	    public static void main(String[] args) throws IOException {
	        
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	
	    	int a,b,c;
	    	
	    	a = Integer.parseInt(st.nextToken());
	    	b = Integer.parseInt(st.nextToken());
	    	c = Integer.parseInt(st.nextToken());
	    	
	    	if( (a+b+c) % 3 != 0) {
	    		System.out.println(0);
	    		return;
	    	}
	    	else {
	    		visit = new boolean[1501][1501];
	    		dfs(a,b,c);
	    		System.out.println(result);
	    	}
	    	
	    	
	  
	    }

		private static void dfs(int a, int b, int c) {
			
			if(a == b  && a == c) {
				result = 1;
				return;
			}
			
			make(a,b,c);
			make(a,c,b);
			make(b,c,a);
				
		}

		private static void make(int a, int b, int c) {

			int max,min;
			
			min = Math.min(a, b);
			max = Math.max(a, b);
			
			if(!visit[min * 2][max - min]) {
				visit[min * 2][max - min] = visit[max - min][min * 2] = true;
				dfs(min * 2,max - min,c);
			}
			
			
		}
}
