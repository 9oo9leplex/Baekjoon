package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {		
	
	static class Problem {
		int alp_req, cop_req, alp_rwd, cop_rwd, cost;

		public Problem(int alp_req, int cop_req, int alp_rwd, int cop_rwd, int cost) {
			super();
			this.alp_req = alp_req;
			this.cop_req = cop_req;
			this.alp_rwd = alp_rwd;
			this.cop_rwd = cop_rwd;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int alp = Integer.parseInt(br.readLine());
		int cop = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] problems = new int[n][5];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			problems[i][0] = Integer.parseInt(st.nextToken());
			problems[i][1] = Integer.parseInt(st.nextToken());
			problems[i][2] = Integer.parseInt(st.nextToken());
			problems[i][3] = Integer.parseInt(st.nextToken());
			problems[i][4] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(problems, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
			
//		for(int i=0;i<n;i++) System.out.println(Arrays.toString(problems[i]));
//		System.out.println();
		
		List<Problem> list = new ArrayList<>();
		List<Problem> yet = new ArrayList<>();
		int len = problems.length;
		boolean[] sol = new boolean[len];
		boolean solved;
		
		int day = 0,cnt=0,min,difAlp,difCop,index;
		
		// 로직
		// 문제 탐색
		// 풀 문제가 있다면 풀고 리스트에 추가
		// 풀 문제가 없다면 가장 적은 차이가 나는 놈 고르기
		//	1일 사용하여 능력치 기르기 or 푼 문제 또 풀기
		
		
		while(true) {
			
			solved = false;
			min = Integer.MAX_VALUE;
			if(cnt == len) break;
			
			for(int i=0;i<len;i++) {
				if(sol[i]) continue;
				
				if(alp >= problems[i][0] && cop >= problems[i][1]) {
					sol[i] = true;
					solved = true;
					alp += problems[i][2];
					cop += problems[i][3];
					day += problems[i][4];
					cnt++;
					list.add(new Problem(problems[i][0], problems[i][1], problems[i][2], problems[i][3], problems[i][4]));
				} else {
					yet.add(new Problem(problems[i][0], problems[i][1], problems[i][2], problems[i][3], problems[i][4]));
				}
			}
			
			if(solved) continue;
			
			// 1. 푼 문제 다시 풀기
			if(list.size() > 0) {
			// 못 푼 문제들 중 요구 사항 차이가 가장 작은 놈이나
				for(Problem b : yet) {
					difAlp = b.alp_req - alp;
					difCop = b.cop_req - cop;
					// 필요한 능력치 구하기
					if(difAlp < 0) difAlp = 0;
					if(difCop < 0) difCop = 0;
				
				
				}
			}
			// 2. 1일 소비하여 코딩력 or 알고력 +1 하기
			
		}
		

	

	}
}
