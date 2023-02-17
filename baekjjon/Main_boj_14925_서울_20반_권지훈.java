package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;

public class Main_boj_14925_서울_20반_권지훈 {

	
	public static void main(String[] args) throws Exception{
		int[][] arr;
		int[][] dp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i = 1 ; i<= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =1 ; j <=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for(int i = 1 ; i<= N; i++) {
			for(int j =1 ; j <=M; j++) {
				if(arr[i][j]==0) {
				dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1])+1;
				answer = Math.max(answer, dp[i][j]);
				}
			}
			
		}
		System.out.println(answer);
		
	}
}
