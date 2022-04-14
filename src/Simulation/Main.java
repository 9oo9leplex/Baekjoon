package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] king = st.nextToken().toCharArray();
		char[] rock = st.nextToken().toCharArray();
		int n = Integer.parseInt(st.nextToken());
		
		int kc = king[0] - 'A';
		int kr = king[1] - '1';
		int rc = rock[0] - 'A';
		int rr = rock[1] - '1';
		
		System.out.println(kc+", "+kr);
		System.out.println(rc+", "+rr);
		
		for(int i=0;i<n;i++) {
			String move = br.readLine();
			switch(move) {
			case "R":
				if(!inArea(kr,kc+1)) continue;
				if((kr==rr && kc+1 == rc)) {
					if(inArea(rr,rc+1)) rc++;
					else continue;
				}
				kc++;
				break;
			case "L":
				if(!inArea(kr,kc-1)) continue;
				if((kr==rr && kc-1 == rc)) {
					if(inArea(rr,rc-1)) rc--;
					else continue;
				}
				kc--;
				break;
			case "B":
				if(!inArea(kr-1,kc)) continue;
				if((kr-1==rr && kc == rc)) {
					if(inArea(rr-1,rc)) rr--;
					else continue;
				}
				kr--;
				break;
			case "T":
				if(!inArea(kr+1,kc)) continue;
				if((kr+1==rr && kc == rc)) {
					if(inArea(rr+1,rc)) rr++;
					else continue;
				}
				kr++;
				break;
			case "RT":
				if(!inArea(kr-1,kc+1)) continue;
				if((kr-1==rr && kc+1 == rc)) {
					if(inArea(rr-1,rc+1)) {
						rr--;
						rc++;
					}
					else continue;
				}
				kr--;
				kc++;
				break;
			case "LT":
				if(!inArea(kr-1,kc-1)) continue;
				if((kr-1==rr && kc-1 == rc)) {
					if(inArea(rr-1,rc-1)) {
						rr--;
						rc--;
					}
					else continue;
				}
				kr--;
				kc--;
				break;
			case "RB":
				if(!inArea(kr+1,kc+1)) continue;
				if((kr+1==rr && kc+1 == rc)) {
					if(inArea(rr+1,rc+1)) {
						rr++;
						rc++;
					}
					else continue;
				}
				kr++;
				kc++;
				break;
			case "LB":
				if(!inArea(kr+1,kc-1)) continue;
				if((kr+1==rr && kc-1 == rc)) {
					if(inArea(rr+1,rc-1)) {
						rr++;
						rc--;
					}
					else continue;
				}
				kr++;
				kc--;
				break;
			}
		}
		System.out.println(kc + ", "+kr);
		System.out.println(rc + ", "+rr);
		
	}

	private static boolean inArea(int kr, int kc) {
		return kr >= 0 && kr < 8 && kc >= 0 && kc < 8;
	}
}







