package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10824 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken() + st.nextToken();
		String str2 = st.nextToken() + st.nextToken();
		
		Long result = Long.parseLong(str1) + Long.parseLong(str2);
		System.out.println(result);
}
}
