package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_SWTEST_방범서비스 {

	static int[] dx = { 0, 1, -1, 0 }, dy = { 1, 0, 0, -1 };
	static int[][] map;
	static int N, M;
	static int cnt;// cost가 0이 아닐때 최대 cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			cnt =0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

	static void bfs(int x, int y) {
		boolean[][] v = new boolean[N][N];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		v[x][y]= true;
		int k = 1;
		int temp = map[x][y];
		if (temp * M >= cal(k)) {
			cnt = Math.max(cnt, k);
		}
		while (!q.isEmpty()) {
			int size = q.size();
			k++;
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(!inRange(nx,ny)|| v[nx][ny]) continue;
					if (map[nx][ny] == 1) {
						temp++;
					}
					q.add(new int[] {nx,ny});
					v[nx][ny]=true;
				}
			}
			if (temp * M >= cal(k)) {
				cnt = Math.max(cnt, temp);
			}
		}
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
	static int cal(int k) {
		return 2 * k * k - 2 * k + 1;
	}
}
