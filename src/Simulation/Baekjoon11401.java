package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11401 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	
		int ans = 0;
		int len,cnt;
		
		while(true) {
			char[] arr = Integer.toBinaryString(n).toCharArray();
			cnt = 0;
			len = arr.length;
			for(int i=0;i<len;i++)
				if(arr[i] == '1') cnt++;
			
			if(cnt <= k) {
				System.out.println(ans);
				break;
			}
			n++;
			ans++;
		}
		
		
	}

}
