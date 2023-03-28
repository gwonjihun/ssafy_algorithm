package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_20056_상어와파이어볼2_fail {
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

		N = Integer.parseInt(st.nextToken());// 배열?�� ?���?
		M = Integer.parseInt(st.nextToken());// ?��?�� ?��?��?���? �??��
		K = Integer.parseInt(st.nextToken());// ?��?�� ?��?��

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
		// ?��?��
		int cnt = 0;
		for (int k = 0; k < K; k++) {
			List<fireball>[][] temp = new ArrayList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = new ArrayList<fireball>();
				}
			} // ?��?��?�� 결과�? ???��?���? ?��?�� temp LIST
			//
			// k?�� ?���?
			// temp�? ?��?��?��
			// 먼�? temp �? ?��?��?�� ?��?��?��볼을 ?��?�� ?��?��?�� ?��?�� map?��?���? temp ?��?��주기
			//
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!map[i][j].isEmpty()) {
						for (int idx = 0; idx < map[i][j].size(); idx++) {
							fireball cur = map[i][j].get(idx);
							int nx = (N + i + dx[cur.d] * (cur.s % N)) % N;
							int ny = (N + j + dy[cur.d] * (cur.s % N)) % N;
							temp[nx][ny].add(new fireball(cur.m, cur.s, cur.d));
							// ?��?��만큼 ?��?���?�?


						}
					}
				}
			} // ?��?��?�� 볼의 ?��?��

			for(int i=0;i<N;i++) {
				for(int j = 0; j<N;j++) {
					map[i][j] = temp[i][j];
				}
			}// 갱신까�??�� 문제�? ?��?��

			
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
						//?��차피 1개인 곳�? ?��?���??�� ?��?��?�� ?��?��?��?���? �??���??�� ?��?��.
						
						
					}
					
				}
			}// 갱신까�??�� 문제�? ?��?��
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
