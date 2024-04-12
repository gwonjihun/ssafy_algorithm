package gwonjihun.codetree;

import java.io.*;
import java.util.*;

/*
 * 1. 2L단위로 전체 배열을 먼저 분할한다
 * 2. 2(L-1)단위로 배열을 시계방향으로 한번 돌린다.-> temp배열을 활용한다.
 * 2. 빙하를 녹이는데 인접한 칸에 얼음이 3개 이상이면 녹지 않는다 -> 이것도 temp배열을 활용한다.
 * 3. 
 * 
 * 
 * */
public class Main_CodeTree_회전하는빙하_2nd {

	static int n, q;
	static int pn;
	static int[][] ice;
	static int[][] temp;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int gsize;
	static int total;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		pn = (int) Math.pow(2, n);
		gsize = 0;
		total = 0;
		q = Integer.parseInt(st.nextToken());
//		System.out.println(n + " " + q);
		ice = new int[pn][pn];
		for (int i = 0; i < pn; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < pn; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			int lev = Integer.parseInt(st.nextToken());
			moves(lev);
//			printer();
			melt();
//			printer();
		}
		v = new boolean[pn][pn];

		total();
		System.out.println(total);

		groupMax();
		System.out.println(gsize);

	}

	static boolean[][] v;

	static void total() {
		for (int i = 0; i < pn; i++) {
			for (int j = 0; j < pn; j++) {
				if (ice[i][j] > 0) {
					total += ice[i][j];
				}
			}
		}
	}

	static void groupMax() {
		for (int i = 0; i < pn; i++) {
			for (int j = 0; j < pn; j++) {
				if (!v[i][j] && ice[i][j] > 0) {
					gsize = Math.max(gsize, bfs(i, j));
				}
			}
		}

	}

	// 이걸 통해서 해당 좌표에 있는 군집 사이즈를 구한다.
	static int bfs(int x, int y) {
		int cnt = 1;
		Queue<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (inRange(nx, ny) && !v[nx][ny] && ice[nx][ny] > 0) {
					cnt += 1;
					q.add(new int[] { nx, ny });
					v[nx][ny] = true;
				}
			}
		}
		return cnt;
	}

	static void melt() {
		temp = new int[pn][pn];
		for (int i = 0; i < pn; i++) {
			for (int j = 0; j < pn; j++) {
				int cnt = 0;
				if (ice[i][j] <= 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (inRange(nx, ny) && ice[nx][ny] > 0) {
						cnt++;
					}

				}
				if (cnt < 3) {
					temp[i][j] = ice[i][j] - 1;
				} else {
					temp[i][j] = ice[i][j];
				}
			}
		}
		ice = temp;
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < pn && 0 <= y && y < pn;
	}

	static void printer() {
		System.out.println("______________");
		for (int i = 0; i < pn; i++) {
			System.out.println(Arrays.toString(ice[i]));
		}
	}

	static void moves(int level) {
		temp = new int[pn][pn];
		if (level == 0) {
//			System.out.println("0이라 조기종료");
			return;

		}
		int size = (int) Math.pow(2, level);
//		int ban = pn / size;
		for (int i = 0; i < pn; i += size) {
			for (int j = 0; j < pn; j += size) {
//				System.out.println("!!!!!!!!@#!@#!@#!@#");
				move(i, j, 0, level - 1);
//				System.out.println("!!!!!");
				move(i, j + size / 2, 1, level - 1);
//				System.out.println("!!22!!");
				move(i + size / 2, j + size / 2, 2, level - 1);
//				System.out.println("!33!!!");
				move(i + size / 2, j, 3, level - 1);
//				System.out.println("!44!!!");

			}
		}
		ice = temp;
	}

	// level은 미리 1감소시켜서 들어온다.
	// temp는 moves에 올때마다 새롭게 변경해준다.
	static void move(int sx, int sy, int dir, int level) {
		int len = (int) Math.pow(2, level);
//		System.out.println("!!" + len + " " + dir);
		for (int x = 0; x < len; x++) {
			for (int y = 0; y < len; y++) {
//				System.out.println(x + " " + y);
				int nx = sx + x + dx[dir] * len;
				int ny = sy + y + dy[dir] * len;
//				System.out.println(sx + " " + sy + " " + nx + " " + ny);
//				System.out.println();
				temp[nx][ny] = ice[sx + x][sy + y];
			}
		}
	}
}