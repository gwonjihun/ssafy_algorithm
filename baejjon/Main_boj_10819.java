package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_10819 {
	static int[] arr;
	static int N;
	static boolean[] visited;
	static int[] perms;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		arr = new int[N];
		perms = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		
		System.out.println(max);
		
	}
	private static void perm(int depth) {
		if(depth==N) {
			int temp =0;
			for(int i = 0 ; i < N-1;i++) {
				temp += Math.abs(perms[i]-perms[i+1]);
			}
			max = Math.max(temp, max);
			return;
		}
		for(int i = 0 ; i < N ;i++) {
			if(visited[i]) continue;
			perms[depth] = arr[i];
			visited[i]= true;
			perm(depth+1);
			visited[i]= false;
			
		}
	}
}
