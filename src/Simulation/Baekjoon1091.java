package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1091 {

static int N,arr[],tmp[],p[],s[],first[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		tmp = new int[N];
		p = new int[N];
		s = new int[N];
		first = new int[N];
		
		for(int i=0;i<N;i++)
			arr[i] = (i%3);
		first = arr.clone();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			p[i] = (Integer.parseInt(st.nextToken())%3);
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			s[i] = Integer.parseInt(st.nextToken());
		
		// 초기값이 p[]와 같은지 비교
		if(isSame()) {
			System.out.println(0);
			return;
		}
		
		int cnt = 0;
		
		while(true) {

			// 섞기
			shuffle();
			cnt++;
			
			// 섞은 카드가 p과 같은지 비교
			if(isSame()) break;
			// 처음 값과 같은지 비교
			if(isFirst()) {
				System.out.println(-1);
				return;
			}
			
		}
		System.out.println(cnt);
	}

	private static void shuffle() {

		for(int i=0;i<N;i++) {
			tmp[i] = arr[s[i]];
		}
		arr = tmp.clone();

	}

	private static boolean isFirst() {
		for(int i=0;i<N;i++) {
			if(arr[i] != first[i]) return false;
		}
		
		return true;
	}

	private static boolean isSame() {
		
		for(int i=0;i<N;i++) {
			if(arr[i] != p[i]) return false;
		}
		
		return true;
	}
}
