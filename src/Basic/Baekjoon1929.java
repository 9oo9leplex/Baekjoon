package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1929 {

	static StringBuilder sb = new StringBuilder();
	static boolean[] a;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		a = new boolean[1000001];
		
		a[0] = a[1] = true;
		
		for(int i=2;i*i<=m;i++) {
			if(!a[i]) {
				for(int j=i*i;j<=m;j+=i)
					a[j] = true;
			}
		}
		
		for(int i=n;i<=m;i++) {
			if(!a[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}

}
