package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1926 {
	static int[] dx = {0,0,1,-1}, dy= {1,-1,0,0};
	static int n, m;
	static int cnt = Integer.MIN_VALUE;//그림의 넓이를 의미,
	static int[][] arr;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		v = new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0;j<m;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
//		for(int[] a : arr) {
////			System.out.println(Arrays.toString(a));
//		}
		int kinds =0;
		for(int i = 0 ; i < n;i++) {
			for(int j = 0 ; j < m ; j ++) {
				if(!v[i][j]&&arr[i][j]==1) {
					bfs(i,j);
					kinds++;
				}
			}
		}
		System.out.println(kinds);
		System.out.println(cnt);
		
	}
	
	static void bfs(int i,int j) {
		int temp =0;//사각형의 넓이를 개산하기 위한것
		Deque<int[]> q = new ArrayDeque<int[]>();//x,y,cnt값
		q.offer(new int[] {i,j});
		temp = 1;
		v[i][j]=true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d=0; d<4;d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if(0<=nx && nx<n && 0<=ny && ny<m && arr[nx][ny]==1 && !v[nx][ny]) {
					q.add(new int[] {nx,ny});
					temp++;
					v[nx][ny]=true;
				}
			}
		}
//		System.out.println("temp : " + temp + " i , j" + i + " " + j);
		if(temp > cnt) cnt= temp;
	}

}
