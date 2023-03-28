package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_10026_서울_20반_권지훈_bfs {
	static char[][] map;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	static int cnt=0, cnt_j=0, N;
	static boolean[][] v, v_j;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		v = new boolean[N][N];
		v_j = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j]) {
				bfs(i,j,map[i][j]);
				cnt++;
				}
				if(!v_j[i][j]) {
					bfs_j(i,j,map[i][j]);
					cnt_j++;
				}
//				bfs(i,j,map[i][j]);
			}
		}
		System.out.println(cnt+" "+cnt_j);
		
	}
	
	static void bfs(int x, int y,char s) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		v[x][y] = true;
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			for(int d = 0 ; d<4; d++) {
				int nx = xy[0]+ dx[d];
				int ny = xy[1] + dy[d];
				
				if(0<= nx && nx<N && 0<= ny && ny <N && !v[nx][ny] && map[x][y]==map[nx][ny]) {
					
					v[nx][ny]= true;
					q.add(new int[] {nx, ny});
				}
				
			}
		}
	}
	static void bfs_j(int x, int y,char s) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		v_j[x][y] = true;
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			for(int d = 0 ; d<4; d++) {
				int nx = xy[0]+ dx[d];
				int ny = xy[1] + dy[d];
				
				if(0<= nx && nx<N && 0<= ny && ny <N && !v_j[nx][ny] ) {
					
					if(s=='B') {
						if(map[x][y]==map[nx][ny]) {
					v_j[nx][ny]= true;
					q.add(new int[] {nx, ny});}
					}
					else {
						if(map[nx][ny]!='B') {
							v_j[nx][ny]= true;
							q.add(new int[] {nx, ny});
						}
					}
				}
				
			}
		}
	}
}
