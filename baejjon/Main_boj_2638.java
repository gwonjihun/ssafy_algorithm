package gwonjihun.baejjon;

import java.awt.Image;
import java.io.*;
import java.util.*;

//1.bfs를 통해서 오염된 공기 부분은 -1로 temp배열을 만들어준다.
//2.2중 포문을 통해서 전체 공간을 탐색하면서 치즈인데 사방중에 -1인곳이 2곳 이상이면 0으로 만들어준다.
//
public class Main_boj_2638 {
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] map, temp;
	static int n, m;
	static int time = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			if (check_chees()) {
				break;
			}
			check_air();
			melting();
			time++;
		}
		System.out.println(time);
	}

	static void melting() {
		temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1) {
					temp[i][j] = 0;
				} else if (map[i][j] == 1) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (map[nx][ny] == -1) {
							cnt++;
						}
					}
					if (cnt >= 2) {
						temp[i][j] = 0;
					} else {
						temp[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = temp[i][j];
			}
		}

	}
	
	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	static void check_air() {
		boolean[][] v = new boolean[n][m];
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { 0, 0 });
		v[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = -1;
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (inRange(nx, ny) &&!v[nx][ny]&& map[nx][ny] == 0) {
					q.add(new int[] { nx, ny });
					v[nx][ny] = true;
				}
			}
		}

	}

	static boolean check_chees() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
