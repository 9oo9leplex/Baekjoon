package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10163 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int map[][] = new int[1002][1002];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int a=x;a<x+w;a++) {
				for(int b=y;b<y+h;b++) {
					map[a][b] = i;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			int sum = 0;
			for(int j=0;j<=1001;j++) {
				for(int k=0;k<=1001;k++) {
					if(map[j][k] == i) sum++;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
