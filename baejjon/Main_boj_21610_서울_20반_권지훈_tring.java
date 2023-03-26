package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_21610_?Ñú?ö∏_20Î∞?_Í∂åÏ??õà_tring {
	static class cloud {
		int x;
		int y;
		int d;
		int s;

		cloud(int x, int y, int d, int s) {
			this.x = x;
			this.y = y;
			this.d = d;// Î∞©Ìñ•
			this.s = s;// ?Üç?èÑ
		}
	}

	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }, dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] check = { 2, 4, 6, 8 };
	static int[][] cmd, map;
	static boolean[][] v; // ?ï¥?ãπ ?ãúÍ∞ÑÏóê ?Ç¥?†§?ò® ?úÑÏπ?
	static Deque<cloud> q; // ?ù¥Í±∏Î°ú Î∞òÎ≥µ?ï¥Î≤ÑÎ¶¨Î©¥Îêò?ãåÍπ?.
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		v = new boolean[N][N];
		cmd = new int[M][2]; // 0??Î∞©Ìñ• 1???Üç?èÑ
		q = new ArrayDeque<cloud>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			cmd[i][0] = Integer.parseInt(st.nextToken());
			// Î∞©Ìñ•
			cmd[i][1] = Integer.parseInt(st.nextToken());
			// ?Üç?èÑ
		}
		q.addLast(new cloud(N - 1, 0, cmd[0][0], cmd[0][1]));
		q.addLast(new cloud(N - 2, 0, cmd[0][0], cmd[0][1]));
		q.addLast(new cloud(N - 1, 1, cmd[0][0], cmd[0][1]));
		q.addLast(new cloud(N - 2, 1, cmd[0][0], cmd[0][1]));
		// ?ó¨Í∏∞ÏÑú Íµ¨Î¶Ñ?ùÑ ?Ñ†?Éù?ñàÍ≥??
		// ?ó¨Í∏∞ÏÑúÎ∂??Ñ∞
		// Ï¥àÍ∏∞ Íµ¨Î¶Ñ ?ûÖ?†•
		while (!q.isEmpty()) {
			cloud cur = q.poll();
			int nx = (N + cur.x + dx[cur.d] * (cur.s % N)) % N;
			int ny = (N + cur.y + dy[cur.d] * (cur.s % N)) % N;
			System.out.println(nx + " " + ny);

			map[nx][ny] += 1;
			v[nx][ny] = true;

		} // ?ó¨Í∏∞ÏÑú ÎπÑÎÇ¥Î¶¨Í≥†
			// Ï¥àÍ∏∞ Íµ¨Î¶Ñ ÎπÑÍ? ?Çº
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j]) {
					for (int a : check) {
						int nx = i + dx[a];
						int ny = j + dy[a];
						if (0 <= nx && nx < N && 0 <= ny && ny < N) {
							if (map[nx][ny] >= 1)
								map[i][j] += 1;
						}
					}
				}
			}
		} // Î¨ºÎ≥µ?Ç¨
		//?ó¨Í∏∞ÍπåÏß??äî ?ôÑÎ≤ΩÌï¥
		
		
		for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("----------1Ï∞®Ï†Ñ Ï¢ÖÎ£å");
		
		
		for (int Time = 1; Time <= M; Time++) {
			// Î¨ºÎ≥µ?Ç¨ Î≤ÑÍ∑∏Í∞? ÎØ∏Íµ¨?òÑ?êò?ñ¥?ûà?ùå.
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 2 && !v[i][j]) {

						map[i][j] -= 2;
						if(Time!=M) q.add(new cloud(i, j, cmd[Time][0], cmd[Time][1]));
					}
				}
			} // ?ó¨Í∏∞ÏÑú ÎπÑÎÇ¥Î¶¨Í≥†
			if(Time==M) break;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j]) {
						for (int a : check) {
							int nx = i + dx[a];
							int ny = j + dy[a];
							if (0 <= nx && nx < N && 0 <= ny && ny < N) {
								if (map[nx][ny] >= 1)
									map[i][j] += 1;
							}
						}
					}
				}
			} // Î¨ºÎ≥µ?Ç¨
			v = new boolean[N][N];
			System.out.println(q.size());
			while (!q.isEmpty()) {
				cloud cur = q.poll();
				int nx = (N + cur.x + dx[cur.d] * (cur.s % N)) % N;
				int ny = (N + cur.y + dy[cur.d] * (cur.s % N)) % N;
//				System.out.println(nx + " " + ny);
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					map[nx][ny] += 1;
					v[nx][ny] = true;
				}
			}

			System.out.println("---------");

			// Íµ¨Î¶Ñ?ùÑ ??ÏßÅÏù∏?í§
			// ÎπÑÎ?? ?Ç¥Î¶¨Í≥† ÎπÑÍ? ?ò® Í≥≥ÏùÑ ?ôï?ù∏?ïú?ã§.-> booleanÎ∞∞Ïó¥ Ï¥àÍ∏∞?ôî ?õÑ?óê ÏßÑÌñâ
		}
		for(int[] a: map) {
			System.out.println(Arrays.toString(a));
		}System.out.println("------ÏµúÏ¢Ö Íµ¨Î¶Ñ ?ÉÅ?Éú");
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += map[i][j];
			}
		}
		System.out.println(cnt);

	}
}
