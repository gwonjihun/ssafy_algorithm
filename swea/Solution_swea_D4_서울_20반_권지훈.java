package gwonjihun.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_D4_서울_20반_권지훈 {
	static int[][] arr;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int N;
	static int Max_c;
	static int r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int T = 1; T <= TC; T++) {

			Max_c = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			r = N * N;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

//					dfs(i,j,new boolean[N][N], 1,arr[i][j]);
					bfs(i, j, new boolean[N][N], arr[i][j]);
				}
			}
			sb.append("#").append(T).append(" " + r + " " + Max_c + "\n");
		}
		System.out.println(sb);
	}

	static void bfs(int x, int y, boolean[][] v, int start_r) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { x, y, 1 });
		while (!dq.isEmpty()) {
			int[] xy = dq.pollFirst();
			int mx = xy[0];
			int my = xy[1];
			int cnt = xy[2];
			if (cnt > Max_c) {

				Max_c = Math.max(Max_c, cnt);
				r = start_r;
			} else if (cnt == Max_c) {
				r = Math.min(r, start_r);
			}
			v[mx][my] = true;
			for (int i = 0; i < 4; i++) {
				int nx = mx + dx[i];
				int ny = my + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
					if (arr[nx][ny] - arr[mx][my] == 1) {
						dq.addLast(new int[] { nx, ny, cnt + 1 });
					
					}
				}
				
			}
		}

	}

	static void dfs(int x, int y, boolean[][] v, int cnt, int start_r) {
		v[x][y] = true;
		if (cnt > Max_c) {

			Max_c = Math.max(Max_c, cnt);
			r = start_r;
		} else if (cnt == Max_c) {
			r = Math.min(r, start_r);
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
				if (arr[nx][ny] - arr[x][y] == 1) {
					dfs(nx, ny, v, cnt + 1, start_r);
				}
			}
		}

	}
}
