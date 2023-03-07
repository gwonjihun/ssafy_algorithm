package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D0_1767_서울_20반_권지훈_복습 {
	static int[][] arr;
	static boolean[][] visited;
	static boolean[] v;
	static int N, M, answer;
	static List<int[]> core, choose; // choose를 통해서 선택한 코어 정보를 저장
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			M = 0;
			arr = new int[N][N];
			core = new LinkedList<>();
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						core.add(new int[] { i, j });
						M++;
					}
				}

			}
			for (int i = M; i >= 0; i--) {
				v = new boolean[N];
				choose = new LinkedList<>();
				comb(0, 0, i);
				if (answer < Integer.MAX_VALUE)
					break;
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}

	static void comb(int idx, int cnt, int goal) {
		if (cnt == goal) {
			dfs(0, 0, goal); // 여기서 모든것이 연결이 가능하면 그때 전선의 넓이를 적용해줘야함. 고로

			return;
		}
		for (int i = idx; i < core.size(); i++) { //1 0 10 1 0 1
			// 이걸로 해줄 꺼면 이거를 제거해줘야함.
			choose.add(core.get(i));
			comb(i + 1, cnt + 1, goal);
			choose.remove(choose.size()-1);
		}
	}

	static void dfs(int idx, int cnt, int goal) {
		// idx -> choose의 index
		// cnt는 전선의 개수
		if (idx == goal) {
			answer = Math.min(cnt, answer);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int x = choose.get(idx)[0];
			int y = choose.get(idx)[1];
			int tmp = 0; // 전선의 길이 카운팅
			boolean suc = false;
			while (true) {
				x += dx[i];
				y += dy[i];
				if (x < 0 || x >= N || y < 0 || y >= N) {
					suc = true;
					break;
				}
				if (arr[x][y] != 0)
					break;
				arr[x][y] = 2;
				tmp++;
			}
			if (suc)
				dfs(idx + 1, cnt + tmp, goal);
			while (true) {
				x -= dx[i];
				y -= dy[i];
				if (arr[x][y] != 2) break;

				arr[x][y] = 0;
			}
		}

	}
}
