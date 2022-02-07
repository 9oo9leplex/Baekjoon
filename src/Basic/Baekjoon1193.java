package Basic;

import java.util.Scanner;

public class Baekjoon1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 1;
		int i = 1;
		
		if(n == sum) {
			System.out.println("1/1");
			return;
		}
		
		while(n >= sum) {
			if(n == sum) {
				System.out.printf("%d/%d",i,i);
				return;
			}
			sum += (4*i++);
		}
		int r = i;
		int d = i;
		
		while(d != 1) {
			sum--; d--; r++;
			if(n==sum) {
				System.out.printf("%d/%d",r,d);
				return;
			}
		}
		
		sum--; r--;
		if(n==sum) {
			System.out.printf("%d/%d",r,d);
			return;
		}
		
		while(r != 1) {
			sum--; d++; r--;
			if(n==sum) {
				System.out.printf("%d/%d",r,d);
				return;
			}
		}
		
		sum--; d--;
		if(n==sum) {
			System.out.printf("%d/%d",r,d);
			return;
		}
		
		while(r != d) {
			sum--; d--; r++;
			if(n==sum) {
				System.out.printf("%d/%d",r,d);
				return;
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
