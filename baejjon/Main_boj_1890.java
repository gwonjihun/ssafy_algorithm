package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 풀이 방식
 dfs로 접근하여서 풀게된다면? 
 */
public class Main_boj_1890 {
	static int[] dx = {0,1}, dy = {1,0};
	static int n;
	static int[][] arr;
	static long[][] cnt;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		cnt = new long[n][n];
		
		for(long[] col : cnt) {
			Arrays.fill(col, -1);
		}
		for(int i = 0 ; i  <n ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j<n ;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		solve(0,0);
		System.out.println(cnt[0][0]);
	}
	public static long solve(int x, int y) {
		if(x==n-1 && y==n-1) {
			return 1;
		}
		if(cnt[x][y] == -1) {
			//첫 방문인 경우
			{
				cnt[x][y]=0;
				for(int d=  0 ; d<2;d++) {
					int nx = x + dx[d]*arr[x][y];
					int ny = y + dy[d]*arr[x][y];
					
					if(0<=nx&&nx<n&&0<=ny&&ny<n) {
						cnt[x][y]+=solve(nx,ny);
					}
				}
			}
		}
		return cnt[x][y];
	}
}
