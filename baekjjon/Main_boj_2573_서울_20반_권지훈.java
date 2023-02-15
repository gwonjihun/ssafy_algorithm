package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;

/* 접근 방식 
 * 구현 해야하는 목록 : 덩어리가 되었는가 / 1년이 지날때 소금이 녹는 부분
 * 1. 얼음인지 아니니지 전체를 확인한다.
 * 2. 얼음을 덩어리에 맞춰서 녹인다.
 * 3. 얼음의 덩어리가 2개 이상인지를 체크한다.
 * */
public class Main_boj_2573_서울_20반_권지훈 {
	static int[][] arr;
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; M++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		int year = 0;

		while (cnt == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; M++) {
					bfs
				}
			}
		}

		if (cnt == 0) {
			System.out.println(0);
		} else {
			System.out.println(year);
		}
	}
}
