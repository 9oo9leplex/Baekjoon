package codingTest.kakao.Day220924;

public class Problem6 {
/*
 * 테케 통과, 31 불통과, 시간초과
import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        int r,c;
        String route;

        public Node(int r, int c, String route) {
			super();
			this.r = r;
			this.c = c;
			this.route = route;
		}

        @Override
		public int compareTo(Node o) {
			
            if(this.route.length() == o.route.length()){
                for(int i=0, len = this.route.length(); i < len; i++){
                    if((this.route.charAt(i) - 'a') == (o.route.charAt(i) - 'a')) continue;
                    return (this.route.charAt(i) - 'a') - (o.route.charAt(i) - 'a');
                }
            }
            return this.route.length() - o.route.length();
		}
    }

    // static int dr[] = {-1,0,1,0};
    // static int dc[] = {0,1,0,-1};
    static int dr[] = {1,0,0,-1};
    static int dc[] = {0,-1,1,0};
    static char dir[] = {'d','l','r','u'};
    static String result = "";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        // String answer = bfs(n,m,x-1,y-1,r-1,c-1,k);
        dfs(n,m,x-1,y-1,r-1,c-1,k,"");
        return result.equals("") ? "impossible" : result;
    }

    private static void dfs(int n, int m, int x, int y, int r, int c, int k, String word) {

        if(Math.abs(x - r) + Math.abs(y - c) > k - word.length()) return;
        if(word.length() == k){
            if(x == r && y == c) result = word;
            return;
        }

        int nr,nc;

        for(int i=0;i<4;i++){
            nr = x + dr[i];
            nc = y + dc[i];

            if(inArea(n,m,nr,nc)){
                dfs(n,m,nr,nc,r,c,k,word+dir[i]);
                if(!result.isBlank()) return;
            }
        }
    }

    private static String bfs(int n, int m, int x, int y, int r, int c, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x,y,""));

        Node cur;
        int nr,nc;

        while(!pq.isEmpty()){
            cur = pq.poll();
            // System.out.println("[r,c,route]: ["+cur.r+","+cur.c+","+cur.route+"]");
            if(Math.abs(cur.r - r) + Math.abs(cur.c - c) > k - cur.route.length()) continue;
            if(cur.route.length() == k){
                if(cur.r == r && cur.c == c) return cur.route;
                continue;
            }

            for(int i=0;i<4;i++){
                nr = cur.r + dr[i];
                nc = cur.c + dc[i];

                if(inArea(n,m,nr,nc) && cur.route.length() < k){
                    pq.offer(new Node(nr,nc,cur.route+dir[i]));
                }
            }
        }
        return "impossible";
    }

    private static boolean inArea(int n, int m, int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }
}
 */
}
