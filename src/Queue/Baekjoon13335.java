package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon13335 {
public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		
		LinkedList<Integer> queue = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		
		for(int i=0;i<l;i++)
			bridge.add(0);
		
		while(st.hasMoreTokens()) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		int onBridge = 0;
		while(!bridge.isEmpty()) {
			result++;
			int now = bridge.poll();
			onBridge -= now;
			
			if(!queue.isEmpty()) {
				if(onBridge+queue.peek() <= w) {
					int go = queue.poll();
					bridge.add(go);
					onBridge += go;
				}
				else
					bridge.add(0);
			}
		}
		System.out.println(result);
	}
}
