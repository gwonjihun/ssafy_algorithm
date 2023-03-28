package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_4963_서울_20반_권지훈 {
	static int w, h;
	static int[][] arr;
	static int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0 }, dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}
			arr = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int c = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1) {
						bfs(i, j);
						c++;
					}
				}
			}
			System.out.println(c);
		}
	}

	static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			arr[xy[0]][xy[1]] = 0;
			for (int i = 0; i < 8; i++) {
				int nx = xy[0] + dx[i];
				int ny = xy[1] + dy[i];
				if (0 <= nx && nx < h && 0 <= ny && ny < w && arr[nx][ny] == 1) {
					q.offer(new int[] { nx, ny });
					arr[nx][ny] = 0;
				}
			}
		}
	}
}
