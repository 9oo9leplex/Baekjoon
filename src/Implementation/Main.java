package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp;
		for(int i=0;i<n;i++) {
			tmp = arr[i];
			for(int j=0;j<=tmp;j++) {
				if(result[j] != 0 && result[j] < i+1) tmp++;
			}
			result[tmp] = i+1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a : result) sb.append(a).append(" ");
		System.out.println(sb);
	}

}
