package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_20056_?ƒ?–´???ŒŒ?´?–´ë³? {
	static int N, M, K;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class fireball {

		int m;
		int d;
		int s;

		fireball(int m, int d, int s) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}

	static List<fireball>[][] map;
//	static List<firball>
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());// ë°°ì—´?˜ ?¬ê¸?
		M = Integer.parseInt(st.nextToken());// ?‹œ?‘ ?ŒŒ?´?–´ë³? ê°??ˆ˜
		K = Integer.parseInt(st.nextToken());// ?´?™ ?šŸ?ˆ˜

		map = new List[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<fireball>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			map[x][y].add(new fireball(m, d, s));
		}
		
	}
}
