package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_2667_서울_20반_권지훈 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1},dy= {1,-1,0,0};
	static int cnt =1;
	static int N;
	static ArrayList<Integer> a = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i<N;i++) {
			String t = br.readLine();
			for(int j = 0; j< N ; j++) {
				map[i][j] = (int)t.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j< N ; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					dfs(i,j,1);
					cnt+=1;
				}
			}
		}
		a.sort((o1,o2)-> Integer.compare(o1, o2));
		System.out.println(a.toString());
		System.out.println();
	}
	
	static void dfs(int r, int c,int r_cnt) {
		for(int i = 0 ; i<4;i++) {
			int nx = r+dx[i];
			int ny = r+dy[i];
			if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny] && map[nx][ny]!=0) {
				map[nx][ny]=cnt;
				visited[nx][ny] = true;
				dfs(nx, ny, r_cnt+1);
			}
		}
		
		
		
		a.set(cnt, Math.max(a.get(cnt),r_cnt));
		
	}
}

