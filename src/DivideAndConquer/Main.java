package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, arr[][];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sb = new StringBuilder();
		
		String[] s = new String[N];
		for(int i=0;i<N;i++) {
			s = br.readLine().split("");
			for(int j=0;j<N;j++)
				arr[i][j] = Integer.parseInt(s[j]);
		}
		
		sol(0,0,N);
		System.out.println(sb);
	}

	private static void sol(int r, int c, int len) {
		
		if(inArea(r, c, len)) {
			sb.append(arr[r][c]);
			return;
		}
		
		sb.append("(");
		int half = len/2;
		sol(r,c,half);
		sol(r,c+half,half);
		sol(r+half,c,half);
		sol(r+half,c+half,half);
		sb.append(")");
		
	}

	private static boolean inArea(int r, int c, int len) {
		
		if(r < 0 && c < 0 && r >= N && c >= N) return false;
		int tmp = arr[r][c];
		for(int i=r;i<r+len;i++) {
			for(int j=c;j<c+len;j++) {
				if(tmp != arr[i][j]) return false;
			}
		}
		
		return true;
	}

	

}
