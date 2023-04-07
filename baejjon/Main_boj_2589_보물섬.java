package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2589_보물섬 {
	static int n, m, max = 0;
	static char[][] graph;
	static int[] dx= {0,0,1,-1}, dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new char[n][m];
		for (int i = 0; i < n; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j]=='L')
				{
					bfs(i,j);
				}
			}
		}
		System.out.println(max);
	}
	static void bfs(int x, int y) {
		boolean[][] v = new boolean[n][m];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y,0});
		v[x][y] =true;
		while(!q.isEmpty()) {
			int[] cur =q.poll();
			for(int d = 0 ; d<4 ;d++) {
				int nx = cur[0]+ dx[d];
				int ny = cur[1]+ dy[d];
				if(inRange(nx,ny)&&!v[nx][ny]&&graph[nx][ny]=='L') {
					v[nx][ny]=true;
					q.add(new int[] {nx,ny, cur[2]+1});
					if((cur[2]+1)>max) {
						max = cur[2]+1;
					}
				}
			}
		}
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<m;
	}
}
