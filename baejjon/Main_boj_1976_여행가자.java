package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1976_여행가자 {
	static int[][] map;
	static int[] plan;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		plan = new int[m];
		for(int i = 1 ; i <= n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <m ; i++) {
			plan[i]= Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i<m-1;i++) {
			if(bfs(plan[i],plan[i+1])) {
				if(i==m-2) {
					System.out.println("YES");
				}
				continue;
			}else {
				System.out.println("NO");
				break;
			}

		}
	}
	
	static boolean bfs(int x,int  y) {
		boolean[] v = new boolean[n+1];
		Deque<Integer> q = new ArrayDeque<>();
		q.add(x);
		v[x] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur==y) return true;
			for(int i = 1 ; i<=n;i++) {
				if(v[i]) continue;
				if(map[cur][i]==1) {
//					System.out.println(cur + "->" + i);
//					if(i==y) return true;
					v[i]= true;
					q.add(i);
				}
				
			}
		}
		return false;
		
	}
}
