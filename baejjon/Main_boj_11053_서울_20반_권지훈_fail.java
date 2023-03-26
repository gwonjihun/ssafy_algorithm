package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_11053_?��?��_20�?_권�??��_fail {
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
/* ?��?��받고 그게 그전꺼보?�� ?��?���? dp+1
 * 그리�? 그전�? 값보?�� ?���? dp[i-1] = dp[i]
 * 그렇�? ?��?�� �?
 * */
