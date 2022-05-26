package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		int block = Integer.parseInt(br.readLine());
//		int com = Integer.parseInt(br.readLine());
		int tmp;
		for(int i=0;i<n - 1;i++) {
			tmp = Integer.parseInt(br.readLine());
			if(block == tmp) cnt++;
			else if(block < tmp) {
				block = tmp;
				cnt = 1;
			}
			System.out.println("[cnt,block]: ["+cnt+","+block+"]");
		}
		System.out.println(cnt+" "+block);
	}

}
