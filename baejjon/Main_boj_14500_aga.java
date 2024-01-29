package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14500_aga {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int maxScore = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, arr[i][j]);
				find(i, j);
				visited[i][j] = false;
			}
		}
		System.out.println(maxScore);
	}

	static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			maxScore = Math.max(sum, maxScore);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
				// 격자 내부에 있는 녀석들만 dfs로 돌려준다
				visited[nx][ny] = true;
				dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}

	static void find(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int temp = arr[x][y];
			for (int j = 0; j < 4; j++) {
				if (j != i) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (0 <= nx && nx < N && 0 <= ny && ny < M) {
						temp += arr[x + dx[j]][y + dy[j]];
					} else {
						break;
					}
				}
			}
			maxScore = Math.max(temp, maxScore);
		}
	}
}
