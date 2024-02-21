package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_각자리수의합 {
	static int N;
	static int M = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			int m = i;
			int sum = i;
			while (m > 0) {
				sum += m % 10;
				m /= 10;
			}
			// System.out.println(sum);
			if (sum == N) {
				M = i;
				break;
			}
		}

		System.out.println(M == Integer.MAX_VALUE ? 0 : M);
	}
}