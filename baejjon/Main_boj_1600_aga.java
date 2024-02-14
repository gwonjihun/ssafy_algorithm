package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1600_aga {

	static int K;
	static int W, H;
	static int[][] board;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int[] dxj = { -2, -2, -1, -1, 1, 1, 2, 2 }, dyj = { -1, 1, -2, 2, 2, -2, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		System.out.println(bfs(0, 0));
	}

	static int bfs(int x, int y) {
		int min = Integer.MAX_VALUE;
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { x, y, 0, 0 });
		boolean[][][] visited = new boolean[K + 1][H][W];
		visited[0][x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == H - 1 && cur[1] == W - 1) {
				min = Math.min(min, cur[3]);
				continue;
			}
			if (cur[2] < K) {
				for (int d = 0; d < 8; d++) {
					int nx = cur[0] + dxj[d];
					int ny = cur[1] + dyj[d];
					if (!inRange(nx, ny) || visited[cur[2]+1][nx][ny] || board[nx][ny] == 1) {
						continue;
					}

					q.add(new int[] { nx, ny, cur[2] + 1, cur[3] + 1 });
					visited[cur[2] + 1][nx][ny] = true;
				}
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (inRange(nx, ny) && !visited[cur[2]][nx][ny] && board[nx][ny] != 1) {

					q.add(new int[] { nx, ny, cur[2], cur[3] + 1 });
					visited[cur[2]][nx][ny] = true;
				}
			}
		}
		return min==Integer.MAX_VALUE? -1 : min;

	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
}
