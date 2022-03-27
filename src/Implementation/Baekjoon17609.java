package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17609 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int cnt,mid,len;
		
		for(int i=0;i<n;i++) {
			char[] word = br.readLine().toCharArray();
			mid = word.length/2;
			len = word.length;
			cnt = 0;
			
			for(int j=0;j<mid;j++) {
//				System.out.println(word[j]+" : "+word[len-j-1]);
//				System.out.println(word[j] != word[len-j-1]);
				if(word[j] != word[len-j-1]) {
					cnt = 1;
					for(int k=j;k<mid;k++) {
						if(word[k+1] != word[len-k-1]) {
							cnt = 2;
							break;
						}
					}
					
					if(cnt == 1) break;
					
					cnt = 1;
					for(int k=j;k<mid;k++) {
						if(word[k] != word[len-k-2]) {
							cnt = 2;
							break;
						}
					}
					
					break;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
