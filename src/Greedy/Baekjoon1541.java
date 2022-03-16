package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split("-");
		
		String[] tmp;
		int t = 0;
		for(int i=1;i<arr.length;i++) {
			tmp = arr[i].split("\\+");
			for(int j=0;j<tmp.length;j++) {
				t += Integer.parseInt(tmp[j]);
			}
		}
		
		tmp = arr[0].split("\\+");
		int result = 0;
		for(int i=0;i<tmp.length;i++)
			result += Integer.parseInt(tmp[i]);
		
		System.out.println(result - t);
		
	}

}
