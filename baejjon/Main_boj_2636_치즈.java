package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

//0. 데이터 입력받을때  1의 값을 기준으로 cnt를 초기화해주고
//
//1. 오염공기를 BFS로 -1로 전환해준다.
//2. 4방탐색해서 -1이 1개라도 있으면 0으로 전환해준다 그러면서 temp_cnt로 카운트증가시켜준다.
//3. cnt != temp_cnt이면 아직 모두 녹기전 1시간 타임이 아니닌깐 cnt -=temp_cnt로 빼주고
//4. temp_map을 
public class Main_boj_2636_치즈 {
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] map, temp;
	static int cnt = 0, time, m, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		time = 0;
		while (true) {
			time++;
			int temp_cnt = 0;
			check_air();// 이걸로 대기중 오염공기 체크
			temp_cnt = melting();
//			print();
//			check_air();// 이걸로 대기중 오염공기 체크
//			System.out.println("------------------");
//			print();
			
			if (cnt == temp_cnt) {
				System.out.println(time);
				System.out.println(temp_cnt);
                break;
			} else {
				cnt-=temp_cnt;
			}
		}

	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	static int melting() {
		int cnts = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (map[nx][ny] == -1) {
							map[i][j] = 0;
							cnts++;
							break;
						}
					}

				}
			}
		}

		return cnts;
	}

	static void check_air() {
		boolean[][] v = new boolean[n][m];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		v[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = -1;
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (inRange(nx, ny) && !v[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == -1)) {
					v[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}

			}
		}
	}

//	static void print() {
//		for (int[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}
//	}
}