package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution_SW_1289_D3_원재의메모리복구_연창모 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tc = Integer.parseInt(sc.nextLine());
		StringBuilder sb = new StringBuilder();
		
		for(int j=0;j<tc;j++) {
			String line = sc.nextLine();
			char[] arr = line.toCharArray();
			
			int result = 0;
			if(arr[0]=='1') result++;
			for(int i=0;i<line.length()-1;i++) {
				if(arr[i] != arr[i+1]) result++;
			}
			sb.append("#").append(j+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
			
	}

}
