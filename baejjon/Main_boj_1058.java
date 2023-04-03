package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1058 {
	static char[][] map;
	static int Max = 0;
	static int[] friends;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'Y')
					v[i][j] = true;
//				if (map[i][j] == 'Y') {
				for (int k = 0; k < n; k++) {
					if (map[i][j] == 'Y' && map[j][k] == 'Y') {
						v[i][k] = true;
					}
				}
//				}
			}
		}

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (v[i][j]) {
					sum++;
				}

			}
			if (sum > Max) {
				Max = sum;
			}
		}

		System.out.println(Max);
	}
}
