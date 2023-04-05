package gwonjihun.swea;

import java.io.*;
import java.util.*;

/*
이번 문제는 따라오는 녀석과
도망가는 녀석을 bfs를 돌리면서 
최적지일떄를 기반으로 진행을 해야해
그리고 최적은 bfs로 돌리면 결국 값이 있을텐데

*/public class Solution_D5_7793 {
	static class Node {
		int x, y;
		int cnt;

		public Node(int x, int y) {

			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static char[][] map;
	static int Dx, Dy, bx, by, N, S;
	static Queue<Node> devil, soyoun;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());

			devil = new ArrayDeque<>();
			soyoun = new ArrayDeque<>();
			map = new char[N][S];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < S; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '*') {
						bx = i;
						by = j;

						Node b = new Node(bx, by);

						devil.add(b);
					} else if (map[i][j] == 'S') {
						Dx = i;
						Dy = j;
					}
				}
			}
			Node D = new Node(Dx, Dy, 0);
			soyoun.add(D);
			int result = bfs();
			sb.append("#").append(tc).append(" ").append(result == -1 ? "GAME OVER" : result).append("\n");

		}
		System.out.println(sb);
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < S;
	}

	static int bfs() {
		while (!soyoun.isEmpty()) {
			int size = devil.size();
			for (int div = 0; div < size; div++) {
				Node cur = devil.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (inRange(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
						map[nx][ny] = '*';
						devil.add(new Node(nx, ny));
					}
				}
			}
//			for(char[] a : map)
//			System.out.println(Arrays.toString(a));
			size = soyoun.size();
			for (int div = 0; div < size; div++) {
				Node cur = soyoun.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (inRange(nx, ny)) {

						if (map[nx][ny] == '.') {
							map[nx][ny]='S';
							soyoun.add(new Node(nx, ny, cur.cnt + 1));// tlqkf anjsep
						}else if(map[nx][ny]=='D')
						{
							return cur.cnt+1;
						}
					}

				}
			}

		}
		return -1;
	}
}
