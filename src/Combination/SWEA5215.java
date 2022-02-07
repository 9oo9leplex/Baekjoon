package Combination;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215 {

	static int info[][], numbers[], max, c, size, tmp, result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0;i<tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			
			result = 0;
			
			info = new int[c][2];
			
			for(int j=0;j<c;j++) {
				st = new StringTokenizer(br.readLine());
				info[j][0] = Integer.parseInt(st.nextToken());
				info[j][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=1;j<=c;j++) {
				size = j;
				numbers = new int[j];
				combination(0,0);
			}
			
			sb.append("#").append(i+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void combination(int cnt, int start) {
		
		if(cnt == size) {
			int total = 0;
			for(int i=0;i<numbers.length;i++) {
				total += info[numbers[i]][1];
			}
			if(total <= max) {
				tmp = 0;
				for(int i=0;i<numbers.length;i++)
					tmp += info[numbers[i]][0];
				result = result < tmp ? tmp : result;
			}
			
			return;
		}
		
		for(int i=start;i<info.length;i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}
