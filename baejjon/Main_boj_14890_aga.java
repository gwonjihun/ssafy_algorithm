package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14890_aga {

	static int[][] arr;
	static int n, l;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		result = 0;
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			if (check(i, 0, 0)) {
				result++;
			}
			if (check(0, i, 1)) {
				result++;
			}
		}

		System.out.println(result);

	}

	static boolean check(int x, int y, int dir) {
		int[] h = new int[n];
		boolean[] v = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (dir == 0) {
				h[i] = arr[x][i];

			} else {
				h[i] = arr[i][y];
			}
		}
		for (int i = 0; i < n - 1; i++) {
			if (h[i] == h[i + 1]) {
				continue;
			} else if (h[i] - 1 == h[i + 1]) {
				for (int j = i + 1; j < i + 1 + l; j++) {
					if (j >= n || v[j] || h[i + 1] != h[j]) {
						return false;
					}
					v[j] = true;
				}
			} else if (h[i] + 1 == h[i + 1]) {

				for (int j = i; j > i - l; j--) {
					if (j < 0 || v[j] || h[i] != h[j]) {
						return false;
					}
					v[j] = true;
				}

			} else {
				return false;
			}
		}
		return true;
	}
}
