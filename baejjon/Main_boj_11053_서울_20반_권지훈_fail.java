package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_11053_?Ñú?ö∏_20Î∞?_Í∂åÏ??õà_fail {
	static int[] arr,dp;
	static int N;
	static ArrayDeque<Integer> q;
	static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new int[N];
		int ei = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==0) {
				dp[i] = 1;
				ei = 0;
				continue;
			}
			if(arr[i] > arr[ei]) {
				dp[i] = dp[ei]+1;
				ei  = i;
			}else {
				dp[i]= dp[ei];
			}
			
		}
		System.out.println(dp[N-1]);

	}
}
/* ?ûÖ?†•Î∞õÍ≥† Í∑∏Í≤å Í∑∏Ï†ÑÍ∫ºÎ≥¥?ã§ ?ûë?úºÎ©? dp+1
 * Í∑∏Î¶¨Í≥? Í∑∏Ï†ÑÍ∫? Í∞íÎ≥¥?ã§ ?Å¨Î©? dp[i-1] = dp[i]
 * Í∑∏Î†áÍ≤? ?ï¥?Ñú Ïµ?
 * */
