package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_3190_뱀_서울_권지훈 {
	static Deque<int[]> snake;
	static int[][] map;
	static int[] dx = { 0, -1, 0, 1 }, dy = { 1, 0, -1, 0 };
	// 시계방향 d+3%4 반시계 방향 d+1%4
	static int n, k, l;
	static Deque<Command> coms;

	static class Command {
		int x;
		char turn;

		Command(int x, char turn) {
			this.x = x;
			this.turn = turn;
		}

		@Override
		public String toString() {
			return "Command [x=" + x + ", turn=" + turn + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 1;

		}
		l = Integer.parseInt(br.readLine());
		coms = new ArrayDeque<>();
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			char turn = st.nextToken().charAt(0);

			coms.addLast(new Command(t, turn));
		}
		snake = new ArrayDeque<int[]>();
		snake.addLast(new int[] { 0, 0 });
		int dir = 0;
		int time = 1;

		while (true) {
			int[] xyd = snake.peekLast();
			int x = xyd[0] + dx[dir];
			int y = xyd[1] + dy[dir];

			
			if (0 > x || x >= n || 0 > y || y >= n) { // 벽충돌
				break;
			}
			boolean flag = false;
			for(int[] a: snake) {
				if(a[0] == x && a[1]==y) {
					flag =true;
					break;
				}
			}
			if (flag) break;

			if (map[x][y] != 1) {
				snake.pollFirst();
			} else {// 여기서는 사과를 먹음
				map[x][y] = 0;
			}

			if (coms.size() != 0 && time == coms.peekFirst().x) {
				Command cur = coms.pollFirst();
				if (cur.turn == 'D') {
					dir = (dir + 3) % 4;
				} else {
					dir = (dir + 1) % 4;
				}
			}
			snake.offer(new int[] { x, y });
			time++;

		}
		System.out.println(time);
	}
}
