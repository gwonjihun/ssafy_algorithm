package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17266 {
	static int[] lemp;
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		lemp = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i ++ ) {
			lemp[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1;
		int right = N;
		int result = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			if(possible(mid)) {
				result = mid;
				right = mid -1;
			}
			else
				left = mid +1;
		}
		System.out.println(result);
	}
	static boolean possible(int target) {
		int prev = 0 ; 
		for(int i = 0 ; i < M;i++) {
			if(lemp[i]-target<=prev) {
				prev =lemp[i] + target;
			}else{return false;}
		}
		return N - prev<=0;
	}
}
