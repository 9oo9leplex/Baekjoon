package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA13038 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=tc;t++) {
			int N = Integer.parseInt(br.readLine());
			
			// 각 요일에 수업열리는 여부
			int[] week = new int[7];
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<7;i++)
				week[i] = Integer.parseInt(st.nextToken());
			
			int min = Integer.MAX_VALUE;
			for(int start=0;start<7;start++) {
				// 수업이 시작하는 모든 요일 처리
				// 수업이 없는 날은 패스
				if(week[start] == 0) continue; 
				
				int day = start, cnt = 0;
				while(true) {
					// 수업이 열리면 카운팅
					if(week[day%7] == 1) cnt++;
					// 하루 지남
					++day; 
					if(cnt == N) {
						min = Math.min(min, day-start);
						break;
					}
				}
			}
			System.out.println("#"+t+" "+min);
		}

	}

}
