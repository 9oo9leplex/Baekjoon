package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		Queue<Character> q = new LinkedList<>();
		Deque<Character> dq = new LinkedList<>();
		
		int len = arr.length % 2 == 1 ? arr.length-1 : arr.length;
		int loop = 1;
		
		while(true) {
			if(len % 2 == 1) {
				loop = arr.length - 1;
				break;
			}
			if(len == 2) {
				loop++;
				break;
			}
			len /= 2;
			loop++;
		}
		
		n %= loop;
		len = arr.length;
//		System.out.println(len);
		char[] tmp = new char[len];
		tmp[0] = arr[0];
		int idx;
		for(int j=0;j<n;j++) {
			System.out.println("j: "+j+", "+Arrays.toString(arr));
			idx = 1;
			for(int i=1;i<len;i++) {
//				System.out.println("i: "+i+", idx: "+idx);
				if(i%2 == 1) tmp[i] = arr[len-idx++];
				else tmp[i] = arr[i/2];
//				System.out.println(Arrays.toString(tmp));
			}
			arr = tmp.clone();
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
