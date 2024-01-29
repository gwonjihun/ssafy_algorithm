package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14503_aga {

	static int n, m;
	static int[][] map;// N*M 지도
	static int sx, sy, dir;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int cnt;// 청소한 횟수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		while (true) {
			// 청소를한다.
			if (map[sx][sy] == 0) {
				map[sx][sy] = 2;
				cnt++;
			}
			if (cleanCheck(sx, sy)) {
				// 청소가 안된 곳이기 없다
				int nx = sx - dx[dir];
				int ny = sy - dy[dir];
				if(map[nx][ny]==1) break;
				sx = nx;
				sy = ny;
			} else {
				// 청소될 칸이 있다.
				// 여기서 dir을 위해서 4개의 방향을 탐구해서 4개의 방향 중 순서에 맞춰서
				int d = dir;
				while(true) {
					d = (d+3)%4;
					int nx = sx + dx[d];
					int ny = sy + dy[d];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						continue;
					}
					if (map[nx][ny] == 0) {
						sx = nx;
						sy = ny;
						dir = d;
						break;
					}
				}
			}

		}
		System.out.println(cnt);

	}

	static boolean cleanCheck(int x, int y) {

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			if (map[nx][ny] == 0) {
				return false;
			}
		}
		return true;
	}
}
