package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16973 {
	
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	static int N,M;
	static int[][] board;
	static boolean[][] visited;
	static int H,W,stx,sty, ex,ey;
//	static int minMv = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		board =  new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N;i++) {
			st  = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		stx = Integer.parseInt(st.nextToken())-1;
		sty = Integer.parseInt(st.nextToken())-1;
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
	
		bfs(stx,sty);
		System.out.println();
	}
	static void bfs(int sx,int sy) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {sx,sy,0});
		visited[sx][sy]= true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] ==ex && cur[1] == ey) {
				System.out.println(cur[2]);
				return;
			}
			for(int d = 0 ; d< 4 ; d++) {
				int nx = cur[0]+ dx[d];
				int ny = cur[1] + dy[d];
//				if(nx <0 || ny <0 || nx>N ||ny>M || nx+H>N||ny+W>M) continue;
//				System.out.println(nx + " " + ny + " :  " + (nx+H-1)+" "+(ny+W-1));
				if(inRange(nx,ny) &&!visited[nx][ny]&&isMove(nx, ny)) {
//				if( isMove(nx, ny)&&!visited[nx][ny]) {

					visited[nx][ny] = true;
					q.add(new int[] {nx,ny,cur[2]+1});
				}
			}
		}
		System.out.println(-1);
	}
	
	static boolean inRange(int sx,int sy) {
		return (0<=sx&&sx+H-1<N)&&(0<=sy&&sy+W-1<M);
	}
//	static boolean inRange(int sx,int sy) {
//		return (0<=sx&&sx<N)&&(0<=sy&&sy<M);
//	}
	
	static boolean isMove(int x,int y) {
		for(int i = x ; i <x+H;i++) {
			for(int j =  y ; j< y+W;j++) {
//				System.out.println("check: " + i + " " + j + " board : " + board[i][j]);
				
				if(board[i][j]==1)
					return false;
					
			}
		}
		return true;
	}
}
