package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_21610_서울_20반_권지훈_tring {
	static class cloud {
		int x;
		int y;
		int d;
		int s;

		cloud(int x, int y, int d, int s) {
			this.x = x;
			this.y = y;
			this.d = d;// 방향
			this.s = s;// 속도
		}
	}

	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }, dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] check = { 2, 4, 6, 8 };
	static int[][] cmd, map;
	static boolean[][] v; // 해당 시간에 내려온 위치
	static Deque<cloud> q; // 이걸로 반복해버리면되닌깐.
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		v = new boolean[N][N];
		cmd = new int[M][2]; // 0은방향 1은속도
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
			// 방향
			cmd[i][1] = Integer.parseInt(st.nextToken());
			// 속도
		}
		q.addLast(new cloud(N - 1, 0, cmd[0][0], cmd[0][1]));
		q.addLast(new cloud(N - 2, 0, cmd[0][0], cmd[0][1]));
		q.addLast(new cloud(N - 1, 1, cmd[0][0], cmd[0][1]));
		q.addLast(new cloud(N - 2, 1, cmd[0][0], cmd[0][1]));
		// 여기서 구름을 선택했고?
		// 여기서부터
		// 초기 구름 입력
		while (!q.isEmpty()) {
			cloud cur = q.poll();
			int nx = (N + cur.x + dx[cur.d] * (cur.s % N)) % N;
			int ny = (N + cur.y + dy[cur.d] * (cur.s % N)) % N;
			System.out.println(nx + " " + ny);

			map[nx][ny] += 1;
			v[nx][ny] = true;

		} // 여기서 비내리고
			// 초기 구름 비가 낼
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
		} // 물복사
		//여기까지는 완벽해
		
		
		for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("----------1차전 종료");
		
		
		for (int Time = 1; Time <= M; Time++) {
			// 물복사 버그가 미구현되어있음.
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 2 && !v[i][j]) {

						map[i][j] -= 2;
						if(Time!=M) q.add(new cloud(i, j, cmd[Time][0], cmd[Time][1]));
					}
				}
			} // 여기서 비내리고
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
			} // 물복사
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

			// 구름을 움직인뒤
			// 비를 내리고 비가 온 곳을 확인한다.-> boolean배열 초기화 후에 진행
		}
		for(int[] a: map) {
			System.out.println(Arrays.toString(a));
		}System.out.println("------최종 구름 상태");
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += map[i][j];
			}
		}
		System.out.println(cnt);

	}
}
