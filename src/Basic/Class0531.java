package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Class0531 {

	static int[] arr = {1,5,4,2,9,7};
	static char[] arr2 = {'A','S','A','D','A','D','A','S'};
	static int n = 6;
	static void flip(int a, int b) {
		for(int i=a;i<=b;i++) {
			arr[i] = arr[i] * 7 + 15;
			arr[i] = arr[i] % 7;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		// n입력
		int n = Integer.parseInt(br.readLine());
		// a,b 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		// a~b 구간 n번 뒤집기
		// 뒤집기 공식( * 7 + 15 % 7 )
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<n;i++) {
			flip(a,b);
		}

		System.out.println(Arrays.toString(arr));
		
		
		int[] cnt = new int[26];
		int len = arr2.length;
		int maxCnt = 0;
		char maxChar = ' ';
		for(int i=0;i<len;i++) {
			cnt[arr2[i] - 'A']++;
			
			if(maxCnt < cnt[arr2[i] - 'A']) {
				maxCnt = cnt[arr2[i] - 'A'];
				maxChar = arr2[i];
			}
		}
		System.out.println(maxChar);
		System.out.println(maxCnt);
		*/
		
		run(0);
	}

	private static void run(int i) {

		if(i==6)
			return;
		
		System.out.print(arr2[i]);
		run(i+1);
		System.out.print(arr2[i]);
	}
}
