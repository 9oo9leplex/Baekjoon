package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon5073 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[3];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<3;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			
			Arrays.sort(arr);
			if(arr[2] >= arr[0] + arr[1]) sb.append("Invalid");
			else if(arr[0] == arr[1] && arr[1] == arr[2]) sb.append("Equilateral");
			else if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) sb.append("Isosceles");
			else sb.append("Scalene");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
