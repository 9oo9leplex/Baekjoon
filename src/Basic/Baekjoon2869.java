package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2869 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		v -= a;
		if(v%(a-b) != 0)
			System.out.println(v/(a-b)+2);
		else
			System.out.println(v/(a-b)+1);
		/*
		while(v > 0) {
			v += (b-a);
			i++;
		}
		System.out.println(i);
		*/
	}

}
