package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon20055 {

	static int N,K,belt[];
	static boolean robot[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[2*N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++)
			belt[i] = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while(true) {
			beltMove();
			cnt++;
			robotMove();
			if(zeroCnt()) break;
		}
		System.out.println(cnt);
	}

	private static boolean zeroCnt() {

		int cnt = 0;
		for(int i=0;i<2*N;i++) {
			if(belt[i] == 0) {
				cnt++;
				if(cnt >= K) return true;
			}
		}
		return false;
	}

	private static void robotMove() {

		if(robot[N-1]) robot[N-1] = false;
		
		for(int i=N-2;i>0;i--) {
			if(robot[i] && !robot[i+1] && belt[i+1] > 0) {
				robot[i] = false;
				robot[i+1] = true;
				belt[i+1]--;
			}
		}
		
		if(!robot[0] && belt[0] > 0) {
			robot[0] = true;
			belt[0]--;
		}
		
	}

	private static void beltMove() {

		int tmp = belt[2*N-1];
		for(int i=2*N-2;i> -1;i--) {
			belt[i+1] = belt[i];
		}
		belt[0] = tmp;
		
		for(int i=N-2;i>-1;i--)
			robot[i+1] = robot[i];
		robot[0] = false;
	}
}
