package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon20005 {

	static int N,M;
	static char[][] map;
	static class Player {
		int r,c,hp;
		char ch;

		public Player(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Player(int r, int c, char ch) {
			super();
			this.r = r;
			this.c = c;
			this.ch = ch;
		}
		
		public void setHp(int hp) {
			this.hp = hp;
		}

		public char getCh() {
			return ch;
		}

		public void setCh(char ch) {
			this.ch = ch;
		}

		@Override
		public String toString() {
			return "Player [r=" + r + ", c=" + c + ", hp=" + hp + ", ch=" + ch + "]";
		}
	}
	
	static boolean[][][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		Queue<Player> q = new LinkedList<>();
		char[] tmp;
		Player boss = null;
		
		visit = new boolean[N][M][P];
		
		for (int i = 0; i < N; i++) {
			
			tmp = br.readLine().toCharArray();
			
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j];
				if(map[i][j] >= 'a' && map[i][j] <= 'z') {
					q.add(new Player(i, j,map[i][j]));
					visit[i][j][map[i][j] - 'a'] = true;
				}
				else if(map[i][j] == 'B') boss = new Player(i, j);
			}
		}
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine());
			hm.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
		}
		
		int hp = Integer.parseInt(br.readLine());
		boss.setHp(hp);
			
		System.out.println(bfs(q,boss,hm));
		
	}
	
	private static int bfs(Queue<Player> q, Player boss, HashMap<Character, Integer> hm) {

		Player cur;
		int nr,nc, totalDamage = 0, len;
		Queue<Character> player = new LinkedList<>();
		
		while(boss.hp > 0) {
			
			len = q.size();
			
			for(int a=0;a<len;a++) {
				
				cur = q.poll();
//				System.out.println(cur);
				if(player.contains(cur.ch)) continue;
				if(boss.r == cur.r && boss.c == cur.c) {
					totalDamage += hm.get(cur.ch);
					player.add(cur.ch);
					continue;
				}
				
				for(int i=0;i<4;i++) {
					
					nr = cur.r + dr[i];
					nc = cur.c + dc[i];
					
					if(inArea(nr,nc) && !visit[nr][nc][cur.ch - 'a'] && map[nr][nc] != 'X') {
						q.add(new Player(nr, nc, cur.ch));
						visit[nr][nc][cur.ch-'a'] = true;
					}
				}
			}
			
			boss.hp -= totalDamage;
//			System.out.println(player);
//			System.out.println(boss.hp);
		}
		return player.size();
		
	}
	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
