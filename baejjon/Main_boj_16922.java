package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16922 {

	static boolean[] v;
	static int N;
	static int[] arr = {1,5,10,50};
	static int cnt;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = 0;
		N = Integer.parseInt(br.readLine());
		v = new boolean[1001];
		dfs(0,0,0);
		System.out.println(cnt);
	}
	
	static void dfs(int depth,int idx,int sum) {
		if(depth == N) {
			if(!v[sum]) {
				cnt++;
				v[sum]= true;
			}
			return;
		}
		
		for(int i = idx;i<4;i++) {
			dfs(depth+1, i,sum+arr[i]);
		}
	}
}
