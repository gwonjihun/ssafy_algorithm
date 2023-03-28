package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2291_동전2 {
	static int[] cnt, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		cnt = new int[n];
		int k = Integer.parseInt(st.nextToken());
		dp = new int[k+1];
		Arrays.fill(dp, 200000);
		dp[0]=0;
		for(int i=0;i<n;i++) {
			cnt[i] = Integer.parseInt(br.readLine());
			if(cnt[i]<=k) {
			dp[cnt[i]] = 1;
			}
		}
		for(int i = 0 ; i<=k;i++) {
			
			for(int j=0;j<n;j++) {
				if(i+cnt[j]<=k)
				dp[i+cnt[j]] = Math.min(dp[i]+1, dp[i+cnt[j]]);
			}
		}
		System.out.println(dp[k]==200000? -1 :dp[k] );
	}
}
