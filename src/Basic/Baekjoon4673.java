package Basic;

public class Baekjoon4673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[] ck = new boolean[10001];
		
		for(int i=1;i<=10000;i++) {
			int tmp = i;
			int num = tmp;
			while(tmp > 0) {
				num += (tmp%10);
				tmp /= 10;
			}
			if(num > 10000) continue;
			ck[num] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=10000;i++) {
			if(!ck[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

}
