package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class main_boj_11660 {
	static int[][] arr, dp;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {

				dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] - dp[i][j] + arr[i+1][j+1];
			}
		}
		for(int i = 0; i<k;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			sb.append(dp[sx-1][sy-1]+dp[ex][ey] - dp[sx-1][ey]-dp[ex][sy-1]).append("\n");
			
		}
		
		System.out.println(sb);
	}
}
