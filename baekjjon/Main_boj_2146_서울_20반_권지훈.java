package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_2146_서울_20반_권지훈 {

	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static boolean[][] v;
	static int N;
	static int[][] tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		tmp = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int land = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j]) {
					continue;
				}
				// 섬마다
				if (!v[i][j] && map[i][j] != 0) {
					bfs(i, j, land);
					land += 1;
				}
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0) continue;
				boolean flag = false;
				for(int d = 0; d<4;d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					if(0 <= nx && nx < N && 0 <= ny && ny < N&& map[nx][ny]==0) {
						flag =true;
					}
				}
				
				if(flag) {
//					System.out.println("i : "+i+ "j : " + j);
					dfs(i,j, new boolean[N][N], 0,map[i][j]);
				}
			}
		}
		
		

		System.out.println(min);

	}
	static void dfs(int x, int y, boolean[][] b, int cnt, int start) {
		
		if(min<=cnt) return;

		b[x][y]=true;
		for(int d = 0; d<4;d++) {
			
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(0 <= nx && nx < N && 0 <= ny && ny < N && !b[nx][ny]) {
				
				if(map[nx][ny] == 0 ) {

					dfs(nx,ny,b,cnt+1,start);
					
				}else if(map[nx][ny]!=start) {
					
					min = Math.min(min, cnt);
				}


				b[nx][ny] = false;	
			}
		}
		b[x][y]=false;
	}
	static void bfs(int x, int y, int land) {
		Deque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			map[xy[0]][xy[1]] = land;
			for (int d = 0; d < 4; d++) {
				int nx = xy[0] + dx[d];
				int ny = xy[1] + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (!v[nx][ny] && map[nx][ny] == 1) {
						v[nx][ny] = true;
						q.addLast(new int[] { nx, ny });
					}
				}
			}

		}
	}
}
