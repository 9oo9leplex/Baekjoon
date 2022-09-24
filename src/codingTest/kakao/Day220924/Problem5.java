package codingTest.kakao.Day220924;


public class Problem5 {

/*
import java.util.*;

class Solution {

    static class Node {
        int r,c;

        public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
    }

    public String[] solution(String[] commands) {

        String[][] map = new String[50][50];
        for(int i=0;i<50;i++) Arrays.fill(map[i],"");

        String[] com;
        int r,c,len,r1,r2,c1,c2;
        String word,g1,g2;
        HashMap<String, Queue<Node>> hm = new HashMap<>();
        Node node;
        Queue<Node> q = new LinkedList<>();
        Queue<String> group = new LinkedList<>();
        Queue<String> sb = new LinkedList<>();

        for(String command : commands){
            com = command.split(" ");
            
            switch(com[0]){
                case "UPDATE":
                    // 길이 == 4, 단어 등록
                    if(com.length == 4) {
                        r = Integer.parseInt(com[1]) - 1;        
                        c = Integer.parseInt(com[2]) - 1;
                        map[r][c] = com[3];
                        if(!hm.containsKey(com[3])) hm.put(com[3], new LinkedList<>());
		                hm.get(com[3]).add(new Node(r, c));
                    }
                    // 길이 == 3, 단어 변경
                    else {
                        if(!hm.containsKey(com[2])) hm.put(com[2], new LinkedList<>());
                        for(Node cur : hm.get(com[1])) {
                            map[cur.r][cur.c] = com[2];
                            hm.get(com[2]).add(new Node(cur.r, cur.c));
                        }
                        // 기존 키 그룹 제거
                        hm.remove(com[1]);
                    }
                    break;
                case "MERGE":
                    r1 = Integer.parseInt(com[1]);
                    c1 = Integer.parseInt(com[2]);
                    r2 = Integer.parseInt(com[3]);
                    c2 = Integer.parseInt(com[4]);
                    // 둘 다 값이 있다면 r1,c1 값으로 합침
                    if(map[r1][c1].isBlank() && map[r2][c2].isBlank()){
                    // 둘 다 값이 있다면 r2,c2 큐 찾아서 제거
                        q = hm.get(map[r2][c2]);
                        len = q.size();
                        for(int i=0;i<len;i++) {
                            // r2,c2 를 기존 큐에서 제거
                            node = q.poll();
                            if(node.r == r2 && node.c == c2) break;
                            q.add(node);
                        }
                        // r1,c1 큐에 r2,c2 추가
                        hm.get(map[r1][c1]).add(new Node(r2,c2));
                        // 그룹핑 정보 확인
                        len = group.size();
                        for(int i=0;i<len;i++){
                            word = group.poll();
                            if(word.contains(r1+","+c1)) break;
                            group.add(word);
                        }
                        
                    }
                    // 하나만 값있다면 그 값으로
                    else if(!map[r1][c1].isBlank()){
                        // r1,c1 큐에 추가
                        hm.get(map[r1][c1]).add(new Node(r2,c2));
                    }
                    else if(!map[r2][c2].isBlank()){
                        // r2,c2 큐에 추가
                        hm.get(map[r2][c2]).add(new Node(r1,c1));
                        // 그룹핑 방법은 ???
                        // map 으로 해도 key는 뭘로?
                    }
                    break;
                case "UNMERGE":
                    break;
                case "PRINT":
                    r = Integer.parseInt(com[1]);
                    c = Integer.parseInt(com[1]);
                    sb.add(map[r][c]);
                    break;
            }
        }
        len = sb.size();
        String[] answer = new String[len];

        for(int i=0;i<len;i++) answer[i] = sb.poll();

        return answer;
    }
}
 */
}
