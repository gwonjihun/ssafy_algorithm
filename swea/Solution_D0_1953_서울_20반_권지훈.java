package gwonjihun.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_D0_1953_서울_20반_권지훈 {
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	// 파이프 모형별 데이터 입력
	static int[][] pipe = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 2 }, { 1, 2 }, { 3, 1 }, { 3, 0 } };

	static int[][] map, arr;
	static boolean[][] v;
	static int N, M, time, goal, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int T = 1; T <= TC; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int Sx = Integer.parseInt(st.nextToken());
			int Sy = Integer.parseInt(st.nextToken());

			goal = Integer.parseInt(st.nextToken());
			time = 1;
			cnt = 0;

			map = new int[N][M];
			arr = new int[N][M];
			v = new boolean[N][M];

			// 하수도 지도 초기 데이터 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(Sx, Sy);

			sb.append("#").append(T).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y, time });
		v[x][y] = true;
		arr[x][y] = 1;
		cnt++;
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			int[] dir = pipe[map[xy[0]][xy[1]]];
			for (int d : dir) {
				int nx = xy[0] + dx[d];
				int ny = xy[1] + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 0 && !v[nx][ny]) {
					// 여기서 파이프로 격자에서 이동 가능한 곳을 카운트함

					int[] tmp = pipe[map[nx][ny]];


					for (int s : tmp) {

						if ((nx + dx[s]) == xy[0] && (ny + dy[s]) == xy[1]) {

							q.add(new int[] { nx, ny, xy[2] + 1 });
							if (arr[nx][ny] == 0)
								arr[nx][ny] = xy[2] + 1;
//							if (xy[2] + 1 == goal && !v[nx][ny]) {
							if (xy[2] + 1 <= goal) {
								cnt++;
							}
							v[nx][ny] = true;
//							}
							break;
						}
					}
				}
			}
		}

	}
}
