package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14501_BRFS {
	static int N ;
	static int[] day,cost;
//	static boolean[] visited;
	static int maxCost = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
//		visited = new boolean[N];
		day = new int[N];
		cost = new int[N];
		
		for(int i = 0;i<N ;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0,0,0);
		System.out.println(maxCost);
		
	}
	static void perm(int days,int sum,int lastcost) {
		if(days>N) {
			maxCost = Math.max(maxCost, sum-lastcost);
			return;
		}
		else if(days==N) {
			maxCost = Math.max(maxCost, sum);
			return;
		}
		
		for(int i = days;i<N;i++) {
			
			perm(i+day[i],sum+cost[i],cost[i]);
		}
	}
}
