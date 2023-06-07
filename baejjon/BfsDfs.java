package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class BfsDfs {
	static int[] dx = {-1,0,1,0};//?��?��?���?
	static int[] dy = {0,1,0,-1};//
	static int N=5,C=0;
	static int[][] a;
	static int temp;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception{
		a = new int[N][N];
		v = new boolean[N][N];
		
		C =1;
		bfs(N/2,N/2);
		for(int[] b:a) System.out.println(Arrays.toString(b)); System.out.println();
	}
	static void bfs(int x,int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.offer(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			x = xy[0];
			y = xy[1];
			a[x][y] = C++;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y + dy[i];
				if(0<=nx && 0<= ny && ny< N && nx<N && !v[nx][ny] ) 
				{
					v[nx][ny]= true;
					q.offer(new int[] {nx,ny});
				}		
			}
			
		}
	}
	static void dfs(int x,int y) {
		v[x][y]=true;
		a[x][y]=C++;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y + dy[i];
			if(0<=nx && 0<= ny && ny< N && nx<N && !v[nx][ny] ) 
			{
				
				dfs(nx,ny);
			}
		}
	}
}
