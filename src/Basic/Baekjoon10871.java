package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10871 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int tmp;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			tmp = Integer.parseInt(st.nextToken());
			if(t > tmp) sb.append(tmp).append(" ");
		}
		System.out.println(sb);
		
	}

}
