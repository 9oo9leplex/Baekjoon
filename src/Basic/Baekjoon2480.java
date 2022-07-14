package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2480 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
//		int result = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[7];
		for(int i=0;i<3;i++) arr[Integer.parseInt(st.nextToken())]++;
		
		int idx = 0;
		for(int i=6;i>0;i--) {
			if(arr[i] == 3) {
				System.out.println(10000 + i * 1000);
				return;
			}
			else if(arr[i] == 2) {
				System.out.println(1000 + i * 100);
				return;
			}
			else if(arr[i] == 1) idx = Math.max(idx, i);
		}
		
		System.out.println(idx * 100);
		
	}
}
