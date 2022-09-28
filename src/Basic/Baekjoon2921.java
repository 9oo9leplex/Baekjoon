package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2921 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += (3 * i + n) * (n - i + 1) / 2;
        }
        System.out.print(sum);
    }
}
