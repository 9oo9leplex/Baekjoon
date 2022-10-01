package codingTest.programmers.devmatching.Day221001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		String[] registered_list = {"card", "card13", "card114", "card16", "banker", "ace17", "ace14"};	
//		String[] registered_list = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};	
//		String[] registered_list = {"bird99", "bird98", "bird101", "gotoxy"};	
		String[] registered_list = {"apple1", "orange", "banana3"};	
		String new_id = "apple";
		String tmp = "";
		String num = "";
		
		for(char c : new_id.toCharArray()) {
			if(c - '0' >= 0 && c - '0' <= 9) num += c;
			else tmp += c;
		}
		
		Arrays.sort(registered_list);
		
		
		int cnt = 1;
		String next = tmp;
		if(!"".equals(num)) {
			cnt = Integer.parseInt(num);
			next += cnt++;
		}
//		
		Queue<String> q = new LinkedList<String>();
		int len = tmp.length();
		for(String cur : registered_list) {
			if(cur.length() < len) continue;
			if(cur.substring(0, len).equals(tmp)) q.add(cur);
			
			if(cur.equals(next)) {
				next = tmp + cnt++; 
			}
		}
		
		while(true) {
			if(!q.contains(next)) break;
			
			next = tmp + cnt++;
		}
		
		
		System.out.println(next);
		
//		while(true) {
//			if(!q.contains(next)) break;
//			
//			next = tmp + cnt++;
//		}
//		System.out.println(next);
		
	}

}
