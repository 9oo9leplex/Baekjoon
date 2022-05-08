package Baemin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
8	// 4,8,2,3,6,7,1,5
85 90
65 67
88 87
88 87
73 81
65 89
99 100
80 94

3	// 2,1,3
85 90
91 87
88 87
 */
public class Sol2 {
	
	static int diffQ;
	
	static class Person implements Comparable<Person>{
		int index, q1, q2, sum,rank;

		public Person(int index, int q1, int q2, int sum) {
			super();
			this.index = index;
			this.q1 = q1;
			this.q2 = q2;
			this.sum = sum;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}



		@Override
		public int compareTo(Person o) {
			if(this.sum == o.sum) {
				if(diffQ == 0) return this.index - o.index; 
				else if(diffQ == 1) {
					if (this.q1 == o.q1) return this.index - o.index;  
					else return o.q1 - this.q1;
				}
				else {
					if(this.q2 == o.q2) return this.index - o.index;
					return o.q2 - this.q2;
				}
			}
			return o.sum - this.sum;
		}

		@Override
		public String toString() {
			return "Person [index=" + index + ", q1=" + q1 + ", q2=" + q2 + ", sum=" + sum + "]";
		}

		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
//		int p[][] = new int[n][2];
		StringTokenizer st;
		int sum1 = 0, sum2 = 0;
		int num1,num2;
		
		List<Person> list = new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			list.add(new Person(i, num1, num2,num1+num2));
			
			sum1 += num1;
			sum2 += num2;
		}
		
		
		diffQ = 0;
		if(sum1 < sum2) diffQ = 1;
		else if(sum1 > sum2) diffQ = 2;
//		System.out.println(diffQ);
		Collections.sort(list);
		
		for(int i=0;i<n;i++)
			list.get(i).setRank(i+1);
		
		Collections.sort(list, (o1,o2) -> o1.index - o2.index);
		for(Person p : list)
			System.out.println(p.rank);
		
		
		
		
		
		
	}
}
