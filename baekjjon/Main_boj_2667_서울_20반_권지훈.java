package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_2667_서울_20반_권지훈 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1},dy= {1,-1,0,0};
	static int cnt;
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

		cnt = 0;
		for(int i = 0; i<N;i++) {
			for(int j = 0; j< N ; j++) {
				
				if(map[i][j]==1 && !visited[i][j]) {
					cnt = 1;
					dfs(i,j);
					a.add(cnt);
				}
			}
		}
		Collections.sort(a);
		System.out.println(a.size());
		for(int s : a) System.out.println(s);
		System.out.println();
	}
	
	static int dfs(int i,int j) {
		visited[i][j]= true;
		for(int d = 0; d<4 ; d++) {
			int nx = i + dx[d], ny = j+ dy[d];
			if ( 0<=nx && nx< N && 0<=ny && ny< N && !visited[nx][ny] && map[nx][ny] == 1 ) {
				
				dfs(nx,ny);
				cnt++;
			}
		}
		return cnt;

	
	}

}

