package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_codeTree_나무박멸 {
	// 격자 | 박멸이 진행되는 년수 | 확산 범위 | 제초제가 남아 있는 수
	static int n, m, k, c;
	static int[][] arr;// 나무의 및 벽의 현황
	static int[][] limit;// 제초제가 뿌려져있는 경우
	static int[] tdx = { 0, 0, 1, -1 }, tdy = { 1, -1, 0, 0 }, cdx = { -1, -1, 1, 1, }, cdy = { 1, -1, 1, -1 };
	static int result;
	static int tx, ty, cntD;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken()) + 1;
		arr = new int[n][n];
		limit = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		for (int M = 0; M < m; M++) {
			grow();
//			print();
			spread();// 번식
//			print();
			search();// 제초제를 뿌릴 곳을 찾는것이고
//			System.out.println(tx + " " + ty + " " + cntD);
			die();// 제초제를 뿌린거고
//			print();
			down();// 제초제 수명 감소
		}
		System.out.println(result);
	}

	static void down() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (limit[i][j] > 0) {
					limit[i][j] -= 1;
				}
			}
		}
	}

	static void search() {
		tx = 0;
		ty = 0;
		cntD = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = arr[i][j] == -1 ? 0 : arr[i][j];
				if (arr[i][j] > 0) {
					for (int d = 0; d < 4; d++) {
						//
						for (int l = 1; l <= k; l++) {
							int nx = i + (cdx[d] * l);
							int ny = j + (cdy[d] * l);

							if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] <= 0) {
								break;
							}
							cnt += arr[nx][ny];
						}
					}
				}
				if (cnt > cntD) {
					tx = i;
					ty = j;
					cntD = cnt;
				}
			}
		}
		result += cntD;
	}

//151
	static void die() {
		arr[tx][ty] = 0;
		limit[tx][ty] = c;
		for (int d = 0; d < 4; d++) {
			//
			for (int l = 1; l <= k; l++) {
				int nx = tx + (cdx[d] * l);
				int ny = ty + (cdy[d] * l);

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					break;
				}
				if (arr[nx][ny] <= 0) {
					limit[nx][ny] = c;
					break;
				}
				limit[nx][ny] = c;
				arr[nx][ny] = 0;
			}
		}

	}

	static void spread() {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] <= 0)
					continue;
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + tdx[d];
					int ny = j + tdy[d];
					if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] == 0 && limit[nx][ny] == 0) {
						cnt += 1;
					}
				}

				for (int d = 0; d < 4; d++) {
					int nx = i + tdx[d];
					int ny = j + tdy[d];
					if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] == 0 && limit[nx][ny] == 0) {
						temp[nx][ny] += arr[i][j] / cnt;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}

	static void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("______________________");
	}

	static void grow() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] <= 0)
					continue;
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + tdx[d];
					int ny = j + tdy[d];
					if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] > 0) {
						cnt += 1;
					}
				}
				arr[i][j] += cnt;
			}
		}
	}
}
