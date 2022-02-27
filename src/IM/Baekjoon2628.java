package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2628 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		List<Integer> row = new ArrayList<>();
		List<Integer> col= new ArrayList<>();
		
		row.add(r);
		col.add(c);
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if(type == 0) {
				int j;
				for(j=0;len - row.get(j) > 0; j++) {
					len -= row.get(j);
				}
				int tmp = row.remove(j);
				row.add(j,tmp - len);
				row.add(j,len);
			} else {
				int j;
				for(j=0;len - col.get(j) > 0; j++) {
					len -= col.get(j);
				}
				int tmp = col.remove(j);
				col.add(j,tmp-len);
				col.add(j,len);
			}
		}
		
		int max=0;
		for(int a : row) {
			for(int b : col) {
				max = Math.max(max, a*b);
			}
		}
		System.out.println(max);
	}

}
