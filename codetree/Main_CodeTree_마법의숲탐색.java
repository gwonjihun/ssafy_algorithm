package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_CodeTree_마법의숲탐색 {
	static class Node {
		int x, y, dir;

		public Node(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}

	}

	static int r, c, k;
	static int galaxy[][];
	static int score;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		galaxy = new int[r][c];

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
//			printer();

			Node cur = move(y, dir);
//			System.out.println(cur);
			if (cur.x < 1) {
//				System.out.println(y + " " + dir);
//				printer();
//				System.out.println("cleanss");
//				System.out.println("cur:!@#!@#12" + cur);
				clean();
//				System.out.println("clena 작동완료");
				continue;
			}
			galaxy[cur.x][cur.y] = 3;
			for (int d = 0; d < 4; d++) {

				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (cur.dir == d) {
					galaxy[nx][ny] = 2;
				} else {
					galaxy[nx][ny] = 1;
				}
			}
//			System.out.println(cur);
//			printer();
			bfs(cur);
		}
		System.out.println(score);
	}

	static void clean() {
		galaxy = new int[r][c];
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < r && 0 <= y && y < c;
	}

	static void bfs(Node n) {
		boolean[][] v = new boolean[r][c];
		Queue<int[]> q = new ArrayDeque<>();
		v[n.x][n.y] = true;
		int maxR = 0;
		q.add(new int[] { n.x, n.y });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int type = galaxy[cur[0]][cur[1]];
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (!inRange(nx, ny))
					continue;
				if (v[nx][ny])
					continue;
				// 여기서는 다음 좌표와 현재 좌표 값을 기반으로 움직여져야해
				if (galaxy[nx][ny] == 0)
					continue;
				if (type == 3 || type == 2) {
					// 2는 1,2,3rksmd
					// 3은 1,2,3가능
					q.add(new int[] { nx, ny });
					v[nx][ny] = true;
					// 1은 3만가능.
					// 그냥 전체 전부다 들어갈수 있어
				} else if (type == 1) {
					// 여기서 1인 경우에는 2는 못가고 3만 갈 수 있지.
					if (galaxy[nx][ny] == 3) {
						q.add(new int[] { nx, ny });
						v[nx][ny] = true;
					}
				}

			}
			maxR = Math.max(maxR, cur[0]);
		}
//		System.out.println(maxR+1);
		score += maxR + 1;
	}

	static Node move(int ic, int dir) {
		int x = -2;
		int y = ic;
		int d = dir;
		while (true) {
			if (down(x, y)) {
				x += 1;
				continue;
			}
			if (left(x, y) && down(x, y - 1)) {
				x += 1;
				y -= 1;
				d = (d - 1 + 4) % 4;
				continue;
			}
			if (right(x, y) && down(x, y + 1)) {
				x += 1;
				y += 1;
				d = (d + 1) % 4;
				continue;
			}
			break;

		}
		return new Node(x, y, d);
	}

	static void printer() {
		System.out.println("!!!!!!!!!!!!!)___!_!_!_!_!_!_!_!");
		for (int i = 0; i < r; i++) {
			System.out.println(Arrays.toString(galaxy[i]));
		}
	}

	static boolean down(int x, int y) {
		if (x == r - 2)
			return false;
		if (x == -2)
			return galaxy[x + 2][y] == 0;
		return galaxy[x + 1][y + 1] == 0 && galaxy[x + 1][y - 1] == 0 && galaxy[x + 2][y] == 0;
	}

	static boolean left(int x, int y) {
		if(x==-2) return true;
		if (y < 2)
			return false;
		if (x == -1)
			return galaxy[x+1][y - 1] == 0;
		if (x == 0)
			return galaxy[x + 1][y - 1] == 0 && galaxy[x][y - 2] == 0;
		return galaxy[x][y - 2] == 0 && galaxy[x + 1][y - 1] == 0 && galaxy[x - 1][y - 1] == 0;

	}

	static boolean right(int x, int y) {

		if(x<-1) return true;
		if (y >= c - 2)
			return false;
		if (x == -1)
			return galaxy[x + 1][y + 1] == 0;
		if (x == 0)
			return galaxy[x + 1][y + 1] == 0 && galaxy[x][y + 2] == 0;
		return galaxy[x][y + 2] == 0 && galaxy[x + 1][y + 1] == 0 && galaxy[x - 1][y + 1] == 0;
	}
}