package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			
			int tmp = m * 2;
			int team = 0;
			if(w >= tmp) {
				team = m;
				w -= tmp;
				m = 0;
				
				tmp = w;
			}
			else {
				team = w / 2;
				m -= w / 2;
				if( w % 2 == 0) w = 1;
				else w = 0;
				
				tmp = m + w;
			}
			
			i -= tmp;
//			System.out.println("[w,m,i,team]: ["+w+","+m+","+i+","+team+"]");
			if(i <= 0) {
				System.out.println(team);
				return;
			}
			else {
				if(i%3 == 0) team -= i / 3;
				else {
					team -= i / 3;
					team--;
				}
			}
			System.out.println(team <= 0 ? 0 : team);
	}
}














