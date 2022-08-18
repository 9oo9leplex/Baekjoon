package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int n = Integer.parseInt(br.readLine());
			int r,e,f;
			
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();
			String s = "";
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				r = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				f = Integer.parseInt(st.nextToken());
				
				if(r < e-f) s = "advertise";
				else if(r == e-f) s = "does not matter";
				else s = "do not advertise";
				sb.append(s).append("\n");
			}
			System.out.println(sb);
	}
}














