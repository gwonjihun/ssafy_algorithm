package gwonjihun.codetree;

import java.io.*;
import java.util.*;
/*
4 3
4 4
2 2 7
4 4 7
4 2 8
1 3 5
*/
public class Main_codeTree_팩맨 {

	static int m, t;

	static List<Integer>[][] list;
	static List<Integer>[][] egg;
	static int[][] die;// 무조건 2를 해주고 턴마다 1씩 감소해준다.
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static int px, py;
	static int[] ddx = { -1, 0, 1, 0 }, ddy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		die = new int[4][4];
		list = new List[4][4];
		egg = new List[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				list[i][j] = new ArrayList<>();
				egg[i][j] = new ArrayList<>();
			}
		}
		st = new StringTokenizer(br.readLine());
		px = Integer.parseInt(st.nextToken()) - 1;
		py = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;

			list[x][y].add(d);
		}

		for (int T = 0; T < t; T++) {
			copy();
			move();
//			System.out.println("move");
//			print();
			packman();
//			System.out.println("packman");
//			print();
			down();
//			System.out.println("dwon");
//			print();
			finish();
//			System.out.println("finish");
//			print();
		}
		System.out.println(count());
//
	}

	static void finish() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int d : egg[i][j]) {
					list[i][j].add(d);
				}
				egg[i][j].clear();
			}
		}
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < 4 && 0 <= y && y < 4;
	}

	static void packman() {
//		boolean[][] v = new boolean[4][4]
		int[] route = new int[3];
		int max = -1;
		for (int r1 = 0; r1 < 4; r1++) {
			int x1 = px + ddx[r1];
			int y1 = py + ddy[r1];

			if (!inRange(x1, y1))
				continue;
			int cnt = 0;
			for (int r2 = 0; r2 < 4; r2++) {
				int x2 = x1 + ddx[r2];
				int y2 = y1 + ddy[r2];
				if (!inRange(x2, y2))
					continue;
				for (int r3 = 0; r3 < 4; r3++) {
					int x3 = x2 + ddx[r3];
					int y3 = y2 + ddy[r3];
					if (!inRange(x3, y3))
						continue;
					cnt= list[x1][y1].size()+list[x2][y2].size()+ (x3==x1&&y3==y1? 0 : list[x3][y3].size());
					if (cnt > max) {
//						System.out.println(cnt);
						max = cnt;
						route = new int[] { r1, r2, r3 };
					}
				}
			}
		}
//		System.out.println(Arrays.toString(route));
		// 최종 루트를 찾은다음에 해당 루트로 이동하면서 팩맥들을 die로 전환 시켜주면된다.
		for (int i = 0; i < 3; i++) {
			px = px + ddx[route[i]];
			py = py + ddy[route[i]];
//			System.out.println(px + "- " + py);
			if (list[px][py].size() > 0) {
				die[px][py] = 3;
				list[px][py].clear();
			}
		}
	}

	static void print() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(list[i][j].size()==0) System.out.print(-1);
				if(i==px && j == py) System.out.print("@");
				for(int d : list[i][j]) {
				System.out.print(d );}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println(px+" "+py);
		System.out.println("____________________________");
		
	}

	static void move() {
		List<Integer>[][] temp = new List[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int size = list[i][j].size();
				for (int s = 0; s < size; s++) {
					int dir = list[i][j].get(s);
					boolean flag = true;
					for (int d = 0; d < 8; d++) {
						int ds = (dir + d) % 8;
						int nx = i + dx[ds];
						int ny = j + dy[ds];
						if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && die[nx][ny] < 1 && (px != nx || py != ny)) {
							temp[nx][ny].add(ds);
							flag = false;
							dir = ds;
							break;
						}
//						else {
//							System.out.println(i+" " + j+" "+"rotate");
//						}
					}
					if (flag) {
						temp[i][j].add(dir);
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				list[i][j] = temp[i][j];
			}
		}
	}

	static void copy() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				egg[i][j].clear();
				for (int d : list[i][j]) {
					egg[i][j].add(d);
				}
			}
		}
	}

	static int count() {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cnt += list[i][j].size();
			}
		}
		return cnt;
	}

	static void down() {
		// 소멸 시기를 감소해준다
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (die[i][j] > 0)
					die[i][j]--;
			}
		}
	}
}
