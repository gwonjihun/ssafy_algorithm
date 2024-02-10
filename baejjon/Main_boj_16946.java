package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16946 {

	static int[][] map;
	static int[][] groups;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int N, M;
	static Map<Integer, Integer> group;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		group = new HashMap<>();
		map = new int[N][M];
		groups = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0&&groups[i][j]==0) {
					bfs(i, j, idx);
					idx++;
				}
			}
		}
//		for(int i = 0 ; i < N;i++)
//		System.out.println(Arrays.toString(groups[i]));
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					int sum = 1;
					boolean[] v = new boolean[group.size()+1];
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (0 <= nx && nx < N && 0 <= ny && ny < M&&map[nx][ny]==0&&!v[groups[nx][ny]]) {
//							System.out.println(nx + " " + ny);
							sum += group.get(groups[nx][ny]);
							v[groups[nx][ny]]=true;
						}
					}
					sb.append(sum%10);
				}else {
					sb.append(0);
				}
			}
			sb.append("\n");
//			System.out.println(Arrays.toString(map[i]));
		}
		// 0이면 그냥 없는 녀석이야
		System.out.println(sb);
	}

	static void bfs(int x, int y, int idx) {
		Deque<int[]> q = new ArrayDeque<>();
		int cnt = 1;
		groups[x][y] = idx;
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
//			System.out.println(q.size()+"qsize");
			int cur[] = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
//				if(0<=nx && nx< N && 0<=ny &&ny<M) {
//				System.out.println(nx+ " " + ny +" "+map[nx][ny] +"map[nx][ny]");}

				if (0 <= nx && nx < N && 0 <= ny && ny < M && groups[nx][ny]==0 && map[nx][ny] == 0) {
					cnt++;
					groups[nx][ny] = idx;
					q.add(new int[] { nx, ny });

//					System.out.println("!!!!!!!!!!!");
				}
			}
		}
		group.put(idx, cnt);
	}
}
