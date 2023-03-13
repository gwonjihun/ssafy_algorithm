package gwonjihun.test;

import java.io.*;
import java.util.*;

class solution_1 {
	static final int[] di = {0, 1, 0, -1}, dj = {1, 0, -1, 0};
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (cnt < map[i][j])
						cnt = map[i][j];
				}
			}
			Node player = new Node(0, 0, 0, 0);
			for (int k = 1; k <= cnt; k++) {
				player = bfs(player, k, map, N);
			}
			sb.append("#").append(tc).append(" ").append(player.r).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static class Node {
		int i, j, d, r;
		Node(int i, int j, int d, int r){
			this.i = i; this.j = j; this.d = d; this.r = r;
		}
	}
	
	static Node bfs(Node start, int cnt, int[][] map, int N) {
		Node res = null;
		Deque<Node> q = new ArrayDeque<>();
		q.offer(start);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int i = cur.i, j = cur.j, d = cur.d, r = cur.r;
			if (map[i][j] == cnt) {
				res = cur;
				break;
			}
			int ni = i + di[d], nj = j + dj[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N)
				q.offer(new Node(ni, nj, d, r));
			
			if (++d == 4) d = 0;
			ni = i + di[d]; nj = j + dj[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N)
				q.offer(new Node(ni, nj, d, r+1));
		}
		return res;
	}
}