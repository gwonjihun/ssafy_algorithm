package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2239_스도쿠 {
	static int[][] map = new int[9][9];
	static List<int[]> target = new ArrayList<int[]>();
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0)
					target.add(new int[] { i, j });
			}
		}
		check(0);
//		for (int[] a : map) {
//			for (int b : a) {
//				System.out.print(a);
//			}
//			System.out.println();
//		}
//		print();
	}

	static void print() {
		for (int[] a : map) {
			for (int b : a) {
				System.out.print(b);
			}System.out.println();
		}
	}

	// ??
	static void check(int x) {

		if (x == target.size()) {
			print();
			System.exit(0);
		}
		boolean[] nums = new boolean[10];
		int[] cur = target.get(x);

		// 가로
		for (int i = 0; i < 9; i++) {
			nums[map[cur[0]][i]] = true;
			nums[map[i][cur[1]]] = true;
		}


		// 네모
		int s_x = 3 * (cur[0] / 3);
		int s_y = 3 * (cur[1] / 3);
		for (int i = s_x; i < s_x+3; i++) {

			for (int j = s_y; j < s_y+3; j++) {
				nums[map[i][j]] = true;

			}
		}

		// 할당
		for (int i = 1; i < 10; i++) {
			if (!nums[i]) {
				map[cur[0]][cur[1]] = i;
				check(x + 1);
				map[cur[0]][cur[1]] = 0;

			}
		}
	}

}
