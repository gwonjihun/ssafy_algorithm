package gwonjihun.baejjon;

import java.util.*;
import java.io.*;


public class Main_boj_2573_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	static int[][] arr;
	static boolean[][] visited;
	static int N, M;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int year = 0;
		int part = 1;
		while (true) {
			part = melting();
			if (part > 1)
				break;
			else if (part == -1) {
				year = 0;
				break;
			}
			check_zero();
			year++;
		}
		System.out.println(year);
	}

	static int melting() {

		visited = new boolean[N][M];
		int part = 0;
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M ; j++) {
				if (!visited[i][j] && arr[i][j] > 0) {
					part++;
					if (part > 1)
						return part;
					bfs(i, j);
				}
			}
		}
		if (part == 0)	return -1;
		return 1;
	}
	static void bfs(int r, int c) {



		Deque<int[]> q = new ArrayDeque<>();
		q.addLast(new int[] { r, c });

		while (!q.isEmpty()) {
//			System.out.println("?›„ë³? 1");
			int[] xy = q.pollFirst();
			visited[xy[0]][xy[1]] = true;
			int melt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = xy[0] + dx[i];
				int ny = xy[1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && arr[nx][ny] == 0) {
					melt++;
				}
				if (1 <= nx && nx < N - 1 && 1 <= ny && ny < M - 1 && !visited[nx][ny] && arr[nx][ny] != 0) {
					q.addLast(new int[] { nx, ny });
					visited[nx][ny] = true;
				}

			}
			arr[xy[0]][xy[1]] = (arr[xy[0]][xy[1]] - melt <= 0) ? -1 : arr[xy[0]][xy[1]] - melt;
		}
	}

	static void check_zero() {
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (arr[i][j] == -1)
					arr[i][j] = 0;
			}
		}
	}
//
//		while (true) {
//			visited = new boolean[N][M];
//			cnt = 0;
//			for (int i = 1; i < N-1; i++) {
//				for (int j = 1; j < M-1; j++) {
//					if (!visited[i][j] && arr[i][j] != 0) {
//						if (cnt >= 1 ) { System.out.println("!@#!@#"); return;}
//						bfs(i, j);
//						cnt++;
//					}
//				}
//			}
//			if(cnt == 0 ) {
//				break;
//			}
//			year++;
//		}
//		System.out.println("!");
//		System.out.println(year);
//	}
//
//


}
