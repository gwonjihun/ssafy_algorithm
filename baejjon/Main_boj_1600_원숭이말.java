package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_boj_1600_원숭이말 {
	static int[] dx = { 0, 1, -1, 0, -1, -2, -2, -1, 1, 2, 2, 1 }, dy = { 1, 0, 0, -1, -2, -1, 1, 2, 2, 1, -1, -2 };// 값은
																													// 다
																													// 맞아
//	0~3ㅏㄲ지는 그냥 이용하고 
//	4이상부터는 k의 값을 확인하고 사용한다.
	static int[][] map;
	static boolean[][][] vis;
	static int k, w, h, cnt = Integer.MAX_VALUE;

	static boolean inRange(int x, int y) {
		return 0 <= x && x < h && 0 <= y && y < w;
		// true면 배열 내부
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		vis = new boolean[h][w][k + 1];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(cnt == Integer.MAX_VALUE ? -1 : cnt);
	}

	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 0, 0 });// x,y,말움직임 횟수,이동횟수
		vis[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
//			System.out.println(Arrays.toString(cur));
			if (cur[0] == h - 1 && cur[1] == w - 1) {
//				System.out.println("!@#!@#!@#");
				cnt = Math.min(cnt, cur[3]);
			}

			for (int i = 0; i < 4; i++) {
//				System.out.println(i);

				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (!inRange(nx, ny) || vis[nx][ny][cur[2]]) {
					continue;

				}
				if (map[nx][ny] == 0) {
					q.add(new int[] { nx, ny, cur[2], cur[3] + 1 });
					vis[nx][ny][cur[2]] = true;

				}

			}
			if(cur[2]<k) {
			for (int i = 4; i < 12; i++) {
//				System.out.println(i);

				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (!inRange(nx, ny) || vis[nx][ny][cur[2] + 1]) {
					continue;

				}
				if (map[nx][ny] == 0) {
					q.add(new int[] { nx, ny, cur[2]+1, cur[3] + 1 });
					vis[nx][ny][cur[2]+1] = true;

				}
			}
			}
		}
	}
}
/*
 * 반례
 * 
 * 1 4 4 0 0 0 0 0 0 0 0 0 0 1 1 0 0 1 0
 * 
 * 답 : 4
 * 
 * 2 2 6 0 1 1 1 1 0 1 1 0 1 0 0
 */