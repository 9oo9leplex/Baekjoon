package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759 {

	static StringBuilder sb = new StringBuilder();
	static int N,K;
	static String[] tmp,r;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		r = new String[N];
		tmp = br.readLine().split(" ");
		Arrays.sort(tmp);
			
		sol(0,0,0,0);
		System.out.println(sb.toString());
	}

	private static void sol(int cnt, int index, int moeum, int jaeum) {
		
		if(N == cnt) {
			if(moeum >= 1 && jaeum >= 2) {
				for(int i=0;i<N;i++)
					sb.append(r[i]);
				sb.append("\n");
			}
			return;
		}
		
		for(int i=index;i<K;i++) {
			r[cnt] = tmp[i];
			switch(r[cnt]) {
			case "a":
			case "e":
			case "i":
			case "o":
			case "u":
				sol(cnt+1,i+1,moeum+1,jaeum);
				break;
			default:
				sol(cnt+1,i+1,moeum,jaeum+1);
				break;
			}
		}
	}

}
