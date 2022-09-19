package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10409 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int cur;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			cur = Integer.parseInt(st.nextToken());
			if(t < cur) break;
			cnt++;
			t -= cur;
		}
		System.out.println(cnt);
	}
}
