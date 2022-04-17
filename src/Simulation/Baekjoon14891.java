package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14891 {

	static class Wheel {

		int start;

		public Wheel(int start) {
			super();
			this.start = start;
		}

	}

	static int w[][];
	static Wheel[] wheels;
	static Queue<Integer> leftRotate = new LinkedList<>();
	static Queue<Integer> rightRotate = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		wheels = new Wheel[4];
		w = new int[4][8];

		for (int i = 0; i < 4; i++) {
			char[] tmp = br.readLine().toCharArray();
			wheels[i] = new Wheel(0);
			for (int j = 0; j < 8; j++) {
				w[i][j] = tmp[j] - '0';
			}
		}

		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			if (dir > 0)
				rightRotate.add(target);
			else
				leftRotate.add(target);

			for (int j = target; j < 3; j++) {
//				System.out.println("[j,right]: ["+j+","+(wheels[j].start+2)%8+"], [j+1,left]: ["+(j+1)+","+(wheels[j+1].start+6)%8+"]");
				if (w[j][(wheels[j].start + 2) % 8] != w[j + 1][(wheels[j + 1].start + 6) % 8]) {
					if ((j + 1 + target) % 2 == 0) {
						if (dir > 0)
							rightRotate.add(j + 1);
						else
							leftRotate.add(j + 1);
					} else {
						if (dir > 0)
							leftRotate.add(j + 1);
						else
							rightRotate.add(j + 1);
					}
				} else
					break;
			}

			for (int j = target; j > 0; j--) {
//				System.out.println("[j,left]: ["+j+","+(wheels[j].start+6)%8+"], [j-1,right]: ["+(j-1)+","+(wheels[j-1].start+2)%8+"]");
				if (w[j][(wheels[j].start + 6) % 8] != w[j - 1][(wheels[j - 1].start + 2) % 8]) {
					if ((j - 1 + target) % 2 == 0) {
						if (dir > 0)
							rightRotate.add(j - 1);
						else
							leftRotate.add(j - 1);
					} else {
						if (dir > 0)
							leftRotate.add(j - 1);
						else
							rightRotate.add(j - 1);
					}
				} else
					break;
			}

//			System.out.println("left: "+leftRotate);
//			System.out.println("right: "+rightRotate);

			while (!leftRotate.isEmpty()) {
				int tmp = leftRotate.poll();
				wheels[tmp].start = (wheels[tmp].start + 1) % 8;
			}

			while (!rightRotate.isEmpty()) {
				int tmp = rightRotate.poll();
				wheels[tmp].start = (wheels[tmp].start - 1) < 0 ? 7 : wheels[tmp].start - 1;
			}

		}
		for (int j = 0; j < 4; j++) {
			if (w[j][wheels[j].start] == 1)
				sum += Math.pow(2, j);
		}
		System.out.println(sum);
	}
}
