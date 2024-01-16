package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_6603 {
	static int[] nums;
//	static boolean[] visited;
	static int[] arr;
	static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			if(N==0) break;
			
			nums = new int[6];
//			visited = new boolean[N];
			arr = new int[N];
			
			for(int i = 0 ; i <N ; i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			perm(0,0);
			System.out.println();
		}
		
	}
	
	static void perm(int idx,int depth) {
		if(depth==6) {
			for(int a : nums) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		for(int i = idx ; i <N;i++) {
//			if(visited[i])continue;
//			visited[i]=true;
			nums[depth] = arr[i];
			perm(i+1,depth+1);
//			visited[i]=false;
		}
	}
}
