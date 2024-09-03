package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class BOJ_2178_2024_bottom {

	static int[][] map;
	static boolean[][] visited;
	static int r,c;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0 ; i < r; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < c; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0,0));
	}
	
	static int bfs(int x,int y) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,1});
		
		visited[0][0]= true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d= 0 ;d <4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
			
				if(inRange(nx,ny)&&map[nx][ny]!=0&&!visited[nx][ny]) {
					q.add(new int[] {nx,ny});
					map[nx][ny]= map[cur[0]][cur[1]]+1;
					visited[nx][ny]= true;
				}
			}
		}
		
		return map[r-1][c-1];
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<r&&0<=y&&y<c;
	}
}
