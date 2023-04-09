package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_1949_등산로조성_dfs_bfs {

	static class node {
		int x, y;

		node(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int[][] map;
	static int n, K, result;
	static List<node> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			K = Integer.parseInt(st.nextToken());
			int Max = 1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (Max < map[i][j]) {
						Max = map[i][j];
					}
				}
			}
			result = 0;
			list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == Max) {
						list.add(new node(i, j));
					}
				}
			}
			for(int k = 1;k<=K;k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if(map[i][j]-k<0) {
							continue;
						}else {
							map[i][j]-=k;
						}
						for(int idx = 0 ;idx<list.size();idx++) {
//							dfs(list.get(idx).x,list.get(idx).y,1);
							bfs(list.get(idx).x,list.get(idx).y,1);
						}
						map[i][j]+=k;
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	static void dfs(int x,int y,int count) {
		if(count>result) {
			result = count;
		}
		for(int d =0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=nx&&nx<n&&0<=ny&&ny<n&&map[x][y]>map[nx][ny]) {
				dfs(nx,ny,count+1);
			}
		}
	}
	static void bfs(int x,int y,int count) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y,count});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[2]>result) {
				result = cur[2];
			}
			for(int d = 0 ;d <4; d++) {
				int nx = cur[0]+dx[d];
				int ny = cur[1]+dy[d];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&map[cur[0]][cur[1]]>map[nx][ny]) {
					q.add(new int[] {nx,ny,cur[2]+1});
				}
			}
		}
	}
}

/*10
5 1
9 3 2 3 2 
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8*/