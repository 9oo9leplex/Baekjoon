package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9020 {

static boolean[] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		arr = new boolean[10001];
		arr[1] = true;
		p();
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			int l = tmp/2;
			int r = tmp/2;
			
			while(true) {
				if(tmp == l+r && !arr[l] && !arr[r]) break;
				l--; r++;
			}
			sb.append(l).append(" ").append(r).append("\n");
		}
		System.out.println(sb);
	}
	
	static void p() {
		
		for(int i=2;i*i<=10000;i++) {
			if(!arr[i]) {
				for(int j=i*i;j<=10000;j+=i) {
					arr[j] = true;
				}
			}
		}
	}

}
