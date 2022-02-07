package Recursion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1873 {
	//상하 좌우 상수값 만들어 놓고 사용
	final static int UP=0, DOWN=1, LEFT=2, RIGHT=3;
	
	//상하좌우
	final static int[] dr = {-1, 1, 0, 0};
	final static int[] dc = {0, 0, -1, 1};
	
	
	static int H,W;	//격자판의 높이와 너비
	static char[][] map;	//격자판
	
	static int N;	//지령의 개수
	static char[] cmds;	//입력 지령
	
	
	static int R,C, dir;	//전차의 좌표값, 방향
	
	final static char[] mark = {'^', 'v', '<', '>'};	//마지막 좌표 찍을 때 사용하기 위해
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			//격자판 정보 입력
			map = new char[H][W];
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			//지령의 개수
			N = Integer.parseInt(br.readLine());
			//지령 입력
			cmds = br.readLine().toCharArray();
			
			//step 01. 전차 위치 탐색
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='<'||map[i][j]=='>') {
						//좌표 저장
						R = i;
						C = j;
						
						//방향 저장
						if(map[i][j]=='^') dir = UP;
						else if(map[i][j]=='v') dir = DOWN;
						else if(map[i][j]=='<') dir = LEFT;
						else if(map[i][j]=='>') dir = RIGHT;
						
						//평지로 변경
						map[i][j] = '.';
						break;
					}
				}
			}
			
			//step 02. 입력 지령 처리
			for(char cmd : cmds) {
				//shoot인 경우
				if(cmd=='S') {
					shoot();
				}
				//move인 경우
				else {
					move(cmd);
				}
			}
			
			
			//step 03. map 정보 출력
			//전차 정보 표기
//			if(dir==UP) map[R][C] = '^';
//			else if(dir==DOWN) map[R][C] = 'v';
//			else if(dir==LEFT) map[R][C] = '<';
//			else map[R][C] = '>';
			//mark 배열 사용 시
			map[R][C] = mark[dir];
			
			//출력
			sb.append("#"+tc+" ");
			for(int i=0; i<H; i++) {
				sb.append(new String(map[i])+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	//이동
	private static void move(char cmd) {
		//1. 방향전환
		if(cmd=='U') dir = UP;
		else if(cmd=='D') dir = DOWN;
		else if(cmd=='L') dir = LEFT;
		else if(cmd=='R') dir = RIGHT;
		
		//2. 이동
		//해당 방향으로 한 칸 이동했을 때의 좌표
		int nr = R + dr[dir];
		int nc = C + dc[dir];
		
		//경계 내에 있거나 평지인 경우
//		if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]=='.') {
		if(isRange(nr, nc) && map[nr][nc]=='.') {
			//실제 이동
			R = nr;
			C = nc;
		}
		
		
	}

	//포탄 발사
	private static void shoot() {
		//포탄의 위치 좌표
		int nr = R;
		int nc = C;
		
		
		//포탄이 얼마나 이동할지 모르므로 무한반복 ( 반복문 한번마다 한 칸 이동)
		while(true) {
			
			//포탄 한칸 이동
			nr+=dr[dir];
			nc+=dc[dir];
			
			//경계를 벗어나거나 강철벽을 만났을 때
			if(nr<0 || nr>=H || nc<0 || nc>=W || map[nr][nc]=='#') break;	//포탄 소멸
			
			//벽돌벽을 만난 경우
			else if(map[nr][nc]=='*') {
				map[nr][nc] = '.';	//평지 처리
				break;	//포탄 소멸
			}
			
			//조건에 걸리지 않는 경우 다음 칸으로 포탄 이동
		}
	}
	
	//경계 체크(경계 내에 있는 경우 true)
	private static boolean isRange(int nr, int nc) {
		return nr>=0 && nr<H && nc>=0 && nc<W;
	}

	
}
