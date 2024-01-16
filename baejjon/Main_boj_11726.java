package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_11726 {

	public static void main(String[] args) throws Exception{
		int[] dp = new int[1001];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3;i<=N;i++) {
			dp[i] = (dp[i-2]+dp[i-1])%10007;
		}
		System.out.println(dp[N]);
	}
}
