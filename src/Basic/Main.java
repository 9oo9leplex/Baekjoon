package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			int[] arr = new int[3];
			int same, result = 0, max = 0;
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				same = 0;
				
				for(int j=0;j<3;j++) {
					arr[j] = Integer.parseInt(st.nextToken());
				}
				
				if(arr[0] == arr[1]) same++;
				if(arr[2] == arr[1]) same++;
				if(arr[0] == arr[2]) same++;
				
				
				if(same == 3) {
					result = 10000 + arr[0] * 1000;
				}
				else if(same == 1) {
					Arrays.sort(arr);
					result = 1000 + arr[1] * 100;
				}
				else {
					Arrays.sort(arr);
					result = 100 * arr[2];
				}
				
				max = Math.max(max, result);
//				System.out.println(Arrays.toString(arr));
//				System.out.println("[same,result,max]: ["+same+","+result+","+max+"]");
			}
			System.out.println(max);
			
	}
}














