package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D4_수영대회결승전 {

	static int map[][];
	static boolean[][] vis;
	static int n; 	
	static int sx,sy,ex,ey;
	static int mincnt;
	static int[] dx = {1,-1,0,0}, dy= {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=tc ; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			vis = new boolean[n][n];
			
			for(int i = 0; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==5)
						map[i][j]=0;
				
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
		
			st= new StringTokenizer(br.readLine()," ");
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			mincnt = Integer.MAX_VALUE;
			bfs();
			sb.append("#").append(t).append(" ").append(mincnt==Integer.MAX_VALUE? -1: mincnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx,sy,0});
		vis[sx][sy] =true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d= 0; d<4;d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(!inRange(nx, ny)) continue;
				if(nx==ex&&ny==ey) {
					if(mincnt>cur[2]+1) {
					mincnt = cur[2]+1;
					}
					return;
				}
				if(vis[nx][ny]) continue;
				if(map[nx][ny]==1) continue;
				if(map[nx][ny]==2) {
					if(cur[2]%3==2) {
						vis[nx][ny]=true;
						q.add(new int[] {nx,ny,cur[2]+1});
					}else {
						vis[cur[0]][cur[1]]=true;
						q.add(new int[] {cur[0],cur[1],cur[2]+1});
						
					}
				}else {
					vis[nx][ny]=true;
					q.add(new int[] {nx,ny,cur[2]+1});
				}
			}
		}
	}
	static boolean inRange(int x,int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
}
