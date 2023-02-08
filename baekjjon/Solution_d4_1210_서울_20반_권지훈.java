package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_1210_서울_20반_권지훈 {
	static int[] dx = { 0, 0, -1 };
	static int[] dy = { -1, 1, 0 };

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input(3).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] ladder = new int[100][100];
			int x = 0;
			int y = 0;

			int test = Integer.parseInt(br.readLine());

			for (int i = 0; i < ladder.length; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				for (int j = 0; j < ladder.length; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}

			while (x != 0) {
				for (int i = 0; i < dx.length; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && nx < ladder.length && ny >= 0 && ny < ladder.length) {
						if (ladder[nx][ny] == 1) {
							x = nx;
							y = ny;
							ladder[x - dx[i]][y - dy[i]] = 3;
						}
					} else continue;
				}
			}
			sb.append("#").append(test).append(" ").append(y).append("\n");
		}
		System.out.println(sb);
	}
}