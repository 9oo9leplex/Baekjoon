package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon15686 {

	static int N,M, value, result, cnt, tmp[], map[][],d[][];
	static List<int[]> clist,hlist;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		clist = new ArrayList<>();
		hlist = new ArrayList<>();
		tmp = new int[M];
		result = Integer.MAX_VALUE;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) hlist.add(new int[] {i,j});
				else if(map[i][j] == 2) {
					clist.add(new int[] {i,j});
				}
			}
		}
		
		d = new int[hlist.size()+1][clist.size()+1];
		
		cald();
		combi(0,0);
		System.out.println(result);
	}

	private static void cald() {
		
		for(int i=0;i<hlist.size();i++) {
			int hx = hlist.get(i)[0];
			int hy = hlist.get(i)[1];
			
			for(int j=0;j<clist.size();j++) {
				int cx = clist.get(j)[0];
				int cy = clist.get(j)[1];
				
				d[i+1][j+1] = Math.abs(hx-cx) + Math.abs(hy-cy); 
			}
		}
	}

	private static void combi(int cnt,int start) {
		
		if(cnt == M) {
			// 거리구하기
			value = 0;
			// 치킨집 인덱스 tmp[], 1,2,3 치킨 집 중에 집1번에서 최소거리 구하기
			for(int i=0;i<hlist.size();i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0;j<M;j++) {
					min = Math.min(min, d[i+1][tmp[j]+1]);
				}
				value += min;
			}
			result = Math.min(result, value);
			
			return;
		}
		
		for(int i=start;i<clist.size();i++) {
			tmp[cnt] = i;
			combi(cnt+1,i+1);
		}
	}

}
