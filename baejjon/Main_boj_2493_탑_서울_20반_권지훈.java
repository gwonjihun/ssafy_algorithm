package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_2493_?ƒ‘_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<int[]> q = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken());
			//?—¬ê¸°ì„œ 
			while (!q.isEmpty()) {
				if (q.peekLast()[1] >= top) {
					sb.append(q.peekLast()[0]).append(" ");
					break;
				}
				q.pollLast();
			}

			if (q.isEmpty()) {
				sb.append(0).append(" ");
			}
			q.addLast(new int[] { i, top });
		}

		System.out.println(sb);
	}

}
