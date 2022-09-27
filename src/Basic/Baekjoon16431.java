package Basic;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon16431 {

public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
    	
    	int []bessie = new int [2];
		int []daisy = new int [2];
		int [] arr = new int [2];
		
		for(int i = 0; i < 2; i++) {
			bessie[i] = scan.nextInt();
		}
		
		for(int i = 0; i < 2; i++) {
			daisy[i] = scan.nextInt();
		}
		
		for(int i = 0; i < 2; i++) {
			arr[i] = scan.nextInt();
		}
		
		bessie[0] = Math.abs(bessie[0] - arr[0]);
		bessie[1] = Math.abs(bessie[1] - arr[1]);
		int bCount = bessie[0] >= bessie[1] ? bessie[0] : bessie[1];
		//한턴에 모든 방향으로 이동 가능하기때문에 행이나 열중 차이가 큰게 그 턴에 최대 이동값이된다.
		//때문에 행이나 열중 차이가 큰 값이 최소 이동거리가 된다.
		daisy[0] = Math.abs(daisy[0] - arr[0]);
		daisy[1] = Math.abs(daisy[1] - arr[1]);
		int dCount = daisy[0] + daisy[1];
		//한턴에 행이나 열중 하나 만 움직일 수 있으므로,
		//주어진 목적지의 행열의 각 차이가 최소 이동거리가 된다.
		
		if(bCount < dCount) {
			System.out.println("bessie");
		}else if(bCount > dCount) {
			System.out.println("daisy");
		}else {
			System.out.println("tie");
		};
    }
}
