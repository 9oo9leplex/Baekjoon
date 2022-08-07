package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon4153 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int arr[] = new int[3];
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<3;i++) arr[i] = Integer.parseInt(st.nextToken());
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			
			Arrays.sort(arr);
			
			sb.append((int)Math.pow(arr[0], 2) + (int)Math.pow(arr[1], 2) == (int)Math.pow(arr[2], 2) ? "right" : "wrong").append("\n");
		}
		System.out.println(sb);
	}
}
