package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_1965 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0 ;
		for(int i = 0 ; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);
	}
}
