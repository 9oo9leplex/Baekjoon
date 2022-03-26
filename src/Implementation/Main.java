package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int map[] = new int[257];
		LinkedList<Integer> q = new LinkedList<>();
		int tmp,sum,cnt,later,tmpN,time = 0,height = 0,result = Integer.MAX_VALUE;
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				tmp = Integer.parseInt(st.nextToken());
				map[tmp]++;
				if(!q.contains(tmp)) q.add(tmp);
			}
		}
		
		Collections.sort(q);
		height = -1;
		
		for(int i=0;i<q.size();i++) {
			tmp = q.get(i);
			tmpN = n;
			sum = 0;
			time = 0;
			cnt = 0;
			
			for(int j=0;j<q.size();j++) {
				if(i==j) continue;
				int a = q.get(j);
				int diff = a - tmp;
				
				if(diff > 0) {
//					System.out.println("diff: "+diff+ ", tmp: "+tmp+", now: "+a+", size: "+map[a]);
					time += (diff*map[a]*2);
					tmpN += (diff*map[a]);
				} else if(diff < 0) {
//					System.out.println("diff: "+diff+ ", tmp: "+tmp+", now: "+a+", size: "+map[a]);
					time += Math.abs(diff)*map[a];
					tmpN -= Math.abs(diff)*map[a];
				}
				
//				System.out.println("time: "+time+", block: "+tmpN);
				
			}
			if(tmpN >= 0) {
				if(result >= time) {// || (result == time && height < tmp)) {
					result = time;
					height = tmp;
				}
			}
//			later = map[tmp];
//			System.out.println("기준: "+tmp);
			// 현재 기준보다 큰 값 들을 깎는다
			/*
			for(int j=i+1;j<q.size();j++) {
				time += map[q.get(j)] * (q.get(j) - tmp) * 2;
				tmpN += map[q.get(j)] * (q.get(j) - tmp);
//				later += map[q.get(j)];
			}
			// 현재 기준보다 작은 값들에 쌓는다
			for(int j=0;j<i;j++) {
//				System.out.println("방문 높이: "+q.get(j)+", 방문높이 갯수: "+map[q.get(j)]);
//				System.out.println("추가된 블럭: "+ map[q.get(j)] * (tmp - q.get(j)));
//				sum += map[q.get(j)] * (tmp - q.get(j));
				time += map[q.get(j)] * (tmp - q.get(j)) * 2;
				tmpN -= map[q.get(j)] * (tmp - q.get(j));
			}
			
			System.out.println("block: "+tmpN+", time: "+time+", result: "+result);
			
			if(tmpN >= 0) {
				if(time <= result) {
					height = tmp;
					result = time;
				}
				else if(height <= tmp) {
					height = tmp;
					result = time;
				}
			}
			*/
//			System.out.println(" 남은 블럭: "+tmpN+", 쌓아야할 갯수: "+sum);
			/*
			if(sum > tmpN) {
				while(true) {
					if(sum <= tmpN) break;
					tmpN += (later);
					time += (later) * 2;
					cnt++;
//					System.out.println("기준 높이: "+tmp+", 블럭: "+tmpN);
				}
				tmp -= cnt;
			}
			
			time += sum;
			*/
//			System.out.println("기존 시간:현재 시간 "+result+" : "+time+", 기존 높이:현재 높이 "+height+" : "+tmp);
//			System.out.println("조건: "+ (result > time && tmp > height));
			// 시간이 적게 걸리고 높이가 더 높다면 변경
			/*
			if(result >= time) {
				if(result == time) {
//					System.out.println("1");
					if(tmp > height) {
						result = time;
						height = tmp;
					}
				} else {
//					System.out.println("2");
					result = time;
					height = tmp;
				}
			}
			*/
		}
		
		
		System.out.println(result+" "+height);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
