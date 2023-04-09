package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_SWTEST_5650_핀볼게임 {

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int N;
	static int score;
	static int[][] ball;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim().trim());
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine().trim().trim());
			map = new int[N][N];
			score = 0;
			ball = new int[5][4];
			for (int i = 0; i < 5; i++) {
				Arrays.fill(ball[i], -1);
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 5) {
						// 여기서 이제 웜홀 처리를 해준다.
						if (ball[map[i][j] - 6][0] == -1) {
							ball[map[i][j] - 6][0] = i;
							ball[map[i][j] - 6][1] = j;
						} else {
							ball[map[i][j] - 6][2] = i;
							ball[map[i][j] - 6][3] = j;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0)
						continue;
					for (int d = 0; d < 4; d++) {

						int x = i;
						int y = j;
						int dir = d;
						int mid = 0;// 점수 체크
						while (true) {
							x += dx[dir];
							y += dy[dir];
							// 시작지점에서 다음 칸으로 이동
							if (!inRange(x, y)) {
								mid++;
								dir = (dir + 2) % 4;
								continue;
							}
							if (map[x][y] == -1 || (x == i && y == j)) {
								if (mid > score) {
									score = mid;
								}
								break;
							}
							if (map[x][y] > 5) {
								// 웜홀이라면?
								int idx = map[x][y] - 6;
								if (ball[idx][0] == x && ball[idx][1]==y) {
									x = ball[idx][2];
									y = ball[idx][3];
									
								} else {
									x = ball[idx][0];
									y = ball[idx][1];

								}
								continue;
							} else if(map[x][y]==0){
							continue;
							}
							else {
//								if(map[x][y]<1||map[x][y]>6) System.out.println(map[x][y]);
								mid++;
								dir = change_dir(dir, map[x][y]);
							}

						}
					}

				}
			}

			System.out.println("#" + t + " " + score);

		}
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static int change_dir(int dir, int block) {
		switch (block) {
		case 1:
			if (dir == 0) {
				return 1;
			} else if (dir == 3) {
				return 2;
			} else {
				return (dir + 2) % 4;
			}
		case 2:
			if (dir == 2) {
				return 1;
			} else if (dir == 3) {
				return 0;
			} else {
				return (dir + 2) % 4;
			}
		case 3:
			if (dir == 1) {
				return 0;
			} else if (dir == 2) {
				return 3;
			} else {
				return (dir + 2) % 4;
			}

		case 4:
			if (dir == 1) {
				return 2;
			} else if (dir == 0) {
				return 3;
			} else {
				return (dir + 2) % 4;
			}
		case 5:
			return (dir + 2) % 4;
		}

		return -1;
	}
}
