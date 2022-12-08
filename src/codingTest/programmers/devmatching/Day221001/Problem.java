package codingTest.programmers.devmatching.Day221001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Problem {
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static boolean[][] visit;
	static int r,c;
	static class Node implements Comparable<Node>{
		int r,c;
		char word;
		public Node(int r, int c, char word) {
			super();
			this.r = r;
			this.c = c;
			this.word = word;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
	
	}
	static Queue<Node> q;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		String[] maps = {"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A", "....EE..", ".M.XXEXQ", "KL.TBBBQ"};
		String[] maps = {"XY..", "YX..", "..YX", ".AXY"};
		r = maps.length;
		c = maps[0].length();
		
		visit = new boolean[r][c];
		
		HashMap<String,Integer> hm = new HashMap<>();
		List<Map.Entry<String, Integer>> entry = new ArrayList<>(hm.entrySet());
		
		entry.sort(new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		
		System.out.println(bfs(maps));
	}

	private static int bfs(String[] maps) {
		
		char cur, maxchar;
		int nr,nc,max;
		Node node;
		
		HashMap<Character, Integer> hm = new HashMap<>();
		HashMap<Character, Integer> result = new HashMap<>();
		q = new LinkedList<>();

		List<Map.Entry<Character, Integer>> entries;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {

				cur = maps[i].charAt(j);
				if(cur == '.' || visit[i][j]) continue;
				
				hm.clear();
				hm.put(cur, 1);
				q.add(new Node(i, j, cur));
				visit[i][j] = true;
//				max = 1;
//				maxchar = cur;
				
				while(!q.isEmpty()) {
					
					node = q.poll();
					
					for(int k=0;k<4;k++) {
						
						nr = node.r + dr[k];
						nc = node.c + dc[k];
						
						if(inArea(nr,nc) && !visit[nr][nc] && maps[nr].charAt(nc) != '.') {
							if(!hm.containsKey(maps[nr].charAt(nc))) hm.put(maps[nr].charAt(nc), 0);
							hm.put(maps[nr].charAt(nc) , hm.get(maps[nr].charAt(nc)) + 1);

							visit[nr][nc] = true;
							q.add(new Node(nr, nc, node.word));
						}
					}
				}
				
				if(hm.keySet().size() == 1) {
//					System.out.println("here");
					if(!result.containsKey(cur)) result.put(cur, 0);
					result.put(cur, result.get(cur) + hm.get(cur));
				}
				
				else {
					entries = new ArrayList<>(hm.entrySet());
//					entries.sort((v1,v2) -> v2.getValue() - v1.getValue());
					
					entries.sort(new Comparator<Map.Entry<Character, Integer>>() {
						@Override
						public int compare(Map.Entry<Character, Integer> o1,Map.Entry<Character, Integer> o2) {
							if(o1.getValue() == o2.getValue()) return o2.getKey() - o1.getKey();
							return o2.getValue() - o1.getValue();
						}
					});
					
					max = entries.get(0).getValue();
					maxchar = entries.get(0).getKey();
//					System.out.println(maxchar+","+max);
//					System.out.println();
					for(Map.Entry<Character, Integer> entry : entries) {
//						System.out.println(maxchar+","+max+","+entry.getKey()+","+entry.getValue());
						if(max == entry.getValue()) {
//							if(maxchar < entry.getKey()) {
//								maxchar = entry.getKey();
//							}
							if(!result.containsKey(entry.getKey())) result.put(entry.getKey(), 0);
							result.put(entry.getKey(), result.get(entry.getKey()) + entry.getValue());
							continue;
						}
						if(!result.containsKey(maxchar)) result.put(maxchar, max);
//						System.out.println(result.get(maxchar) +","+ entry.getKey()+","+entry.getValue());
						result.put(maxchar, result.get(maxchar) + entry.getValue());
//						hm.put(maps[nr].charAt(nc) , hm.get(maps[nr].charAt(nc)) + 1);
					}
				}
				
				System.out.println("result: "+result);
			}
		}
		
		entries = new ArrayList<>(result.entrySet());
//		entries.sort((v1,v2) -> v2.getValue() - v1.getValue());
		
		entries.sort(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1,Map.Entry<Character, Integer> o2) {
				if(o1.getValue() == o2.getValue()) return o2.getKey() - o1.getKey();
				return o2.getValue() - o1.getValue();
			}
		});
		
		for(Map.Entry<Character, Integer> aa : entries) System.out.println(aa.getKey()+","+aa.getValue());
		
		return entries.get(0).getValue();
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}

}
