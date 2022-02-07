package Recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Snail {

	static int row = 0;
	static int col = -1;
	static int move = 0;

	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int size = sc.nextInt();
			int[][] snail = new int[size][size];

			snail(1, size, snail);
			print(i+1,snail);
			row = 0;
			col = -1;
			move = 0;
		}
		System.out.println(sb);
	}

	public static void snail(int start, int size, int[][] arr) {
		if (size == 0)
			return;
		int cnt = 2;
		if (size == arr.length)
			cnt = 1;

		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < size; j++) {
				// 오른쪽
				if (move % 4 == 0) {
					col += deltas[move % 4][1];
				}
				// 아래쪽
				else if (move % 4 == 1) {
					row += deltas[move % 4][0];
				}
				// 왼쪽
				else if (move % 4 == 2) {
					col += deltas[move % 4][1];
				}
				// 위쪽
				else {
					row += deltas[move % 4][0];
				}
				arr[row][col] = start++;
			}
			move++;
		}

		snail(start, size - 1, arr);
	}
	
	public static void print(int index, int[][] arr) {
		sb.append("#").append(index).append("\n");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}

}
