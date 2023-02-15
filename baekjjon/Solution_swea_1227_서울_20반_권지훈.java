package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;
public class Solution_swea_1227_서울_20반_권지훈 {
	static int[][] arr = new int[100][100];
	static int[] dx= {0,0,1,-1}, dy= {1,-1,0,0};
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int T = 1 ; T<=10 ; T++) {
			br.readLine();
			int x=0,y=0;
			for(int i = 0 ;i<100;i++)
			{
				String st = br.readLine();
				for(int j = 0; j<100;j++) {
					arr[i][j] = (int)st.charAt(j)-'0';
					if(arr[i][j]==2) {
						x= i;
						y= j;
					}
				}
			}
			answer = 0;
			bfs(x,y, new boolean[100][100]);
			sb.append("#"+T+" "+answer+"\n");
		}
		System.out.println(sb);
		
	}
	static void bfs(int x, int y,boolean[][] v) {
		Deque<int[]> a = new ArrayDeque<>();
		a.offerLast(new int[] {x,y});
		v[x][y] = true;
		while(!a.isEmpty()) {
			int[] xy = a.pollFirst();
			v[xy[0]][xy[1]]= true;
			for(int i = 0 ; i <4 ; i++)
			{
				int nx = xy[0]+dx[i];
				int ny = xy[1]+dy[i];
				if(0<=nx && nx<100 && 0<=ny && ny<100 && !v[nx][ny] && arr[nx][ny]!=1) {

					if(arr[nx][ny]==3) { answer = 1; return;}
					a.offerLast(new int[] {nx,ny});
				}
			}
		}
	}
	static void dfs(int x, int y,boolean[][] v) {
		
		v[x][y]= true;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx && nx<100 && 0<=ny && ny<100 && !v[nx][ny] && arr[nx][ny]!=1) {

				if(arr[nx][ny]==3) { answer = 1; return;}
				dfs(nx,ny,v);
			}
		}
	}
}
