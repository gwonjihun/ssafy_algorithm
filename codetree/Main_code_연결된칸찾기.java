package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_code_연결된칸찾기 {
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int N;
	static List<Integer> cnts;
	static int[][] arr;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnts = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !v[i][j]) {
					bfs(i, j);
				}
			}
		}

		Collections.sort(cnts);
		System.out.println(cnts.size());
		for (int a : cnts) {
			System.out.println(a);
		}
	}

	static void bfs(int x, int y) {
		int cnt = 1;
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		v[x][y] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny] && arr[nx][ny] == 1) {
					v[nx][ny] = true;
					q.add(new int[] { nx, ny });
					cnt++;
				}
			}
		}
		cnts.add(cnt);
	}
}