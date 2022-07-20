package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5596 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int s = 0, t = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<4;i++) s += Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) t += Integer.parseInt(st.nextToken());
		
		System.out.println(s >= t ? s : t);
		
	}
}
