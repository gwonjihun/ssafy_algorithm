package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1463_aga {
	/*
	 초기에는 dp 1,2에 대한 해당 값을 주었지만 
	 사실상 for문을 통해서 2부터 진행하더라도 최종적으로 init 값을 주지 않아도 되어서 조금더 현명한
	 개발 과정이 될 수 있다.
	 */

	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 int[] dp = new int[1000001];
		 
		 for(int i = 2;i<=N;i++) {
			 dp[i] = dp[i-1]+1;
			 if(i%3==0) {
				 dp[i] = Math.min(dp[i],dp[i/3]+1);
			 }
			 if(i%2==0) {
				 dp[i] = Math.min(dp[i],dp[i/2]+1);
			 }
			  
		 }
		 
		 System.out.println(dp[N]);
	
	}
}
