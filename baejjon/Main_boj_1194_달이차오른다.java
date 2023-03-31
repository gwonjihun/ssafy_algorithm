package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*

 */
public class Main_boj_1194_달이차오른다 {
	static class node{
		int x,y,cnt;
		String key;
		public node(int x, int y, int cnt, String key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		
	}
	static char[][] map;
	static int sx, sy, n, m;
	static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
	static int[] key = new int[6];
	static boolean[][] vis;
	static int min_cnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		System.out.println((int) 'A');
		System.out.println((char) 90);
		System.out.println((char) 'a' - 1);
		System.out.println((int) '.');
		System.out.println((int) '0');
		System.out.println((int) '#');
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '0') {
					sx = i;
					sy = j;
					break;
				}
			}
		}
		vis = new boolean[n][m];
		bfs(sx, sy);
		System.out.println(min_cnt == Integer.MAX_VALUE ? -1 : min_cnt);
	}

	static void bfs(int x, int y) {
		Deque<node> q = new ArrayDeque<>();
		q.add(new node( x, y, 0,""));
		vis[x][y] = true;
		while (!q.isEmpty()) {
			node cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (!inRange(nx, ny))
					continue;
				if (vis[nx][ny])
					continue;
				// 벽을 만났을때
				if (map[nx][ny] == '1') {
					min_cnt = Math.min(min_cnt, cur.cnt + 1);
					continue;
				}
				if (map[nx][ny] == '#')
					continue;
				if (map[nx][ny] == '0') {
						vis[nx][ny] = true;
						q.add(new node(nx, ny, cur.cnt + 1,cur.key ));
					}
				if (map[nx][ny] == '.') {
					vis[nx][ny] = true;
					q.add(new node ( nx, ny, cur.cnt + 1 ,cur.key));
				}

				// 열쇠줍는 모션 97
				if ('a' <= map[nx][ny]) {
					System.out.println(nx + " " + ny + " " + (cur.cnt+1));
					pick_up(map[nx][ny], cur.cnt + 1);
					q.add(new node( nx, ny, cur.cnt + 1,cur.key));
					vis[nx][ny] = true;
					continue;
				}
				// 문을 열어야할때
				if ('A' <= map[nx][ny] && map[nx][ny] < 91) {
					if (use_key(map[nx][ny], cur.cnt + 1)) {
						q.add(new node(nx, ny, cur.cnt + 1,cur.key ));
						vis[nx][ny] = true;
					}
				}
			}
		}

	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	static boolean use_key(char c, int cnt) {
		int a = c - 'A';
		if (key[a] > 0) {
			System.out.println("!!!현재 cnt" + cnt + " key습득 시점 : " + key[a]);
			if (cnt > key[a]) {
				System.out.println(c+"문 개방");
				return true;
			}
		}
		return false;
	}

	static void pick_up(char c, int cnt) {
		int a = c - 'a';
		if (key[a] > 0) {
			return;
		} else {

			System.out.println(c+"키 습득");
			key[a] = cnt;
			vis = new boolean[n][m];
		}
	}
}
