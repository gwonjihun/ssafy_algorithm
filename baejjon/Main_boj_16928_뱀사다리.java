package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16928_뱀사다리 {

	static int[] map = new int[101];
	static int[] cnt = new int[101];
	static boolean[] v = new boolean[101];
	// 0이면 사다리 or 뱀이 없음.
	static int Max_cnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			map[s] = p;
		}

		bfs();
	}

	static void bfs() {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(1);
		cnt[1] = 0;
		v[1] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == 100) {
				System.out.println(cnt[cur]);
				return;
			}
			for (int i = 1; i < 7; i++) {
				int nx = cur + i;

				if (100 < nx)
					continue;
				if (v[nx])
					continue;
				v[nx] = true;
				if (map[nx] != 0) {
					if (!v[map[nx]]) {// 사다리 뱀 있을때
						v[map[nx]] = true;
						q.add(map[nx]);
						cnt[map[nx]] = cnt[cur] + 1;
					}
				} else {
					q.offer(nx);
					cnt[nx] = cnt[cur] + 1;
				}

			}
		}

	}
}
