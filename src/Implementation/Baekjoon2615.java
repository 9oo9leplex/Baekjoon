package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2615 {

	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Queue<int[]> q = new LinkedList<>();
		int[][] map = new int[19][19];
		int tmp;
		
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp != 0) q.add(new int[] {i,j});
			}
		}
		
		int result,nr,nc;
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			tmp = map[a[0]][a[1]];
			
			for(int i=0;i<8;i++) {
				result = 0;
				nr = a[0] + dr[i] * 5;
				nc = a[1] + dc[i] * 5;
				if(inArea(nr, nc) && tmp == map[nr][nc]) continue;
				
				nr = a[0] - dr[i];
				nc = a[1] - dc[i];
				if(inArea(nr, nc) && tmp == map[nr][nc]) continue;
				
				for(int j=1;j<=4;j++) {
					nr = a[0] + dr[i]*j;
					nc = a[1] + dc[i]*j;
					if(inArea(nr, nc) && tmp == map[nr][nc]) result++;
					else break;
				}
				
				if(result == 4) {
					sb.append(tmp).append("\n");
					if(i==0 || i==6 || i==7)
						sb.append(a[0]+dr[i]*4+1).append(" ").append(a[1]+dc[i]*4+1);
					else
						sb.append(a[0]+1).append(" ").append(a[1]+1);
					
					
					System.out.println(sb);
					return;
				}
			}
		}
		System.out.println(0);
	}

	private static boolean inArea(int nr, int nc) {
		return nr >= 0 && nr < 19 && nc >= 0 && nc < 19;
	}
}
