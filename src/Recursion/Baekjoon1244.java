package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1244 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine())+1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=1;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int s = Integer.parseInt(br.readLine());
		for(int i=1;i<=s;i++) {
			st = new StringTokenizer(br.readLine());
			String sex = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			// 남자
			if(sex.equals("1")) {
				for(int x=num;x<n;x+=num) {
					arr[x]^=1;
				}
			} 
			// 여자
			else {
				int lindex = num-1;
				int rindex = num+1;
				
				while(true) {
					if(lindex < 1 || rindex > arr.length-1) break;
					if(arr[lindex] != arr[rindex]) break;
					lindex--; rindex++;
				}
				lindex++; rindex--;
				
				while(lindex<=rindex) {
					arr[lindex]^=1;
					lindex++;
				}
				
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n;i++) {
			sb.append(arr[i]).append(" ");
			if(i%20==0) sb.append("\n");
		}
		System.out.println(sb);
	}

}
