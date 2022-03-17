package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon14241 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new LinkedList<>();
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		if(list.size() == 1) {
			System.out.println(list.remove(0));
			return ;
		}
		
		long result = 0;
		while(true) {
			if(list.size() == 1) break;
			Collections.sort(list);
			int a = list.remove(list.size()-1);
			int b = list.remove(list.size()-1);
			result += a*b;
			list.add(a+b);
		}
		
		System.out.println(result);
		
	}
}
