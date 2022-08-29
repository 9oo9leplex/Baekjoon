package codingTest.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 낚시터자리잡기 {

	static int seat, door[], people[], max, result, arr[];
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		door = new int[3];
		people = new int[3];
		
		for(int t=1;t<=tc;t++) {
			
			result = Integer.MAX_VALUE;
			seat = Integer.parseInt(br.readLine());
//			visit = new boolean[seat];
			
			for(int i=0;i<3;i++) {
				st = new StringTokenizer(br.readLine());
				door[i] = Integer.parseInt(st.nextToken());
				people[i] = Integer.parseInt(st.nextToken());
			}
			
			arr = new int[]{0,1,2};
			Arrays.sort(arr);
			
			do {
				// 문 순서로 시뮬레이션, 순열
				// 전략 왼쪽 먼저, 오른쪽 먼저
				left();
				right();
			} while(permutation());
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void right() {

		int index = 0;
		max = 0;
		visit = new boolean[seat + 1];
//		System.out.println("right 입장: "+Arrays.toString(door));
		// 입장 문 3번 반복
		for(int i=0;i<3;i++) {
			index = 0;
			// 입장문 사람 수 만큼 반복
			for(int j=0;j<people[arr[i]];) {
				if(inArea(door[arr[i]] + index) && !visit[door[arr[i]] + index]) {
					visit[door[arr[i]] + index] = true;
					max += ( index + 1 );
					j++;
					continue;
				}
				else {
					if(!inArea(door[arr[i]] - index) || visit[door[arr[i]] - index]) {
						index++;
						continue;
					}
					visit[door[arr[i]] - index] = true;
					max += ( index + 1 );
					j++;
					continue;
				}
				
			}
		}
		result = Math.min(max, result);
	}

	private static void left() {

		int index = 0;
		max = 0;
		visit = new boolean[seat + 1];

		// 입장 문 3번 반복
		for(int i=0;i<3;i++) {
			index = 0;
			// 입장문 사람 수 만큼 반복
			for(int j=0;j<people[arr[i]];) {
				if(inArea(door[arr[i]] - index) && !visit[door[arr[i]] - index]) {
					visit[door[arr[i]] - index] = true;
					max += ( index + 1 );
					j++;
					continue;
				}
				else {
					if(!inArea(door[arr[i]] + index) || (visit[door[arr[i]] + index])) {
						index++;
						continue;
					}
					
					visit[door[arr[i]] + index] = true;
					max += ( index + 1 );
					j++;
					continue;
				}
				
			}
		}
		result = Math.min(max, result);
	}

	private static boolean inArea(int input) {
		return input > 0 && input <= seat;
	}

	private static boolean permutation() {
		int len = 3;
		
		int i = len - 1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		
		if(i == 0) return false;
		
		int j = len - 1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(i-1,j);
		
		int k = len - 1;
		
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
