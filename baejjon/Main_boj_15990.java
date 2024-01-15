package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_15990 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3 ; i<100001;i++) {
			dp[i] = (dp[i-1]+dp[i-2] + dp[i-3])%1_000_000_009;
		}
		for(int t= 0 ; t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
