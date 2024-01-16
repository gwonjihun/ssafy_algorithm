package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_10844 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int MODULE = 1_000_000_000;
		int[][] dp = new int[10][101];
		for(int i = 1 ; i < 10;i++) {
			dp[i][1] = 1;
		}
		for(int i= 2;i<=N;i++) {
			for(int j = 0;j<10;j++) {
				if(j==0) {
					dp[0][i] += dp[1][i-1]%MODULE;
				}else if(j==9) {
					dp[9][i] += dp[8][i-1]%MODULE;
				}else {
					dp[j][i] = (dp[j-1][i-1]+dp[j+1][i-1])%MODULE;
				}
			}
		}
		
		int sum = 0;
		for(int i=0;i<10;i++) {
			sum = (sum+ dp[i][N])%MODULE;
		}
		System.out.println(sum);
	}

}
