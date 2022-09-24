package codingTest.kakao.Day220924;

public class Problem1 {

		

}
/*
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        int[] date = new int[3];
        String[] tmp = new String[3];
        
        StringTokenizer st = new StringTokenizer(today,".");
        for(int i=0;i<3;i++) tmp[i] = st.nextToken();
        
        date[0] = Integer.parseInt(tmp[0]);
        date[1] = Integer.parseInt(tmp[1]);
        date[2] = Integer.parseInt(tmp[2]);

        HashMap<String, Integer> hm = new HashMap<>();
        for(String cur : terms){
            tmp = cur.split(" ");
            hm.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        int temp[] = new int[3];
        String[] a = new String[3];
        int m,idx = 1;
        Queue<Integer> q = new LinkedList<>();

        for(String cur : privacies){
            // 날짜와 계약 조건 분리
            st = new StringTokenizer(cur);
            for(int i=0;i<2;i++) tmp[i] = st.nextToken();
            // 날짜 분해
            st = new StringTokenizer(tmp[0],".");
            for(int i=0;i<3;i++) a[i] = st.nextToken();
            // 년도
            temp[0] = Integer.parseInt(a[0]);
            // 월
            temp[1] = Integer.parseInt(a[1]);
            // 일
            temp[2] = Integer.parseInt(a[2]);
            // 계약 기간
            m = hm.get(tmp[1]);
            // 가입 날짜 + 계약 기간
            temp[1] += m;
            // 년 변경
            if(temp[1] > 12) {
                temp[0] += temp[1]/12; 
                if(temp[1] % 12 == 0) temp[0]--;
            }
            // 월 변경
            temp[1] %= 12;
            if(temp[1] == 0) temp[1] = 12;
            // 일 변경 ( -1 )
            if(temp[2] == 1) {
                temp[2] = 28;
                temp[1]--;
                if(temp[1] == 0) {
                    temp[1] = 12;
                    temp[0]--;
                }
                // 2020.11.01, 1달 계약
                // 2020.12.01
            }
            else temp[2] -= 1;
            // 유효 기간과 비교
            if(date[0] > temp[0]) q.add(idx);
            else if(date[0] == temp[0]){
                if(date[1] > temp[1]) q.add(idx);
                else if(date[1] == temp[1]){
                    if(date[2] > temp[2]) q.add(idx);
                }
            }
            // System.out.println(today);
            // System.out.println(temp[0]+"."+temp[1]+"."+temp[2]);
            idx++;
        }
        
        int len = q.size();
        int answer[] = new int[len];
        for(int i=0;i<len;i++) answer[i] = q.poll();

        return answer;
    }
}
*/
