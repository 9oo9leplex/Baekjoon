package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			StringTokenizer st;
			
			for(int i=0;i<3;i++) {
				st = new StringTokenizer(br.readLine());
				
				int sh = Integer.parseInt(st.nextToken());
				int sm = Integer.parseInt(st.nextToken());
				int ss = Integer.parseInt(st.nextToken());
				
//				st = new StringTokenizer(br.readLine());
				int eh = Integer.parseInt(st.nextToken());
				int em = Integer.parseInt(st.nextToken());
				int es = Integer.parseInt(st.nextToken());
				
				if(ss > es) {
					em--;
					es += 60 - ss;
				} else es -= ss;
				if(sm > em) {
					eh--;
					em += 60 - sm;
				} else em -= sm;
				sb.append(eh - sh).append(" ").append(em).append(" ").append(es).append("\n");
			}
			System.out.println(sb);
		
	}

}














