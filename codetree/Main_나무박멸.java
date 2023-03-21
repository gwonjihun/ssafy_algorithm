package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_나무박멸 {
	static int[][] tree, temp, drag;// 초기, 번식
	static int[] cdx = { 1, 1, -1, -1 }, cdy = { 1, -1, 1, -1 };
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int n, m, k, c;// n맵크기,m 박멸이 진행되는 년수, k 범위 , c 잔여년도
	static int Max_cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		tree = new int[n][n];
		drag = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			simulation();
		}

		System.out.println(Max_cnt);

	}

	static void simulation() {
		grow();
		for (int[] a : tree) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("-------성장 후-------");
		spread();
		for (int[] a : tree) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("-------확산 후--------");
		draged();
		for (int[] a : drag) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("-------제초제 뿌린 후--------");
		for (int[] a : tree) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("------제초 이후---------");
	}

	static void draged() {
		int temp_max = 0;
		int temp_x = 0, temp_y = 0;// 제초제가뿌려지기 시작하는 위치
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tree[i][j] <= 0)
					continue;
				int cnt = tree[i][j];//
				for (int d = 0; d < 4; d++) {
					for (int l = 1; l <= k; l++) {
						int nx = i + cdx[d] * l;
						int ny = j + cdy[d] * l;
						if (!inRange(nx, ny))
							break;
						if (tree[nx][ny] <=0)
							break;
						cnt += tree[nx][ny];
					}
				}

				if (temp_max < cnt) {
					temp_max = cnt;
					temp_x = i;
					temp_y = j;
				}
			}
		}
		
		//제초제 수명 감소
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (drag[i][j] > 0) {
					drag[i][j]--;
				}
			}
		}

		Max_cnt += temp_max;
		System.out.println("제초제를 뿌린 지점  : (X,Y) : " +"( " + temp_x + " , " + temp_y +" )");
		if (tree[temp_x][temp_y] > 0) {
			tree[temp_x][temp_y] = 0;
			drag[temp_x][temp_y] = c;
			for (int d = 0; d < 4; d++) {
				for (int l = 1; l <= k; l++) {
					System.out.println("d: " + d);
					int nx = temp_x + (cdx[d] * l);
					int ny = temp_y + (cdy[d] * l);
					if (!inRange(nx, ny)) break;
					
					if (tree[nx][ny] == 0) {
						drag[nx][ny] = c;
						break;
					}
					
					if (tree[nx][ny] <= -1) break;


					// 확산할때 먼저 0이나 -1을 만나면 멈춰줘야한다.
					tree[nx][ny] = 0;
					drag[nx][ny] = c;

				}
			}
		}
	}

	static void spread() {
		temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tree[i][j] <= 0)
					continue;
				// 여기서 제초제가 있다는 뜻은 결국 나무가 0이될테닌깐 필요없음
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (!inRange(nx, ny))
						continue;
					if (drag[nx][ny] > 0 || tree[nx][ny] != 0)
						continue;
					cnt += 1;
				}

				if (cnt == 0)
					continue;
				int temps = tree[i][j] / cnt;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (!inRange(nx, ny))
						continue;
					if (drag[nx][ny] > 0 || tree[nx][ny] != 0)
						continue;
					temp[nx][ny] += temps;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				tree[i][j] += temp[i][j];
			}
		}

		// 이제는 동시에 해줘야하닌깐 temp가 필요
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	static void grow() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tree[i][j] <= 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (!inRange(nx, ny))
						continue;
					if (tree[nx][ny] > 0) {
						tree[i][j] += 1;
					}
				}
			}
		}
//		for(int[] a : tree) {
//			System.out.println(Arrays.toString(a));
//		}System.out.println("--------------");
	}
}
