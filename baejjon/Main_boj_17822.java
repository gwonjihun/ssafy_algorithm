package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17822 {

	static int N, M, K;// K는 회전 명령의 횟수
	static int[][] circle;// 0은 없어진 녀석들이다.[1,2,3,4]순서로 진행된다는 뜻이닌깐.
	// 시계방향 회전은 [4,1,2,3], 반시계 [2,3,4,1] 이다.
	static boolean[][] v;//
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	// r은 +-1이 되는것이고 r이 0일떄는 N-1로 가는 것이 아닌 1만 인접
	// c는 +-1이 인접이고 c가 0일때는 c+1, M-1과 인접한다. 그래서 nx를 계산할때 잘 계산해줘야한다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		circle = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			rotates(n, dir, k);

			discard();
//			rotates(n, -dir, k);

		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(circle[i]));
			for (int j = 0; j < M; j++) {
				sum += circle[i][j];
			}
		}
		System.out.println(sum);
	}

	static void discard() {
		boolean change = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if(circle[i][j]==0) continue;
				int target = circle[i][j];
				int cnt = 0;
				Deque<int[]> q  =new ArrayDeque<>();
				q.add(new int[] {i,j});
				circle[i][j] = 0;
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					for(int d = 0; d<4; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if(ny== M) {
							ny = 0;
						}
						if(ny== -1) {
							ny = M-1;
						}
						if(!(0<=nx&&nx<N)) {
							continue;
						}
						if(circle[nx][ny]==target) {
							q.add(new int[] {nx,ny});
							circle[nx][ny]=0;
							cnt+=1;
							change = true;
						}
					}
				}
				
				if(cnt==0) {
					circle[i][j] = target;
				}
			}
		}
		if (!change) {
			cal();
		}
	}

	static void cal() {
		float sum = 0f;
		float cnt = 0f;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle[i][j] != 0) {
					sum += circle[i][j] + 0f;
					cnt += 1f;
				}
			}
		}
		if (cnt <= 0) {
			return;
		}
		float avg = sum / cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(circle[i][j]==0||circle[i][j]==avg) continue;
				circle[i][j] += circle[i][j] > avg ? -1 : 1;
			}
		}
	}

	static void rotates(int n, int dir, int k) {
//		System.out.println(n + " " + dir + " " + k);
		for (int j = n - 1; j < N; j += n) {

			for (int i = 0; i < k; i++) {
				rotate(j, dir);
			}
//			System.out.println(j);
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(circle[i]));
//			}
//			System.out.println("____________________");
		}
	}

	static void rotate(int n, int dir) {
		if (dir == 0) {
			// 시계 방향
			int temp = circle[n][M - 1];
			for (int i = M - 1; i > 0; i--) {
				circle[n][i] = circle[n][i - 1];
			}
			circle[n][0] = temp;
		} else {
			// 반시계 방향
			int temp = circle[n][0];
			for (int i = 0; i < M - 1; i++) {
				circle[n][i] = circle[n][i + 1];
			}
			circle[n][M - 1] = temp;
		}
	}

}
