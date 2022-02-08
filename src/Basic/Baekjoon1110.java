package Basic;

import java.util.Scanner;

public class Baekjoon1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tmp = n;
		int cnt = 0;
		do {
			int a = tmp % 10;
			int b = tmp / 10;
			tmp = a*10 + (a+b)%10;
			cnt++;
		} while(n != tmp);
		System.out.println(cnt);
	}

}
