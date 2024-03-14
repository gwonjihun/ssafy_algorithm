package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_15683 {
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };
	static int n, m;
	static int[][][] cctvdir = { { { 0 }, { 1 }, { 2 }, { 3 } }, // 1

			{ { 0, 2 }, { 1, 3 } }, // 2
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, // 3
			{ { 0, 1, 2 }, { 1, 2, 3 }, { 0, 3, 2 }, { 0, 1, 3 } }, // 4
			{ { 0, 1, 2, 3 } } };
	static int[][] arr;
	static List<int[]> cctv;
	static int k;//
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = 0;
		cctv = new ArrayList<int[]>();
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (0 < arr[i][j] && arr[i][j] < 6) {
					cctv.add(new int[] { i, j, arr[i][j] - 1 });
				}
			}
		}
		k = cctv.size();
		dfs(0);
		System.out.println(min);
	}

	static int cnts() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					cnt += 1;
				}
			}
		}
		return cnt;
	}

	static void dfs(int depth) {
		if (min == 0)
			return;
		// 사각지대의 최소크기가 이미 0이되버리면 조기 중단 시킨다.
		if (depth == k) {
			// 여기서는 이제
			min = Math.min(min, cnts());
			return;
		}
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		int[] cur = cctv.get(depth);
		// i,j, cctv num을 가지고 오잖아.
		int x = cur[0];
		int y = cur[1];
		int[][] dirs = cctvdir[cur[2]];
		for (int[] dir : dirs) {
			for (int d : dir) {
				int sx = x;
				int sy = y;
				while (true) {
					int nx = sx + dx[d];
					int ny = sy + dy[d];
					if (!(0 <= nx && nx < n && 0 <= ny && ny < m) || arr[nx][ny] == 6) {
						break;
					}
//					if(&&arr[nx][ny]<6) {
					arr[nx][ny] = -1;
					sx = nx;
					sy = ny;
//					}
				}
			}

			dfs(depth + 1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = temp[i][j];
				}
			}

		}
	}
}
