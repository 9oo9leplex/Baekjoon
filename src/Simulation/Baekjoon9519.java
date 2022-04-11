package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon9519 {

	static char[] arr;
	static int len;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 껌뻑임 횟수 입력
		int n = Integer.parseInt(br.readLine());
		// 배열 입력 받기
		arr = br.readLine().toCharArray();
		len = arr.length;
		// 입력받은 배열을 몇 번 반복해야 원래대로 돌아오는지 계산
		int loop = getLoopCnt();
		// 껌뻑임 횟수 조정
		n %= loop;
		

		// 규칙에 의해 변경된 배열을 저장하기 위한 공간
		char[] tmp = new char[len];
		// 맨 앞자리는 고정
		tmp[0] = arr[0];
		// tmp 인덱스 조정을 위한 변수
		int idx;
		// 껌뻑임 횟수만큼 반복
		for(int j=0;j<n;j++) {
			// 껌뻑임이 반복될 때마다 인덱스 초기화
			idx = 1;
			// 기존 배열 인덱스 1부터 변경
			for(int i=1;i<len;i++) {
				// 홀수는 뒤에서
				if(i%2 == 1) tmp[len-idx++] = arr[i];
				// 짝수는 앞에서
				else tmp[i/2] = arr[i];

			}
			// 변경된 배열 최신화
			arr = tmp.clone();
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : arr) sb.append(c);
		System.out.println(sb);
		
	}
	
	/*
	 * @param len arr배열의 크기 
	 * @param mid 
	 * arr 배열을 나누기 위한 변수
	 * arr 배열의 크기가 홀수면 len/2+1, 짝수면 len/2
	 * @param idx tmp 배열에 값을 넣기 위한 변수
	 * @param tmp[] 규칙에 의해 변경된 arr 배열 저장
	 * @param save[] tmp[] 배열 최신화 저장 배열
	 * @param flag arr 배열과 tmp 배열의 값 비교 결과 저장 변수
	 * @return cnt 규칙에 의해 변경된 tmp 배열이 맨 처음 상태로 돌아오기까지 걸리는 시간
	 */
	static int getLoopCnt() {
		int mid = len % 2 == 1 ? len/2+1 : len/2;
		int cnt = 1,idx;
		char[] tmp = arr.clone();
		char[] save = arr.clone();
		boolean flag;

		Queue<Character> q = new LinkedList<>();
		Deque<Character> dq = new LinkedList<>();
		
		while(true) {
			idx=1;
			flag = true;
			// save배열(최신화된 tmp 배열의 값)을 분리
//			for(int i=1;i<mid;i++) q.add(save[i]);
//			for(int i=mid;i<len;i++) dq.add(save[i]);
			
			for(int i=1;i<len;i++) dq.add(save[i]);
			
			// 규칙에 맞게 tmp 배열 생성
			for(int i=0;i<mid-1;i++) {
				tmp[idx++] = dq.pollLast();
				tmp[idx++] = dq.pollFirst();
//				tmp[idx++] = q.poll();
			}
			
			// len 크기가 짝수일 때 dq의 마지막 뽑기
			if(len%2==0) tmp[idx] = dq.poll();
			
			// arr 배열과 tmp 배열 비교
			for(int i=1;i<len;i++) {
				if(arr[i] != tmp[i]) {
					flag = false;
					break;
				}
			}
			
			// arr배열과 tmp배열이 같다면 break;
			if(flag) break;
			cnt++;
			// tmp배열 값 최신화
			save = tmp.clone();
		}
		
		return cnt;
	}


}
