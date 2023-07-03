package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_5427 {
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static char[][] map;
	static int N, M;
	static int sx, sy;
	static Deque<int[]> q;//
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			result = Integer.MAX_VALUE;
			q = new ArrayDeque<int[]>();
			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = tmp[j];
					if (map[i][j] == '*') {
						q.add(new int[] { i, j, 0 });
					} else if (map[i][j] == '@') {
						sx = i;
						sy = j;
					}
				}
			}
			bfs(sx, sy);
			System.out.println(result == -1 ? "IMPOSSIBLE" : result);
		}
	}

	static void bfs(int x, int y) {
		Deque<int[]> person = new ArrayDeque<int[]>();
		person.add(new int[] { x, y, 0 });
		while (!person.isEmpty()) {
			for (int i = 0, end = q.size(); i < end; i++) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if (0 <= nx && nx < N && 0 <= ny && ny < M && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
						map[nx][ny] = '*';
						q.add(new int[] { nx, ny, cur[2] + 1 });
					}
				}
			}
			for (int i = 0, end = person.size(); i < end; i++) {
				int[] cur = person.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
						result = cur[2] + 1;
						return;
					}
					if (map[nx][ny] == '.') {
						map[nx][ny] = '@';
						person.add(new int[] { nx, ny, cur[2] + 1 });

					}
				}
			}
		}
		result = -1;
	}
}
