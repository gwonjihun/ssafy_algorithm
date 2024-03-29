package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1937 {

	static int[][] dp;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	static int n;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0 ; i <n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j<n;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				}
		}
		int ans = 0;
		for(int i =0; i<n;i++) {
			for(int j=0; j<n;j++) {

				ans = Math.max(ans, dfs(i,j));
			}
		}
		
		System.out.println(ans);
	}
	static int dfs(int x,int y) {
		if(dp[x][y]!=0) return dp[x][y];
		dp[x][y]=1;
		
		for(int i = 0 ; i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0&& nx<n &&ny>=0&& ny<n&& map[x][y]<map[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
			}
		}
		return dp[x][y];
	}
}
