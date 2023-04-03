package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1194 {
	static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][][] visited;
	static int min_cnt = Integer.MAX_VALUE;
	static int n, m;
	static int sx, sy;

	public static void main(String[] args) throws Exception {
//		System.out.println(1<<0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][64];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}
		bfs(sx, sy, 0, 0);
		System.out.println(min_cnt == Integer.MAX_VALUE ? -1 : min_cnt);
		// 데이터 입력을 끝냈고
	}

	static void bfs(int sx, int sy, int vis, int cnt) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { sx, sy, vis, cnt });
		visited[sx][sy][vis] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (map[cur[0]][cur[1]] == '1') {
				if (min_cnt > cur[3]) {
					min_cnt = cur[3];
					continue;
				}
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (!inRange(nx, ny))
					continue;
				if (visited[nx][ny][cur[2]])
					continue;
				if (map[nx][ny] < 46)
					continue; // #이라는 벽 처리
				if (map[nx][ny] == '.' || map[nx][ny] == '0' || map[nx][ny] == '1') {
					visited[nx][ny][cur[2]] = true;
					q.add(new int[] { nx, ny, cur[2], cur[3] + 1 });
					continue;
				}
				if (97 <= map[nx][ny] && map[nx][ny] <= 122) {
					// 열쇠를 줃으러가는 상황에서는 뭔가를 확인할 이유가 없단 말이지?
					// 그러면 그냥 vis값을 처리해준다.
					int nc = cur[2] | (1 << (map[nx][ny] - 'a'));
					if(!visited[nx][ny][nc]) {
					visited[nx][ny][nc] = true;
					visited[nx][ny][cur[2]] = true;
					q.add(new int[] { nx, ny, nc, cur[3] + 1 });
					}
					continue;
				}
				if (65 <= map[nx][ny] && map[nx][ny] <= 90) {
					// 열쇠를 줃으러가는 상황에서는 뭔가를 확인할 이유가 없단 말이지?
					// 그러면 그냥 vis값을 처리해준다.
					int temp =  cur[2] & 1<<(map[nx][ny]-'A');
					if(temp >0){
					visited[nx][ny][cur[2]] = true;
					q.add(new int[] { nx, ny, cur[2], cur[3] + 1 });
					}
					continue;
				}
			}
		}

	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
}

//		System.out.println(Integer.toBinaryString(12|1<<('a'-'a')));
//		System.out.println((int)'a');97
//		System.out.println((int)'z');122
//		System.out.println((int)'A');65
//		System.out.println((int)'Z');90
//		System.out.println((int)'.');46
//		System.out.println((int)'#');35
//		System.out.println((int)'0');48
//		System.out.println((int)'1');49