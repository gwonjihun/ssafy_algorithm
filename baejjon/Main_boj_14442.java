package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14442 {

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int N, M, K;
	static int[][] arr;
	static boolean[][][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp[j]-'0';
			}
		}

		int cnt = dfs(0, 0, 0);

		System.out.println(cnt);

	}

	static int dfs(int x, int y, int k) {
		v = new boolean[K+1][N][M];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y, k, 1 });
		v[k][x][y] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			if (cur[0] == N - 1 && cur[1] == M - 1) {
//				System.out.println("여기 안오냐?");
				return cur[3];
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
//				System.out.println(nx + " " + ny);
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
//					System.out.println("!!");
//					System.out.println(arr[nx][ny]);
					if (arr[nx][ny] == 0 && !v[cur[2]][nx][ny]) {
						q.add(new int[] { nx, ny, cur[2], cur[3] + 1 });

						v[cur[2]][nx][ny] = true;
						
//						System.out.println("!!!!");
					} else if (arr[nx][ny] == 1 && cur[2] < K && !v[cur[2] + 1][nx][ny]) {
						q.add(new int[] { nx, ny, cur[2] + 1, cur[3] + 1 });
						v[cur[2] + 1][nx][ny] = true;
					}
				}

			}

		}

		return -1;
	}
}
