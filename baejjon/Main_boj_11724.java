package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_11724 {
	static List<Integer>[] graph;
	static int N;
	static int M;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new List[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			graph[s].add(e);
			graph[e].add(s);
		}
		result = 0;
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				bfs(i);
				result++;
			}
		}
		System.out.println(result);
	}

	static void bfs(int s) {
		visited[s] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);
		while (!q.isEmpty()) {
			int x= q.poll();
			for (int a : graph[x]) {
				if (!visited[a]) {
//					System.out.println(1);
					q.add(a);
					visited[a] = true;
				}
			}
		}
	}
}
