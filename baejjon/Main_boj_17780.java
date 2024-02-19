package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17780 {

	static class Node {
		int r, c, dir;

		Node(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	static int N, K;
	static int[][] color;// 이걸로 위치가 아닌 벽들의 종류를 확인하는 부분이고
	static Deque<Integer>[][] state;// d여기다가 걍 넣어서 관리한다?
	// Integer : nodes의 idx 정보를 저장해 준다.
	static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
	static Node[] nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		color = new int[N][N];
		state = new ArrayDeque[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				state[i][j] = new ArrayDeque<>();
			}
		}
		nodes = new Node[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			nodes[i] = new Node(x, y, d);
			state[x][y].add(i);
		}
		int t = 1;
		while (t < 1001) {
			for (int i = 0; i < K; i++) {
				Node cur = nodes[i];
				int x = cur.r;
				int y = cur.c;
				int dir = cur.dir;
				if (state[x][y].peekFirst() != i)
					continue;
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (!inRange(nx, ny) || color[nx][ny] == 2) {
					dir = dir % 2 == 0 ? dir + 1 : dir - 1;
					nx = x + dx[dir];
					ny = y + dy[dir];
					cur.dir = dir;
					if (!inRange(nx, ny) || color[nx][ny] == 2) {
						continue;
					}

				}
				int col = color[nx][ny];
				if (col == 1) {
					while (state[x][y].size() > 0) {
						int tmp = state[x][y].pollLast();
						nodes[tmp] = new Node(nx, ny, nodes[tmp].dir);
						state[nx][ny].addLast(tmp);
					}
				} else if (col == 0) {
					while (state[x][y].size() > 0) {
						int tmp = state[x][y].pollFirst();
						nodes[tmp] = new Node(nx, ny, nodes[tmp].dir);
						state[nx][ny].addLast(tmp);
					}
				}
			}

			boolean flag = true;
			for (Node node : nodes) {
				int x = node.r;
				int y = node.c;
				if (state[x][y].size() >= 4) {
					flag = false;
					break;
				}
			}
			// t를 증가하기 전에 state의 사이즈를 보고 4 이상이 된 친구가 있으면 t를 증가하지 않는다.
			if (flag) {
				t += 1;
			} else {
				break;
			}

		}
		System.out.println(t>1000?-1:t);
	}

	static void move() {

	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
