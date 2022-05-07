package KakaoIntership0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution1 {

	static boolean[] visit;
	static int n;
	static String[] survey;
	static int choices[];
	static class Mbti {
		String type;
		int point;
		public Mbti(String type, int point) {
			super();
			this.type = type;
			this.point = point;
		}
		@Override
		public String toString() {
			return "Mbti [type=" + type + ", point=" + point + "]";
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		
		survey = new String[n];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			survey[i] = st.nextToken();
		
		st = new StringTokenizer(br.readLine());
		choices = new int[n];
		for(int i=0;i<n;i++)
			choices[i] = Integer.parseInt(st.nextToken());
		
		// a,c,f,j,m,n,r,t
		int[] val = new int[8];
		String[] arr = {"R","T","C","F","J","M","A","N"};
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('R', 0); map.put('T', 1); map.put('C', 2); map.put('F', 3);
		map.put('J', 4); map.put('M', 5); map.put('A', 6); map.put('N', 7);
		
		char[] type;
		int choice,len = choices.length, jumsu;
		for(int i=0;i<len;i++) {
			type = survey[i].toCharArray();
			choice = choices[i];
			jumsu = 0;
//			System.out.println(type);
//			System.out.println("[0,1]: ["+map.get(type[0])+","+map.get(type[1])+"]");
			
			switch(choice) {
			case 1:
				jumsu++;
			case 2:
				jumsu++;
			case 3:
				jumsu++;
				val[map.get(type[0])] += jumsu;
				break;
			case 4:
				break;
			case 7:
				jumsu++;
			case 6:
				jumsu++;
			case 5:
				jumsu++;
				val[map.get(type[1])] += jumsu;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++) {
			if(val[2*i] >= val[2*i+1]) {
				sb.append(arr[2*i]);
			}
			else sb.append(arr[2*i+1]);
		}
		
		System.out.println(sb);
		
	}
}
