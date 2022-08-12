package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10886 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] vote = new int[2];
		for(int i=0;i<n;i++) {
			vote[Integer.parseInt(br.readLine())]++;
		}
		System.out.println(vote[0] > vote[1] ? "Junhee is not cute!" : "Junhee is cute!");
}
}
