package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_swea_3282_서울_20반_권지훈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][k + 1];// n번까지 조회했을떄 k가 가능한 최대값
		int[][] obj = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			obj[i][0] = Integer.parseInt(st.nextToken()); // 부피
			obj[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				// 최대 부피를 설정
				if (obj[i][0] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - obj[i][0]] + obj[i][1]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
