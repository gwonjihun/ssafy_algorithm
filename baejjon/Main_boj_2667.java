package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2667 {

	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static PriorityQueue<Integer> cnts;
	static int[][] map;
	static int N;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cnts = new PriorityQueue<>();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j<N; j++) {
				if(map[i][j]==0 || visited[i][j]) continue;
				int x = dfs(i,j,1);
				cnts.add(x);
			}
		}
		System.out.println(cnts.size());
		while(!cnts.isEmpty()) {
			System.out.println(cnts.poll());
		}
		
	}
	
	static int dfs(int x,int y,int sum) {
		visited[x][y]= true;
		for(int d = 0 ; d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0<=nx&&nx<N&&0<=ny&&ny<N&&map[nx][ny]==1&&!visited[nx][ny]) {
				sum+=dfs(nx,ny,1);
			}
		}
		return sum;
	}
}
