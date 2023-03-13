package gwonjihun.test;

import java.io.*;
import java.util.*;

class solution_2 {
	static final int[] di = {0, 1, 0, -1}, dj = {1, 0, -1, 0};
	
	static int ans;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int x = 0, y = 0;
			int[][] map = new int[N][N];
			int[][] move = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					move[i][j] = 9;
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						map[i][j] = 0;
						x = i; y = j;
					}
				}
			}
			ans = 0;
			dfs(x, y, 0, map, move, new boolean[N][N], N);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static boolean inRange(int i, int j, int N) {
		return 0 <= i && i < N && 0 <= j && j < N;
	}
	
	static void dfs(int i, int j, int cnt, int[][] map, int[][] move, boolean[][] out, int N) {
		boolean exist = (map[i][j] != 0);
		if (exist) {
			map[i][j] = 0;
			if (!out[i][j]) {
				ans++;
				out[i][j] = true;
			}
		}
		move[i][j] = cnt++;
		for (int d = 0; d < 4; d++) {
			if (cnt == 4) break;
			boolean over = false;
			for (int ni = i + di[d], nj = j + dj[d]; inRange(ni, nj, N); ni+=di[d], nj+=dj[d]) {
				if (!over && map[ni][nj] != 0) {
					over = true;
				} else if (over) {
					if (move[ni][nj] > cnt)
						dfs(ni, nj, cnt, map, move, out, N);
					if (map[ni][nj] != 0) break;
				}
			}
		}
		if (exist) map[i][j] = 1;
	}
}