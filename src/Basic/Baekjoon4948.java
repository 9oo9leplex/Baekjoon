package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4948 {

static boolean[] a;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int n = Integer.parseInt(br.readLine());
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) break;
			a = new boolean[2*tmp+1];
			
			for(int i=2;i*i<=2*tmp;i++) {
				if(!a[i]) {
					for(int j=i*i;j<=2*tmp;j+=i)
						a[j] = true;
				}
			}
			int result = 0;
			for(int i=tmp+1;i<=2*tmp;i++) {
				if(!a[i]) result++;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
