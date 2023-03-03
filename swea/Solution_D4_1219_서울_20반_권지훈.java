package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D4_1219_서울_20반_권지훈 {

	static List<Integer>[] g;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			g = new List[100];
			v = new boolean[100];
			for (int i = 0; i < 100; i++) {
				g[i] = new ArrayList<Integer>();
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				g[from].add(to);
			}

			int result = bfs(0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int i) {
		if(i == 99 ) return 1;
		v[i] = true;
		for (int a : g[i]) {
			if (!v[a]) {
				if (dfs(a) == 1)
					return 1;
			}
		}

		return 0;
	}
	static int bfs(int i) {
		Deque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.add(i);
		while(!q.isEmpty()) {
			i = q.poll();
			if(i==99) return 1;
			for(int a: g[i]) {
				if(!v[a]) {
					v[a] = true;
					q.addLast(a);
				}
			}
		}
		
		return 0;
	}
}
