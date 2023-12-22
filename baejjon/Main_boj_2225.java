package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2225 {

	static int[][] dp;
	
	static int N,K;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		
		for(int i=0;i<=N;i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;
			
		}
		for(int i = 0 ; i <=K;i++) {
			dp[1][i]= i;
		}
		for(int i = 2;i<=N;i++) {
			for(int j = 2;j<=K;j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1_000_000_000;
			}
		}
		System.out.println(dp[N][K]);
	}
	
}
