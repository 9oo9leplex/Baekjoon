package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3029 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),":");
		
		int sh = Integer.parseInt(st.nextToken());
		int sm = Integer.parseInt(st.nextToken());
		int ss = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(),":");
		int eh = Integer.parseInt(st.nextToken());
		int em = Integer.parseInt(st.nextToken());
		int es = Integer.parseInt(st.nextToken());
		
		if(es < ss) {
			es += 60;
			em--;
		}
		es -= ss;
		
		if(em < sm) {
			em += 60;
			eh--;
		}
		em -= sm;
		if(sh > eh) eh += 24;
		eh -= sh;
		String result= "";
		if(eh < 10) result += "0";
		result += eh+":";
		if(em < 10) result += "0";
		result += em+":";
		if(es < 10) result += "0";
		result += es;
		System.out.println(result);

		

	}

}
