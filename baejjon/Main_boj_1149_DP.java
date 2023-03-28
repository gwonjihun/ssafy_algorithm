package gwonjihun.baejjon;
import java.io.*;
import java.util.*;

public class Main_boj_1149_DP {
	static int[][] map,dp;
	static int n;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		dp = new int[n][3];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j =0;j<3;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<3;i++) {
			dp[0][i] = map[0][i];
		}
		for(int i=1;i<n;i++) {
			dp[i][0]= Math.min(dp[i-1][1],dp[i-1][2])+map[i][0];
			dp[i][1]= Math.min(dp[i-1][0],dp[i-1][2])+map[i][1];
			dp[i][2]= Math.min(dp[i-1][1],dp[i-1][0])+map[i][2];
					
		}
		
		System.out.println(Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]));
	}
}
