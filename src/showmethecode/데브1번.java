package showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 데브1번 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] grade = new int[n];
		
		for(int i=0;i<n;i++) grade[i] = Integer.parseInt(st.nextToken()); 
		
		int answer = 0;
		for(int i=n-1;i>0;i--) {
			if(grade[i] < grade[i-1]) {
				answer += grade[i-1] - grade[i];
				grade[i-1] = grade[i];
			}
		}
		
		System.out.println(answer);
	}
}
