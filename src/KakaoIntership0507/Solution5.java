package KakaoIntership0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 정확성 통과, 효율성 2/9
public class Solution5 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		int[] tmp;
        int val, r = 0, c = 0;
        int row = map.length - 1;
        int col = map[0].length - 1;
        int rotateCnt = 0, shiftCnt = 0;
        int firstR = (row+1) * (col-1) - 1;
        String[] operations = br.readLine().split(" ");
        String ex= operations[0];
        List<String> op = new ArrayList<>();

        for (String operation : operations) {
//          System.out.println("[ex,op]: ["+ex+","+operation+"]");
            if(ex.equals(operation)) {
                if(ex.equals("Rotate")) {
                    ++rotateCnt;
                    if(firstR+1 == rotateCnt) rotateCnt = 1;
                }
                else {
                    shiftCnt++;
                    if(row+1 == shiftCnt) shiftCnt = 1;
                }
            } else {
                if(ex.equals("Rotate")) {
                    for(int i=0;i<rotateCnt;i++) op.add(ex);
                    rotateCnt = 0;
                    shiftCnt++;
                } else {
                    for(int i=0;i<shiftCnt;i++) op.add(ex);
                    shiftCnt = 0;
                    rotateCnt++;
                }
                ex = operation;
            }
//          System.out.println(op);
        }
//      System.out.println("[r,s]: ["+rotateCnt+","+shiftCnt+"]");

        if(rotateCnt != 0) {
            for(int i=0;i<rotateCnt;i++) op.add("Rotate");
        } else {
            for(int i=0;i<shiftCnt;i++) op.add("ShiftRow");
        }

        for (String operation : op) {
            if (operation.equals("Rotate")) {
                val = map[0][0];

                for (int i = 0; i < row; i++)
                    map[i][0] = map[i + 1][0];
                for (int i = 0; i < col; i++)
                    map[row][i] = map[row][i + 1];
                for (int i = 0; i < row; i++)
                    map[row - i][col] = map[row - i - 1][col];
                for (int i = 0; i < col - 1; i++)
                    map[0][col - i] = map[0][col - 1 - i];
                map[0][1] = val;

            } else {
                tmp = map[row].clone();
                for (int i = row - 1; i >= 0; i--) {
                    map[i + 1] = map[i];
                }
                map[0] = tmp;
            }
//          for(int i=0;i<n;i++) System.out.println(Arrays.toString(map[i]));
//          System.out.println();
        }
	}
}
