package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2230_수고르기 {

	static int[] arr;
	static int n ,m;
	static int ans =Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		  int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        int[] arr = new int[N];
	        for (int i = 0; i < N; i++) {
	            arr[i] = Integer.parseInt(br.readLine());
	        }
	        Arrays.sort(arr);
	 
	        int i = 0, j = 0;
	        int ans = Integer.MAX_VALUE;
	        // 투 포인터 알고리즘
	        while (i < N) {
	            if (arr[i] - arr[j] < M) {
	                i++;
	                continue;
	            }
	 
	            if (arr[i] - arr[j] == M) {
	                ans = M;
	                break;
	            }
	 
	            ans = Math.min(ans, arr[i] - arr[j]);
	            j++;
	        }
	        
	        System.out.println(ans);
	}
}
