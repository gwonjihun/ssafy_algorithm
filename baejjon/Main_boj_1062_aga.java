package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1062_aga {
	static int N, K;
	static boolean[] visited;// 이걸로 k개의 단어를 선택하는것이기 때문에
	static int max = Integer.MIN_VALUE;
	static String[] words;// 단어들 종류

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[26];
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		visited['a' - 'a'] = true;
		visited['c' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['n' - 'a'] = true;
		if (K < 5) {
			System.out.println(0);
		} else if (K == 26) {
			System.out.println(N);
		} else {
			dfs(0, 0);
			System.out.println(max);
		}
	}

	static void dfs(int depth, int idx) {
		if (depth == K - 5) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < words[i].length(); j++) {
					if (!visited[words[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;
			}
			max = Math.max(cnt, max);
			return;
		}

		for (int i = idx; i < 26; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(depth + 1, i + 1);
			visited[i] = false;
		}
	}
}
