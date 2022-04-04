package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon12904 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		char[] arr = br.readLine().toCharArray();
		int len = arr.length;
		int l = s.length();
		int dir = 0;
		
		Deque<Character> deque = new ArrayDeque<>();
		for(int i=0;i<len;i++) {
			deque.add(arr[i]);
		}
		
		char tmp;
		while(true) {
			if(l == deque.size()) break;
			
			switch(dir) {
			case 0:
				tmp = deque.pollLast();
				if(tmp == 'B') dir = dir == 0 ? 1 : 0;
				break;
			case 1:
				tmp = deque.pollFirst();
				if(tmp == 'B') dir = dir == 0 ? 1 : 0;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : deque)
			sb.append(c);
		sb = dir == 1 ? sb.reverse() : sb;
		
		System.out.println(s.equals(sb.toString())? 1 : 0);
		}
}
