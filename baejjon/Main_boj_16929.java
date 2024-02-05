package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16929 {
	
	static int N,M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static char[][] board;
	static int sx,sy;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		
		for(int i = 0 ; i <N;i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M;j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[N][M];
		for(int i = 0 ; i <N;i++) {
			for(int j = 0 ; j < M;j++) {
				sx = i;
				sy = j;
//				visited[sx][sy]= true;
				dfs(1,i,j) ;

			}
		}
		System.out.println("No");
	}
	
	static void dfs(int depth, int x,int y) {
		if(depth>=4&&x == sx &&y==sy) {
			System.out.println("Yes");
			System.exit(0);
			return ;
		}
		for(int d = 0 ;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(0>nx ||nx >=N||0>ny || ny>=M||visited[nx][ny]||board[sx][sy]!=board[nx][ny]) 
				continue;
				visited[nx][ny] =true;
					dfs(depth+1,nx,ny);
					visited[nx][ny] =false;
			
		}
	}
}
