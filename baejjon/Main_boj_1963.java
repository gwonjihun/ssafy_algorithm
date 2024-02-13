package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1963 {
	static boolean[] prime;
	static int n;

	public static void main(String[] args) throws Exception {
		prime = new boolean[10000];

		prime[0] = prime[1] = true;

		for (int i = 2; i * i < 10000; i++) {
			if (!prime[i]) {
				for (int j = i * i; j < 10000; j += i) {
					prime[j] = true;
				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int result = bfs(s, e);
			System.out.println(result == -1 ? "Impossible" : result);
		}
	}

	static int bfs(int s, int e) {
		Map<Integer, Integer> m = new HashMap<>();
		Deque<Integer> q = new ArrayDeque<>();
		q.add(s);
		m.put(s, 0);

		while (!q.isEmpty()) {
			int cur = q.poll();
			int move = m.get(cur);
			if (cur == e) {
				return move;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					if (i == 0 && j == 0)
						continue;
					int pos =cur;
					int[] a = {pos/1000, (pos/100)%10, (pos/10)%10, pos%10};
//					System.out.println((cur + ""));
//					char[] temp = (cur + "").toCharArray();
//					System.out.println(Arrays.toString(temp));
					a[i] = (char) j;
					int tem = 0;
					for (int c = 0; c < 4; c++) {
						tem+= a[c]*Math.pow(10, 3-c);
					}


					if (prime[tem])
						continue;
					if (!m.containsKey(tem)) {
						q.add(tem);
						m.put(tem, move + 1);
					}

				}
			}
		}
		return -1;
	}
}
