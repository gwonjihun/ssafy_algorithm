package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_16919_붐버맨 {

	static char[][] map;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] time;
	static int R, C, N, times;
	// 1초는 초기값
	// 2초일때는 전부다 채움
	// 3초일때는 폭바
	// 4초일때는 뭔데..
	// 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		time = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'O')
					time[i][j] = 3;
			}
		}
		times = 1;
		while (times < N) {
			fill_o();
			times++;
			down();
			if (times >= N) {
				break;
			}
			boom();
			times++;			
			down();
		}
	}

	static void boom() {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
			}
		}
	}

	static void down() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (time[i][j] > 0) {
					time[i][j]--;
				}
			}
		}
	}

	static void fill_o() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					time[i][j] = 3;
					map[i][j] = 'O';
				}
			}
		}
	}

	static void print() {
		for (char[] a : map) {
			for (char b : a)
				System.out.print(a);
		}
		System.out.println();
	}
}
