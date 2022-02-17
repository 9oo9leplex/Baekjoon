package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3109 {

	static char map[][];
	static boolean visit[][], flag;
	static int row,col,answer;
	static int[][] deltas = {
			{-1,1},
			{0,1},
			{1,1}
	};
	
	public static void main(String[] args) throws IOException{
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new char[row][col];
		visit = new boolean[row][col];
		for(int i=0;i<row;i++)
			map[i] = br.readLine().toCharArray();
		
		for(int i=0;i<row;i++) {
			flag = false;
			setBackTracking(i,0);
		}
		
		System.out.println(answer);
	}

	private static void setBackTracking(int rowNo, int colNo) {

		if(colNo == col-1) {
			answer++;
			visit[rowNo][colNo] = true;
			flag = true;
			return;
		}
		
		for(int i=0;i<3;i++) {
			int r = rowNo + deltas[i][0];
			int c = colNo + deltas[i][1];
			
			if(isBlock(r, c) && visit[r][c] == false && map[r][c]=='.') {
				setBackTracking(r, c);
				visit[r][c] = true;
				if(flag) return;
			}
		}
	}

	private static boolean isBlock(int rowNo, int colNo) {
		return rowNo >= 0 && colNo >= 0 && rowNo < row && colNo < col;
	}

}
