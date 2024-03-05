package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * 최대 15 * 15 이고 최대 십자가의 크기는  (N-x, x)의 최소화 (M-y,y)의 최소 중 
 * 최소값이 십자가의 한계를 찾아놔준다.  
 * 
 */
public class Main_boj_17085 {

	static int max = 1;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int N, M;
	static char[][] arr;
	static int size;
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		size = Math.min(N / 2, M / 2);
		v = new boolean[N][M];
		if (M == 2 && N == 2) {
			System.out.println(1);
			return;
		}
		dfs(0, 1);
		System.out.println(max);
	}

	static void dfs(int depth, int sum) {
		if (depth == 2) {
//			for(int z = 0 ; z < N ; z++) {
//				System.out.println(Arrays.toString(v[z]));
//			}
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
			max = Math.max(sum, max);
			return;
		}
//
//		for(int z = 0 ; z < N ; z++) {
//			System.out.println(Arrays.toString(v[z]));
//		}
//		System.out.println("!!!!!!!!!!!!");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// i,j가 중심이되어서 진행되는데
				if (v[i][j] || arr[i][j] != '#')
					continue;
				int minSize = size;
				for (int d = 0; d < 4; d++) {
					if (minSize == 0)
						break;
					int len = 0;
					while (true) {
						int nx = i + dx[d] * (len + 1);
						int ny = j + dy[d] * (len + 1);
						// 이렇게한다면
						if (0 > nx || nx >= N || 0 > ny || ny >= M || v[nx][ny] || arr[nx][ny] != '#') {
							break;
						}
						len += 1;
					}
					minSize = Math.min(minSize, len);
//					System.out.println(len);
				}
//				System.out.println(depth + " " + sum + " " + minSize + " " + i + " " + j);
				// 사이즈를 찾은다음에 십자가를 박았다는 v를 만들어준다.
				// 그리고서 dfs에서는 depth +!, sum*(1+size*4)를 해준다.
				for (int s = minSize; s >= 0; s--) {
					v = visited(i, j, s);
					
//					System.out.println(depth + " " + sum + " " + s + " " + i + " " + j);
					dfs(depth + 1, sum * (1 + s * 4));
					v = visitedEnd(i, j, s);
				}
			}
		}
	}
//1 ,5 ,9, 13
	static boolean[][] visited(int x, int y, int sizes ) {
		v[x][y] = true;
		for (int d = 0; d < 4; d++) {
			for (int l = sizes; l > 0; l--) {
				int nx = x + (dx[d] * l);
				int ny = y + (dy[d] * l);
				v[nx][ny] = true;
			}
		}
		return v;
	}
	static boolean[][] visitedEnd(int x, int y, int sizes) {
		v[x][y] = false;
		for (int d = 0; d < 4; d++) {
			for (int l= sizes; l > 0; l--) {
				int nx = x + (dx[d] * l);
				int ny = y + (dy[d] * l);
				v[nx][ny] = false;
			}
		}
		return v;
	}
}
