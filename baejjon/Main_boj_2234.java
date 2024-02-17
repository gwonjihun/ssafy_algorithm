package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2234 {

	static int M, N;

	static int[][] wall;
	static int[][] group;
	static List<Integer> count;
	static int cnt;
	static int[] dx = { 0, -1, 0, 1 }, dy = { -1, 0, 1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wall = new int[M][N];
		group = new int[M][N];
		count = new ArrayList<>();
		cnt = 0;
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				int sum = bfs(i, j, cnt);
				max = Math.max(sum, max);
				cnt += 1;
				count.add(sum);
			}
		}
		System.out.println(count.size());
		System.out.println(max);
		int cMax = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 여기서는 얻을수 있는 가장 큰 넓이를 구할것이고
				
				for(int d= 0 ; d<4;d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					
					if ((wall[i][j] & (1 << d)) != 0) {
						//d방향으로 벽이 있는 경우
						if(!inRange(nx,ny)) continue;
						if(group[i][j]==group[nx][ny]) continue;
						cMax = Math.max(cMax, count.get(group[i][j])+count.get(group[nx][ny]));
					}
				}
			}
		}
		System.out.println(cMax);
	}

	static int bfs(int x, int y, int g) {

		Deque<int[]> q = new ArrayDeque<>();
		int cnt = 1;
		visited[x][y] = true;
		group[x][y] = g;
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if ((wall[cur[0]][cur[1]] & (1 << d)) != 0)
					continue;
				if (!inRange(nx, ny) || visited[nx][ny])
					continue;
				visited[nx][ny]=true;
				q.add(new int[] {nx,ny});
				group[nx][ny] = g;
				cnt++;
			}
		}
		return cnt;
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}
}
