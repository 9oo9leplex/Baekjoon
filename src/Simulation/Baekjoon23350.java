package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon23350 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		int[] pCnt = new int[p+1];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			q.add(new int[] {l,w});
			pCnt[l]++;
		}
		
		int t = 0;
		Stack<int[]> s = new Stack<>();
		Stack<int[]> s2 = new Stack<>();
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			// 우선 순위가 안맞으면 뒤로 이동
			if(tmp[0] != p) {
				q.offer(tmp);
				t += tmp[1];
				continue;
			}
			t += tmp[1];
			pCnt[tmp[0]]--;
			
			// 우선 순위가 맞고 스택이 비어있다면
			if(s.isEmpty()) {
				s.push(tmp);
				if(pCnt[tmp[0]] == 0) p -= 1;
			} 
			// 스택에 뭐가 있다면 전부 비교
			else {
				while(!s.isEmpty()) {
					int[] out = s.peek();
					// 우선순위 비교, 우선순위가 같다면 무게 비교
					if((tmp[0] > out[0]) || (tmp[0] == out[0] && tmp[1] > out[1])) {
						s2.add(s.pop());
						t += out[1];
						
						if(s.isEmpty()) {
							s.push(tmp);
							if(pCnt[tmp[0]] == 0) p -= 1;
							break;
						}
						
						continue;
					}
					
					s.push(tmp);
					
					if(pCnt[tmp[0]] == 0) p -= 1;
					break;
				}
				
				while(!s2.isEmpty()) {
					int[] out = s2.pop();
					t += out[1];
					s.push(out);
				}
			}
		}
		System.out.println(t);
	}

}
