package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_10026_서울_20반_권지훈_dfs {
	static char[][] map;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int cnt = 0, cnt_j = 0, N;
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
				if (!v[i][j]) {
					dfs(i, j, map[i][j]);
					cnt++;
				}
				if (!v_j[i][j]) {
					dfs_j(i, j, map[i][j]);
					cnt_j++;
				}
			}
		}
		System.out.println(cnt + " " + cnt_j);

	}

	static void dfs(int x, int y, char s) {
		v[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny] && map[nx][ny] == s ) {

				v[nx][ny] = true;
				dfs(nx, ny, s);
			}
		}
	}

	static void dfs_j(int x, int y, char s) {
		v_j[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (0 <= nx && nx < N && 0 <= ny && ny < N && !v_j[nx][ny]) {
				if (s == 'B') {
					if (map[nx][ny] == s) {
						v_j[nx][ny] = true;
						dfs_j(nx, ny, s);
					}
				}else 
				{
					if (map[nx][ny] != 'B') {
						v_j[nx][ny] = true;
						dfs_j(nx, ny, s);
					}
				}
			}
		}
	}

}
