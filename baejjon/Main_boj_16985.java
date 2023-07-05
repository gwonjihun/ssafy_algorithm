package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16985 {
	static int[] dz = { 0, 0, 0, 0, 1, -1 }, dx = { 1, -1, 0, 0, 0, 0 }, dy = { 0, 0, 1, -1, 0, 0 };
	static int[][][] dice = new int[5][5][5];
	static int[][][] copy;
	static int[] dir = new int[5];
	static int[] num = new int[5];
	static boolean[] v = new boolean[5];
	static int Min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					dice[i][j][k] = Integer.parseInt(st.nextToken());
				
				}
			}
		}

		perm(0);
		System.out.println(Min!=Integer.MAX_VALUE?Min:-1);
	}

	static void perm(int idx) {
		if (idx == 5) {
			copy = new int[5][5][5];
			for (int i = 0; i < 5; i++) {
				rotation(0);
			}
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!v[i]) {
				num[idx] = i;
				v[i] = true;
				perm(idx + 1);
				v[i] = false;
			}
		}
	}

	static void rotation(int idx) {
		if (idx == 5) {
			// 여기서 판을 돌리는 순서가 저장이 끝남 -> dir을 값이 모두 정해짐
			for (int i = 0; i < 5; i++) {
				int di = dir[i]; // 회전 횟수
				int ch = num[i]; // 선택한 판
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						// 여기서 copy를 채워준다.
						if (di == 0) {
							copy[i][j][k] = dice[ch][j][k];

						}
						if (di == 1) {
							copy[i][j][k] = dice[ch][5 - k - 1][j];
						}
						if (di == 2) {
							copy[i][j][k] = dice[ch][5 - j - 1][5 - k - 1];
						}
						if (di == 3) {
							copy[i][j][k] = dice[ch][k][5 - j - 1];
						}
					}
				}
			}
			if (copy[0][0][0] == 1 && copy[4][4][4] == 1) {
				bfs();
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			dir[idx] = i;
			rotation(idx + 1);
		}

	}

	static void bfs() {
		boolean[][][] visited = new boolean[5][5][5];
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { 0, 0, 0, 0 }); /// 0,0,0 < 좌표 0 : cnt이동 횟수
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 6; d++) {
				int nz = cur[0] + dz[d];
				int nx = cur[1] + dx[d];
				int ny = cur[2] + dy[d];
				if (0 <= nz && 0 <= nx && 0 <= ny && nz < 5 && nx < 5 && ny < 5 && !visited[nz][nx][ny]
						&& copy[nz][nx][ny] == 1) {
					visited[nz][nx][ny] = true;
					if (nx == 4 && ny == 4 && nz == 4) {
						Min = Integer.min(Min, cur[3] + 1);
						if(Min==12) {
							System.out.println(12);
							System.exit(0);
						}
						return;
					}
					q.add(new int[] { nz, nx, ny, cur[3] + 1 });
				}
			}
		}
		// durltjsms 함수 확인
	}
//	for(int i = 0 ; i <5;i++) {
//		// 0, 0 -> 0,4
//		// 0, 0 -> 4,4가되야하는건데
//		for(int j = 0 ; j<5;j++) {
////			turn[i][j] = temp[5-k-1][j]; // 시계방향 90도
////			turn[i][j] = temp[k][5-j-1]; // 반시계 90도
////			turn[i][j] = temp[5-j-1][5-k-1]; // 시계 180도
//		}
//	}
}
