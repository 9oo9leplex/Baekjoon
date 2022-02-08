package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9461 {

static long[] a;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			a = new long[tmp+1];
			
			if(tmp < 4) {
				sb.append(1).append("\n");
				continue;
			}
			a[1] = a[2] = a[3] = 1;
			p(tmp);
			sb.append(a[tmp]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void p(int n) {
		if(n == 3) return;
		p(n-1);
		a[n] = a[n-2] + a[n-3];
	}

}
