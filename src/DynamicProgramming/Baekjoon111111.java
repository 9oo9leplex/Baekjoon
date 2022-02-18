package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon111111 {

	static int N;
	static long[] dp;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1];
		dp[1] = 1;
		if(N >= 2)
			dp[2] = 2;
		
		sol();
		System.out.println(dp[N]);
	}
	
	static void sol() {
		
		for(int i=3;i<=N;i++)
			dp[i] = (dp[i-1]%15746 + dp[i-2]%15746)%15746;
	}
}
