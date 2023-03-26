package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_15649_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {

	static int N, M;
	static int[] result;
	static boolean[] v;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		v = new boolean[N];

		// ?ˆœ?—´ ?•¨?ˆ˜ ?™?‘
		perm(0);

		System.out.print(sb);
	}

	static void perm(int cnt) {

		if (cnt == M) {

			for (int i : result) sb.append(i).append(" ");
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
//			if (!(v[i])) {
//				v[i] = true;
				result[cnt] = i + 1;
				perm(cnt + 1);
//				v[i] = false;
//			}

		}
	}
}
