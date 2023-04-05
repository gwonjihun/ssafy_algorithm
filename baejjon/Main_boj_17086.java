package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17086 {
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 }, dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[][] map;
	static int[][] dist;
	static int N, M;
	static int Max_dist = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// bfs로 푼다
		// 1의 값들을 q에 넣어준뒤
		// x,y,cnt형태로 넣어준다
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];

		Deque<int[]> q = new ArrayDeque<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new int[] { i, j, 1 });
				}
			}
		}
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int next_p = cur[2];
			for (int d = 0; d < 8; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (inRange(nx,ny)) {
					if (map[nx][ny] != 1 ) {
						if(dist[nx][ny] == 0) {
						dist[nx][ny] = next_p;
						if (dist[nx][ny] > Max_dist)
							Max_dist = dist[nx][ny];
						q.add(new int[] { nx, ny, next_p + 1 });
						}/*else {
							//최단거리인 경우를 확인해줘야하고 
							if(dist[nx][ny]>next_p) {
								
							}
						}*/
					}

				}

			}
		}
		System.out.println(Max_dist);

	}
	static boolean inRange(int nx,int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < M;
	}
}
