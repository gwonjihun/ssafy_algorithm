package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16928 {
	
	static int cnt;
	static int[] arr;
	static int N,M;
	static int cur;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cur = 1;
		cnt = 0;
		arr = new int[101];
		cur = Integer.MAX_VALUE;
		for(int i = 0 ; i <N+M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s]= e;
		}
		bfs(0);
	}
	static void bfs(int start) {
		boolean[] visited = new boolean[101];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,1});
		//cnt,position
		visited[1] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[1]== 100) {
				System.out.println(cur[0]);
				return;
			}
			for(int i = 1 ; i < 7;i++) {
				int nx = cur[1]+i;
				if(100<nx||visited[nx]) {
					continue;
				}
				visited[nx] = true;
				if(arr[nx]!=0) {
					if(!visited[arr[nx]]) {
						visited[arr[nx]]=true;
						q.add(new int[] {cur[0]+1,arr[nx]});
					}
				}else {
					q.offer(new int[] {cur[0]+1,nx});
				}
			}
			
		}
		
	}
}
