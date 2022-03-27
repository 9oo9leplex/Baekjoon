package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Implementation.Main.Turtle;

public class Baekjoon8911 {

	static class Turtle{
		int x,y,dir;

		public Turtle(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int maxX, minX, maxY, minY;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Turtle t;
		for(int i=0;i<n;i++) {
			
			t = new Turtle(0,0,0);
			char[] dir = br.readLine().toCharArray();
			int result = 0; 
			maxX = minX = maxY = minY = 0;
			for(int j=0;j<dir.length;j++) {
				switch(dir[j]) {
				case 'F':
					t.x += dx[t.dir];
					t.y += dy[t.dir];
					update(t.x,t.y,t);
					break;
				case 'B':
					t.x -= dx[t.dir];
					t.y -= dy[t.dir];
					update(t.x,t.y,t);
					break;
				case 'R':
					t.dir += 1;
					t.dir %= 4;
					break;
				case 'L':
					t.dir -= 1;
					if(t.dir < 0) t.dir = 3;
					break;
				}
				
			}
			
			result = Math.abs(maxX - minX) * Math.abs(maxY - minY);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void update(int x, int y, Turtle t) {
		maxX = Math.max(maxX, t.x);
		minX = Math.min(minX, t.x);
		maxY = Math.max(maxY, t.y);
		minY = Math.min(minY, t.y);
	}
}
