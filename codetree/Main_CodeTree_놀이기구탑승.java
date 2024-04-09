package gwonjihun.codetree;

import java.io.*;
import java.util.*;

/*
 * x,y로 순회하면서 1. 인접한 칸에 친구의 수를 계산합니다.
 * 2. 같은 값이 나왔다면? 그땐 인접한 칸의 비어있는 칸수를 각각을 구한뒤 비교합니다.
 * 3. 그래도 같으면 행 작 열 작  순서로 비교해줍니다.
 * */
public class Main_CodeTree_놀이기구탑승 {
	static class Info {
		int f, e;// f : 인접한 친구수 ,

	}

	static HashMap<Integer, int[]> list;
	static int n;
	static int[] scr = { 0, 1, 10, 100, 1000 };
	static int[][] seat;// 앉아있는 녀석들 번호를 의미합니다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new HashMap<>();
		seat = new int[n][n];
		for (int i = 0; i < n * n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int[] fri = new int[4];
			for (int f = 0; f < 4; f++) {
				fri[f] = Integer.parseInt(st.nextToken());
			}
			list.put(start, fri);
			int fx = -1, fy = -1;
			int fcnt = -1, fempty = -1;
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (seat[x][y] != 0)
						continue;
					int[] re = cntFE(x, y, start);
					if (fcnt < re[0]) {
						fx = x;
						fy = y;
						fcnt = re[0];
						fempty = re[1];
					} else if (fcnt == re[0]) {
						if (fempty == re[1]) {
							if (fx == x) {
								if (fy > y) {
									fy = y;

								}
							}else if (fx>x){
								fx =x;
								fy =y;
							}
						}else if(fempty <re[1]) {

							fx = x;
							fy = y;
							fempty = re[1];
						}
					}
				}
			}
			seat[fx][fy] = start;
		}

		finish();

	}

	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	static int[] cntFE(int x, int y, int num) {
		int[] fris = list.get(num);
		int[] result = new int[] { 0, 0 };
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!inRange(nx, ny))
				continue;
			if (seat[nx][ny] != 0) {
				for (int i = 0; i < 4; i++) {
					if (fris[i] == seat[nx][ny]) {
						result[0] += 1;
					}
				}
			} else {
				result[1] += 1;
			}
		}
		return result;
	}

	static void finish() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int[] fri = list.get(seat[i][j]);
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (!inRange(nx, ny))
						continue;
					for (int f = 0; f < 4; f++) {
						if (fri[f] == seat[nx][ny]) {
							cnt += 1;
						}
					}
				}
				result += scr[cnt];
			}
		}
		System.out.println(result);
	}

}
