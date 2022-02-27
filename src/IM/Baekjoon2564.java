package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2564 {
	
	static class shop{
		int x,y,d;

		public shop(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		int[] dr = {0,0,row,0,col};
		shop[] list = new shop[n];
		
//		int[][] map = new int[row+1][col+1];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x <= 2)
				list[i] = new shop(dr[x], y,change(x));
			else
				list[i] = new shop(y, dr[x],change(x));
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		shop person;
		if(x <= 2)
			person = new shop(dr[x], y,change(x));
		else 
			person = new shop(y, dr[x],change(x));
		
		int result = 0;
		for(int i=0;i<list.length;i++) {
			int dir = Math.abs(list[i].d - person.d);
			if(dir == 1 || dir == 3) {
				result += (Math.abs(list[i].x-person.x) + Math.abs(list[i].y - person.y));
			} else if(dir == 2){
				if(list[i].d == 1 || list[i].d == 3) result += (row + 
						Math.min(list[i].y+person.y, col-list[i].y+col-person.y));
				else result += (col + Math.min(list[i].x+person.x, row-list[i].x+row-person.x));
			} else {
				if(list[i].x == person.x) result += Math.abs(list[i].y - person.y);
				else result += Math.abs(list[i].x - person.x);
			}
		}
		System.out.println(result);
	}
	
	static int change(int a) {
		switch(a) {
		case 1:
			return 1;
		case 2:
			return 3;
		case 3:
			return 2;
		default:
			return 4;
		}
	}
}
