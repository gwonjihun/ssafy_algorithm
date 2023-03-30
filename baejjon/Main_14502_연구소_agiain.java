package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_14502_연구소_agiain {
	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] map;
	static int cnt = 0;
	static int n, m;
	static List<node> p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		p = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					p.add(new node(i, j));
				}
			}
		}

		perm(0);
		System.out.println(cnt);
	}

	static void perm(int cntss) {
		if (cntss == 3) {
			int[][] tm = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					tm[i][j]= map[i][j];
				}
			}
			bfs(tm);
			int temp = count(tm);
			if (cnt < temp)
				cnt = temp;
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					perm(cntss + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void bfs(int[][] tm) {

		
		Deque<node> q = new ArrayDeque<>();
		for (node a : p) {
			q.add(a);
	
		}
		while (!q.isEmpty()) {
			node cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (inRange(nx, ny) && tm[nx][ny] == 0) {
				
					q.add(new node(nx, ny));
					tm[nx][ny]=2;
				}
			}
		}
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	static int count(int[][] tm) {
		int cnt_s = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tm[i][j] == 0)
					cnt_s++;
			}
		}
		return cnt_s;
	}
}
