package gwonjihun.codetree;

import java.io.*;
import java.util.*;

import gwonjihun.codetree.Main_싸움땅_fail.person;

public class Main_싸움땅_suc {
	static class person {
		int x, y, ablity, dir, gun;

		public person(int x, int y, int dir, int ablity, int gun) {
			super();
			this.x = x;
			this.y = y;
			this.ablity = ablity;
			this.dir = dir;
			this.gun = gun;
		}

		@Override
		public boolean equals(Object obj) {
			person other = (person) obj;
			if (x == other.x && y == other.y) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "person [x=" + x + ", y=" + y + ", ablity=" + ablity + ", dir=" + dir + ", gun=" + gun + "]\n";
		}

	}

	static ArrayList<Integer>[][] map;
	static person[] p_l;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int[] point;
	static int n, m, k;// n : 맵 크키 , m은 플레이어수 k는 턴 수
///로 ↑, →, ↓, ←을 의미

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p_l = new person[m];
		point = new int[m];
		map = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp != 0) {
					map[i][j].add(tmp);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());// 방향
			int s = Integer.parseInt(st.nextToken()); // 능력치
			p_l[i] = new person(x, y, d, s, 0);

		}
		System.out.println(Arrays.toString(p_l));
		for (int i = 0; i < k; i++) {
			System.out.println("round :: " + i);
			simulation();
		}

		answer();
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	// 왼 위 오 아
	static int weapon(int x, int y) {
		ArrayList<Integer> guns = map[x][y];
		if (guns.size() == 0)
			return -1;
		if (guns.size() > 1) {
			Collections.sort(guns, (o1, o2) -> Integer.compare(o1, o2));
			for (int a : guns) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		// 이걸로 최대값 찾았음.
		int result = guns.get(guns.size() - 1);
		guns.remove(guns.size() - 1);
		return result;
	}

	static void drop(int x, int y, int gun) {

		ArrayList<Integer> guns = map[x][y];
		guns.add(gun);
	}

	static void simulation() {
		for (int i = 0; i < m; i++) {
			person cur_p = p_l[i];
			int[] next_p = move(cur_p);
			int dup_per = find(next_p);
			if (dup_per == -1) {
				int wp = weapon(next_p[0], next_p[1]);
				if (wp != -1) {// 무기가 없으면 -1 
					if (cur_p.gun < wp) {
						if (cur_p.gun != 0)
							drop(next_p[0], next_p[1], cur_p.gun);
						// 총을 내려놓음
						cur_p.gun = wp;
					} else {
						drop(next_p[0], next_p[1], wp);
					}
				}
				p_l[i] = new person(next_p[0], next_p[1], next_p[2], cur_p.ablity, cur_p.gun);
				// 먼저 가장 큰 총을 찾는다
				// 가장
			} else {

				// 이제 여기서는 싸워야함...
				p_l[i] = new person(next_p[0], next_p[1], next_p[2], cur_p.ablity, cur_p.gun);
				//
				System.out.println(i + " vs " + dup_per + " 대결전");

				System.out.println(Arrays.toString(p_l));
				fight(i, dup_per);
			}

			System.out.println(i + "번째 사람 이동 종료");
			System.out.println(Arrays.toString(p_l));
		}

	}

	static void fight(int idx1, int idx2) {
		int pl_1_A = p_l[idx1].ablity + p_l[idx1].gun;
		int pl_2_A = p_l[idx2].ablity + p_l[idx2].gun;
		if (pl_1_A > pl_2_A) {
			System.out.println("111");
			lose(idx2);
			win(idx1);
			point[idx1] += (pl_1_A - pl_2_A);
		} else if (pl_1_A < pl_2_A) {
			System.out.println("222");
			lose(idx1);
			win(idx2);
			point[idx2] += (pl_2_A - pl_1_A);
		} else {
			if (p_l[idx1].ablity > p_l[idx2].ablity) {
				System.out.println("333");
				lose(idx2);
				win(idx1);
			} else if(p_l[idx1].ablity < p_l[idx2].ablity){
				System.out.println("444");
				lose(idx1);
				win(idx2);
			}
		}
		System.out.println(Arrays.toString(point));
	}

	static void lose(int idx) {
		int cx = p_l[idx].x;
		int cy = p_l[idx].y;
		int cd = p_l[idx].dir;
		if (p_l[idx].gun != 0) {
			map[cx][cy].add(p_l[idx].gun);
			p_l[idx].gun = 0;
		}
		int nx;
		int ny;
		while (true) {
			nx = cx + dx[cd];
			ny = cy + dy[cd];
			if (inRange(nx, ny) && find(new int[] { nx, ny }) == -1) {
				break;
			}
			cd = (cd + 1) % 4;
		}
		int gun = weapon(nx, ny);

		System.out.println(nx + " " + ny + " " + cd );
		// 총을 줍는다.
		if (gun <= 0)
			gun = 0;
		p_l[idx] = new person(nx, ny, cd, p_l[idx].ablity, gun);
	}

	static void win(int idx) {
		int gun = weapon(p_l[idx].x, p_l[idx].y);
		if (p_l[idx].gun < gun) {
			if (p_l[idx].gun != 0)
				drop(p_l[idx].x, p_l[idx].y, p_l[idx].gun);
			// 총을 내려놓음
			p_l[idx].gun = gun;
		} else {
			drop(p_l[idx].x, p_l[idx].y, gun);
		}
//		if(p_l[idx].gun<wp) {
//			if(p_l[idx].gun!=0) drop(next_p[0],next_p[1],cur_p.gun);
//			//총을 내려놓음
//			p_l[idx].gun = wp;
//		}else{
//			drop(next_p[0],next_p[1],wp);
//		}
	}

	static int find(int[] p) {
		int x = p[0];
		int y = p[1];
		for (int i = 0; i < m; i++) {
			if (p_l[i].x == x && p_l[i].y == y) {
				return i;
			}
		}
		return -1;
	}

	static int[] move(person p) {
		int cx = p.x;
		int cy = p.y;
		int dr = p.dir;
		int nx = cx + dx[dr];
		int ny = cy + dy[dr];
		if (!inRange(nx, ny)) {
			dr = (dr + 2) % 4;
			nx = cx + dx[dr];
			ny = cy + dy[dr];
		}
		return new int[] { nx, ny, dr };
	}

	static void answer() {
		for (int a : point)
			System.out.print(a + " ");
		System.out.println();
	}
}
