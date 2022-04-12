package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon11401Sol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		sc.close();
		
		ArrayList<Integer> biList = new ArrayList<>();
		Stack<Integer> stk = new Stack<>();
		// 0을 넣어주고 시작
		biList.add(0);
		
		int num = 1;
		// 2의 배수 리스트 생성 (N이 아무리 작아도 1이기 때문에 1은 추가)
		while(num <= N) {
			biList.add(num);
			num *= 2;
		}
		
		// 입력 받은 N을 2의 제곱수의 합으로 분리하기
		// n은 N을 넘지 않는 최대인 2의 제곱수로 시작
		int n = biList.get(biList.size()-1);
		while (N > 0) {
			if (n > N) {
				int temp = Collections.binarySearch(biList, N);
				int idx = 0;
				if (temp >= 0) {// 일치하는 2의 제곱수가 있다면
					idx = temp;
				}else {// 2의 제곱수 사이에 위치하는 값이라면 
					idx = Math.abs(temp) - 2;
				}// 그 보다 작거나 같으면서 가장 큰 값 가져옴
				n = biList.get(idx);
			}
			
			stk.push(n);
			N -= n;
		}// 여기까지 하면 128 32 4 2 1 같은 스택이 생성됨
		
		// 스택의 크기가 K를 넘지 않을 때까지 물병을 구매
		while (stk.size() > K) {
			// 한 번의 구매로 연달아 합쳐지는 경우를 처리하기 위해 do while 사용
			int nt = 0;
			do {
				// 제일 작은 물병을 합치기위해 필요한 물병 수 확인
				int target = stk.pop();
				
				// 연달아 합쳐지는 경우가 아닐 때만 카운트를 증가
				if (nt == 0) {
					cnt += target;
				}
				
				nt = target * 2;
				// 스택이 비었다면 탈출
				if(stk.isEmpty()) break;
			} while (stk.peek() == nt);
			// 합칠 수 있는만큼 모두 합치고 그 결과를 푸시
			stk.push(nt);
		}
		
		System.out.println(cnt);
	}
}
