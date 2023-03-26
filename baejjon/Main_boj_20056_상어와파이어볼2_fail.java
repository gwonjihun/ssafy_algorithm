package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_20056_?ƒ?–´???ŒŒ?´?–´ë³?2_fail {
	static int N, M, K;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class fireball {

		int m;
		int s;
		int d;

		fireball(int m, int s, int d) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}

	static List<fireball>[][] map;

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
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[x][y].add(new fireball(m, s, d));
		}
		// ?´? œ
		int cnt = 0;
		for (int k = 0; k < K; k++) {
			List<fireball>[][] temp = new ArrayList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = new ArrayList<fireball>();
				}
			} // ?´?™?œ ê²°ê³¼ë¥? ???¥?•˜ê¸? ?œ„?•œ temp LIST
			//
			// k?Š” ?‹œê°?
			// tempë¥? ?†µ?•´?„œ
			// ë¨¼ì? temp ë¥? ?†µ?•´?„œ ?ŒŒ?´?–´ë³¼ì„ ?´?™ ?‹œ?‚¨?›„ ?›?˜ map?—?‹¤ê°? temp ?„£?–´ì£¼ê¸°
			//
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!map[i][j].isEmpty()) {
						for (int idx = 0; idx < map[i][j].size(); idx++) {
							fireball cur = map[i][j].get(idx);
							int nx = (N + i + dx[cur.d] * (cur.s % N)) % N;
							int ny = (N + j + dy[cur.d] * (cur.s % N)) % N;
							temp[nx][ny].add(new fireball(cur.m, cur.s, cur.d));
							// ?šŸ?ˆ˜ë§Œí¼ ?“¤?–´ê°?ì§?


						}
					}
				}
			} // ?ŒŒ?´?–´ ë³¼ì˜ ?´?™

			for(int i=0;i<N;i++) {
				for(int j = 0; j<N;j++) {
					map[i][j] = temp[i][j];
				}
			}// ê°±ì‹ ê¹Œì??Š” ë¬¸ì œê°? ?—†?Œ

			
			for(int i=0;i<N;i++) {
				for(int j = 0; j<N;j++) {
					if(map[i][j].size()>1) {
						int Sum_m=0;
						int Sum_s=0;
						int cnt_od = 0;
						int cnt_even = 0;
						for(int idx = 0 ; idx<map[i][j].size();idx++) {
							Sum_m += map[i][j].get(idx).m;
							Sum_s += map[i][j].get(idx).s;//
							if(map[i][j].get(idx).d%2 == 1) {
								cnt_od +=1;
							}else {
								cnt_even+=1;
							}
						}
						int sizes = map[i][j].size();
						map[i][j].clear();
						int m = Sum_m/5;
						int s = Sum_s/sizes;
						if(m>0) {
						if(cnt_od==sizes || cnt_even == sizes) {
							for(int cs = 0 ; cs<8;cs+=2) {
								map[i][j].add(new fireball(m, s, cs));
							}
						}else {

							for(int cs = 1 ; cs<8;cs+=2) {
								map[i][j].add(new fireball(m, s, cs));
							}
						}
						}
						//?–´ì°¨í”¼ 1ê°œì¸ ê³³ì? ?œ„?—ê°??„œ ?•Œ?•„?„œ ?´?™?•˜?‹Œê¹? ì§??‚˜ê°??„ ?œ?‹¤.
						
						
					}
					
				}
			}// ê°±ì‹ ê¹Œì??Š” ë¬¸ì œê°? ?—†?Œ
			cnt = check();
			if (cnt == 0) {
				break;
			}

		}
		System.out.println(cnt);
	}

	static int check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != null) {
					for (int idx = 0; idx < map[i][j].size(); idx++) {
						cnt += map[i][j].get(idx).m;
					}
				}
			}
		}
		return cnt;
	}
}
