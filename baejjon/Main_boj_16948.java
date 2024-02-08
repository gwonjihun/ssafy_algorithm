package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16948 {

	static int N;
	static int[] dx = { -2, -2, 0, 0, 2, 2 }, dy = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));

	}

	static void bfs(int sx, int sy, int ex, int ey) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		visited[sx][sy] = true;
		q.add(new int[] { sx, sy, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == ex && cur[1] == ey) {
				System.out.println(cur[2]);
				return;
			}
			for (int d = 0; d < 6; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(0<=nx&&nx < N && 0<=ny && ny <N && !visited[nx][ny]) {
					q.add(new int[] {nx,ny,cur[2]+1});
					visited[nx][ny]=true;
				}
			}
		}
		System.out.println(-1);
	}

}
