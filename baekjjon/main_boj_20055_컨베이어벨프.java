package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class main_boj_20055_컨베이어벨프 {

	static class robot {
		int x;

		robot(int x) {
			this.x = x;
		}
	}

	static int[][] balt;
	static int N, K;
	static Deque<robot> q;
	static int step = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		balt = new int[2][N];
		for(int a = 0; a < 2;a++) {
		for (int i = 0; i < N; i++) {
			balt[a][i] = Integer.parseInt(st.nextToken());
		}
		}

		q = new ArrayDeque<>();
		int cnt = 0;
		while (cnt < K) {

			for(int[] bal : balt)
			System.out.println(Arrays.toString(bal));
			System.out.println("__________________________");
			cnt = 0; // 0인 벨트 갯수 확인
			rotate();
			int idx = q.size();
			//로봇 이동시키는 for문
			for (int i = idx - 1; i >= 0; i--) {
				robot ro = q.pollLast(); // 가장 먼저 올라간 로봇부터이고
				if(q.isEmpty()) {
					if(ro.x+1==N-1&& balt[0][ro.x+1]>0) {
						balt[0][ro.x+1]-=1;
					}else if(ro.x+1!=N-1&& balt[0][ro.x+1]>0) {
						balt[0][ro.x+1]-=1;
						ro.x-=1;
						q.offerFirst(ro);
					}
				}else {// 로봇이 2개이상일때
					if(ro.x+1==N-1&& balt[0][ro.x+1]>0) {
						balt[0][ro.x+1]-=1;
					}else if(ro.x+1!=N-1&& balt[0][ro.x+1]>0 && ro.x+1 != q.peekFirst().x) {
						balt[0][ro.x+1]-=1;
						ro.x-=1;
						q.offerFirst(ro);
					}
				}
				
				
			} // 여기서 로봇을 이동한다.
			if(balt[0][0]>=1) {
				q.offerFirst(new robot(0));
				balt[0][0]--;
			}
			
			//0인곳을 확인하는 부분
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					if (balt[i][j] <1) {
						cnt++;
					}
				}
			}
			if (cnt >= K) {
				break;
			} // 여기서 중단을 안시키면? 결과가 항상 1보다 클 것이다.
			step+=1;
			System.out.println(step);
		}
		System.out.println(step);
	}

	static void rotate() {
		// 배열을 회전 시켜주고
		// 로봇의 x값을 증가시켜주는데
		// x가 N-1이되면 바로 q에서 빼줘야한다.
		int idx = q.size();
		for (int i = idx - 1; i >= 0; i--) {
			robot ro = q.pollLast();
			ro.x += 1;
			if (ro.x != N - 1) {
				q.offerFirst(ro);
			}
		} // 여기서 로봇을 이동한다.
		int temp_N = balt[0][N - 1];
		for (int i = N - 1; i > 0; i--) {
			balt[0][i] = balt[0][i - 1];
		}

		int temp_0 = balt[1][0];
		for (int i = 0; i < N - 1; i++) {
			balt[1][i] = balt[1][i + 1];
		}
		balt[1][N - 1] = temp_N;
		balt[0][0] = temp_0;
	}
}
