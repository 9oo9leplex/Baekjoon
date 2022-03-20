package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beakjoon1946 {

	static class Person implements Comparable<Person>{
		int f,s;

		public Person(int f, int s) {
			super();
			this.f = f;
			this.s = s;
		}

		@Override
		public int compareTo(Person o) {
			return this.f - o.f;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int p,f,s,first,second,result,tmp;
		
		StringTokenizer st;
		Person[] list;
		for(int i=0;i<n;i++) {
			result = 1;
			p = Integer.parseInt(br.readLine());
			list = new Person[p];
			
			for(int j=0;j<p;j++) {
				st = new StringTokenizer(br.readLine());
				f = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				list[j] = new Person(f, s);
			}
			
			Arrays.sort(list);
			tmp = list[0].s;
			for(int j=1;j<p;j++) {
				if(tmp > list[j].s) {
					tmp = list[j].s;
					result++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
