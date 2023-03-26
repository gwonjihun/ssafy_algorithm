package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14890 {
	private static int n, l;
	private static int[][] map;

	public static void main(String[] args) throws IOException {

		//nxn
		//?†’?´
		//ì§??‚˜ê°? ?ˆ˜ ?ˆ?Š” ê¸¸ì´ ëª? ê°? ?ˆ?Š”ì§?!
		//ê¸¸ì´ : ?•œ ?–‰, ?•œ ?—´ ? „ë¶?. -> ?•œìª? ??—?„œ ?‹¤ë¥¸ìª½ ?ê¹Œì? ì§??‚˜ê°??Š” ê²?

		//ê²½ì‚¬ë¡?
		//?‚®??ì¹? -> ?†’??ì¹? ?ˆœ?„œë¡œë§Œ ê°??Š¥
		//?†’?´ì°? 1

		//ê°™ì? ê³³ì— ê²½ì‚¬ë¡? ?˜ ë¶ˆê??Š¥
		//?†’?´ 1?´?ƒ ì°¨ì´?‚˜ë©? ?•ˆ?Œ
		//L ì£¼ì–´ì§?
		//ê²½ì‚¬ë¡? ?–„ë¬¸ì— ë²”ìœ„ ë²—ì–´?‚˜ë©? ?•ˆ?¨

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n+1][n+1];

		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//???´
		//?‹¤?Œ ë¸”ë¡?˜ ?†’?´ê°? 1ì°¨ì´?‚ ?•Œ Lê¸¸ì´ë§Œí¼ ?™•?¸
		//ë§Œì•½ ê²½ì‚¬ë¡œë?? ?†“?„ ?ˆ˜ ?ˆ?‹¤ë©? ë¬´ìŠ¨ ì²˜ë¦¬ë¥?.. -> true

		int cnt=0;

		for (int i=1; i<=n; i++) {
			if (check(i,0,0)) {
				//?—´
				cnt++;
			}
			if (check(0,i,1)) {
				//?–‰
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static boolean check(int x, int y, int flag) {

		int[] height = new int[n+1];
		boolean[] visit = new boolean[n+1];

		for (int i=1; i<=n; i++) {
			if (flag == 0) {
				//?—´ ì²´í¬
				height[i] = map[x][i];
			} else {
				//?–‰ ì²´í¬
				height[i] = map[i][y];
			}
		}

		for (int i=1; i<n; i++) {

			if (height[i] == height[i+1]) {

				continue;

			} else if (height[i]-1 == height[i+1]) {
				//?‚´ë¦¬ë§‰
				//?™¼ -> ?˜¤ë¥¸ìª½

				for (int j=i+1; j<i+1+l; j++) {
					if (j > n) {
						return false;
					}
					if (visit[j]) {
						return false;
					}
					if (height[i+1] != height[j]) {
						return false;
					}
					visit[j] = true;
				}

			} else if (height[i]+1 == height[i+1]) {
				//?˜¤ë¥´ë§‰
				//?˜¤ë¥¸ìª½ -> ?™¼ìª?
				for (int j=i; j>i-l; j--) {
					if (j < 1) {
						return false;
					}
					if (visit[j]) {
						return false;
					}
					if (height[i] != height[j]) {
						//?˜„?¬ ?œ„ì¹˜ê? ê²½ì‚¬ë¡œë?? ?„¤ì¹˜í•´?•¼?•˜?Š” ?œ„ì¹˜ì´ê¸? ?–„ë¬¸ì— ?†’?´ê°? ê°™ì?ì§? ë¹„êµ
						return false;
					}
					visit[j] = true;
				}

			} else {
				return false;
			}
		}
		return true;
	}//check

}
