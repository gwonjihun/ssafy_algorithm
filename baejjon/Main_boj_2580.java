package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2580 {
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
	}

	static void dfs(int col, int row) {

		if (row == 9) {
			dfs(col + 1, 0);
			return;
		}
		if (col == 9) {
			for (int[] a : map) {
				for (int b : a) {
					System.out.print(b + " ");
				}
				System.out.println();
			}

			System.exit(0);
		}
		if (map[col][row] != 0) {
			dfs(col, row + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				// 여기서 map[c,r]이 i가 가능한지를 판단하고 true이면 dfs를 증가시킨다.
				if (isAvailable(col, row, i)) {
					map[col][row] = i;
					dfs(col, row + 1);
				}
			}
			map[col][row] = 0;
		}
	}

	static boolean isAvailable(int c, int r, int target) {
		for (int i = 0; i < 9; i++) {
			if (map[c][i] == target || map[i][r] == target) {
				return false;
			}
		}
		int sx = (int) (c / 3) * 3;
		int sy = (int) (r / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int cx = sx + i;
				int cy = sy + j;
				if (map[cx][cy] == target) {
					return false;
				}
			}
		}
		return true;
	}
}
