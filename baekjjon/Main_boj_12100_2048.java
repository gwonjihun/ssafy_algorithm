package gwonjihun.baekjjon;

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

		// 회전이 종료된 이후 최대값 찾아보기
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
		//여기서 다시 arr[i][j]로  temp를 초기화 하는 이유는
		//rotate함수에서 temp 배열에 대한 값을 변경하였고
		//그 값을 기존 arr값으로 돌려줘야하기 때문에.
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
		// 위로 몰기
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
		// 왼쪽으로 몰기
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
		// 왼쪽으로 몰기
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
		// 오른쪽으로 몰기
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
