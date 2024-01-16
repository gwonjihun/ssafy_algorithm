package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
/*
 4
 1 5 6 7
 * */
public class Main_boj_11052 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <=N;i++) {
			dp[i] = 1000000001;
		}
		for(int i = 1 ; i  <= N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		for(int i = 1 ; i <= N;i++) {
			for(int j = 1 ; j<=i;j++) {
				dp[i] = Math.min(dp[i], (dp[i-j]==1000000001?  0: dp[i-j])+arr[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
