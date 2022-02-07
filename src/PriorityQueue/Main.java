package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int first = Integer.parseInt(br.readLine());
		int second = Integer.parseInt(br.readLine());
		
		if(first > 0 && second > 0) System.out.println(1);
		else if(first < 0 && second > 0) System.out.println(2);
		else if(first < 0 && second < 0) System.out.println(3);
		else System.out.println(4);
	}

}
