package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,K,arr[];

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[2*N];
		Deque<Integer> upSideBelt = new LinkedList<>();
		Deque<Integer> downSideBelt = new LinkedList<>();
		Queue<Integer> robot = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			upSideBelt.add(i);
			downSideBelt.add(2*N-1-i);
		}
		
		int first, len, bot, next, cnt=0;
		
		while(K > 0) {
			
			cnt++;
			
			// 벨트 이동
			downSideBelt.addLast(upSideBelt.pollLast());
			upSideBelt.addFirst(downSideBelt.pollFirst());
			
			System.out.println(upSideBelt);
			System.out.println(downSideBelt);
			System.out.println("현재 작업: "+robot);
			// 로봇 이동
			len = robot.size();
			for(int i=0;i<len;i++) {
				bot = robot.poll();
				if(upSideBelt.peekLast() == bot) continue;
				next = (bot+1) %( 2 * N);
				if(arr[next] > 0) {
					arr[next]--;
					if(isZero(next)) K--;
					robot.add(next);
				} else robot.add(bot);
			}
			
			System.out.println("로봇 이동 후");
			System.out.println(Arrays.toString(arr));
			
			
			// 로봇 올리기
			first = upSideBelt.peekFirst();
			if(arr[first] > 0) {
				robot.add(first);
				arr[first]--;
				if(isZero(first)) K--;
			}
			
			System.out.println("로봇 올린 후");
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println(cnt);
		
		
	}


	private static boolean isZero(int index) {
		return arr[index] == 0;
	}

	
}









