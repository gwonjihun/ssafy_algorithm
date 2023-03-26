package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_12100_2048 {
	static int[][] map;
	static int N, Max = 2;
	static int[] dx = { -1, 1, 0, 1 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(map, 5);
		System.out.println(Max);
	}

	static void dfs(int[][] arr, int cnt) {

		// ?šŒ? „?´ ì¢…ë£Œ?œ ?´?›„ ìµœë?ê°? ì°¾ì•„ë³´ê¸°
		if (cnt == 0) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Max <= arr[i][j])
						Max = arr[i][j];
				}
			}
			return;
		}
		int[][] temp = new int[N][N];
		
		
		
		for(int d = 0; d<4;d++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		//?—¬ê¸°ì„œ ?‹¤?‹œ arr[i][j]ë¡?  tempë¥? ì´ˆê¸°?™” ?•˜?Š” ?´?œ ?Š”
		//rotate?•¨?ˆ˜?—?„œ temp ë°°ì—´?— ???•œ ê°’ì„ ë³?ê²½í•˜??ê³?
		//ê·? ê°’ì„ ê¸°ì¡´ arrê°’ìœ¼ë¡? ?Œ? ¤ì¤˜ì•¼?•˜ê¸? ?•Œë¬¸ì—.
		dfs(rotate(temp, d), cnt - 1);
		}
		//

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				temp[i][j] = arr[i][j];
//			}
//		}
//
//
//		dfs(rotate(temp, 1), cnt - 1);
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				temp[i][j] = arr[i][j];
//			}
//		}
//		dfs(rotate(temp, 2), cnt - 1);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				temp[i][j] = arr[i][j];
//			}
//		}
//		dfs(rotate(temp, 3), cnt - 1);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				temp[i][j] = arr[i][j];
//			}
//		}

	}

	static int[][] rotate(int[][] map, int dir) {
		switch (dir) {
		// ?œ„ë¡? ëª°ê¸°
		case 0:
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (map[j][i] != 0) {
						if (block == map[j][i]) {
							map[index - 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						} else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index++;
						}
					}
				}
			}
			break;
		// ?™¼ìª½ìœ¼ë¡? ëª°ê¸°
		case 1:
			for (int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] != 0) {
						if (block == map[j][i]) {
							map[index + 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						} else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index--;
						}
					}
				}
			}
			break;
		// ?™¼ìª½ìœ¼ë¡? ëª°ê¸°
		case 2:
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						if (block == map[i][j]) {
							map[i][index - 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						} else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index++;
						}
					}
				}
			}
			break;
		// ?˜¤ë¥¸ìª½?œ¼ë¡? ëª°ê¸°
		case 3:
			for (int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						if (block == map[i][j]) {
							map[i][index + 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						} else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index--;
						}
					}
				}
			}
			break;
		}
		
		return map;
	}

}
