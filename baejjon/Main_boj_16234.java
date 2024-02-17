package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16234 {
	static int[][] worlds;
	static int L, R, N;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static List<int[]> shares;// 공유하는 국가들의 idx를 저장한다.
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		worlds = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				worlds[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		while (true) {
			boolean flag = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						continue;
					shares = new ArrayList<int[]>();
					int sum = bfs(i, j);
					
					if (shares.size() > 1) {
						if(shares.size()==0) continue;
						int avg = (int) sum / shares.size();
						for (int[] cur : shares) {
							worlds[cur[0]][cur[1]] = avg;
						}
						flag = true;
					}

				}
			}
//			for(int[] a : worlds) {
//			System.out.println(Arrays.toString(a));
//			}
//			System.out.println("_+_+_+_+_+_+_+_+_+_+_+_+_+");
			if (flag) {
				day++;
			} else {
				break;
			}
			// bfs가 돌아가서 바뀐 전적이 있다 그러면 flag true로 전환
		}
		System.out.println(day);
	}

	static int bfs(int x, int y) {
		int sum = worlds[x][y];
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { x, y });
		visited[x][y]=true;
		shares.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curC = worlds[cur[0]][cur[1]];
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (!inRange(nx, ny) || visited[nx][ny])
					continue;
				int bet = Math.abs(curC - worlds[nx][ny]);
				if (L <= bet && bet <= R) {
//					System.out.println(cur[0]+", "+ cur[1]+":"+ bet);
					visited[nx][ny] = true;
					sum += worlds[nx][ny];
					q.add(new int[] { nx, ny });
					shares.add(new int[] { nx, ny });
				}
			}
		}
		return sum;
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
