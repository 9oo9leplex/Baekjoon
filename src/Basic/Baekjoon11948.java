package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon11948 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[4];
		for(int i=0;i<4;i++) arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int answer = Math.max(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
		for(int i=3;i>0;i--) answer += arr[i];
		
		System.out.println(answer);
		
}
}
