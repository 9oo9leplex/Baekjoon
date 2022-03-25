package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		int[] chuchun = new int[101];
		LinkedList<Integer> q = new LinkedList<>();
		
		
		int num,min,tmp;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=p;i++) {
			num = Integer.parseInt(st.nextToken());
			if(!q.contains(num)) q.add(num);
			chuchun[num]++;
			
			if(q.size() > n ) {
				min = chuchun[q.get(0)];
				tmp=0;
				for(int j=1;j<n-1;j++) {
					if(chuchun[q.get(j)] < min) {
						min = q.get(j);
						tmp = j;
					}
				}
				chuchun[q.remove(tmp)] = 0;
			}
//			System.out.println(Arrays.toString(chuchun));
		}
		Collections.sort(q);
		StringBuilder sb = new StringBuilder();
		for(int a : q)
			sb.append(a).append(" ");
		System.out.println(sb);
	}

	
}
