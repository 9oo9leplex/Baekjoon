package codingTest.lg.Day221001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem1 {

	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		Queue<String> q = new LinkedList<>();
//		int arr[] = {101,110,101,110,1010,10001};
//		int cur;
//		StringBuilder sb = new StringBuilder();
//		
//		for(int a : arr) {
//			
//			while(a > 0) {
//				cur = a % 10;
//				a /= 10;
//				pq.add(cur);
//			}
//			
////			int sum = 0;
//			sb.setLength(0);
//			while(!pq.isEmpty()) {
//				sb.append(pq.poll());
//			}
//			if(q.contains(sb.toString())) continue;
//			q.add(sb.toString());
//			System.out.println(q);
//		}
		
		String tmp = "bcde";
		String a = "a";
		
		tmp = a + tmp;
		System.out.println(tmp);
		
//		while(!pq.isEmpty()) System.out.println(pq.poll());
	}

}

/*
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        int cur,answer = 0;
        long sum;
        Queue<String> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int a : arr) {

            // if(q.contains(a)) continue;

            while(a > 0) {
                cur = a % 10;
                a /= 10;
                pq.add(cur);
            }
            
            // sum = 0;
            sb.setLength(0);
			while(!pq.isEmpty()) {
				sb.append(pq.poll());
			}
            if(q.contains(sb.toString())) continue;
            answer++;
            q.add(sb.toString());
            // System.out.println(q);
        }
        return answer;
    }
}
 */














