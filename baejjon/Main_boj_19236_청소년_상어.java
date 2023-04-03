package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_19236_청소년_상어 {

	static class Shark {
		int x;
		int y;
		int dir;
		int eat;

		public Shark(int x, int y, int eat, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.eat = eat;
		}

	}

	static class Fish implements Comparable<Fish> {
		int x, y, n, dir;
		boolean die;

		public Fish(int x, int y, int n, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.n = n;
			this.dir = dir;
		}

		@Override
		public int compareTo(Fish o) {
			// TODO Auto-generated method stub
			return this.n - o.n;
		}

	}

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static List<Fish> fishs;
	static Shark shark;
	static int[][] map = new int[4][4];
	static int Max_eat = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				fishs.add(new Fish(i, j, num, dir));
				map[i][j] = num;
			}
		}

		Collections.sort(fishs);

		Fish f = fishs.get(map[0][0] - 1);
		f.die = true;
		shark = new Shark(0, 0, f.n, f.dir);
		map[0][0] = -1;
		dfs(map, shark, fishs);
		System.out.println(Max_eat);

	}

	static void dfs(int[][] graph, Shark sh, List<Fish> fis) {
		if (Max_eat < sh.eat) {
			Max_eat = sh.eat;
		}
		// 먹은 개수 최대값이랑 비교하기
		// 물고기 이동
		for (Fish a : fishs) {
			movefish(a, graph, fis);
		}
		//
		for (int i = 1; i < 4; i++) {
			// 상어가 최대 4칸 이동가능함.
			sh.x = sh.x + dx[sh.dir] * i;
			sh.y = sh.y + dy[sh.dir] * i;
		}
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < 4 && 0 <= y && y < 4;
	}

	static void movefish(Fish fish, int[][] gra, List<Fish> list) {
		if (fish.die)
			return;
		for (int i = 0; i < 8; i++) {
			int nextdir = (fish.dir + i) % 8;
			int nx = fish.x + dx[fish.dir];
			int ny = fish.y + dy[fish.dir];

			if (inRange(nx, ny) && gra[nx][ny] > -1) {
				gra[fish.x][fish.y] = 0;

				if (gra[nx][ny] == 0) {
					fish.x = nx;
					fish.y = ny;
				} else {
					Fish temp = list.get(gra[nx][ny] - 1);
					temp.x = fish.x;
					temp.y = fish.y;
					gra[fish.x][fish.y] = temp.n;

					fish.x = nx;
					fish.y = ny;
				}

				gra[nx][ny] = fish.n;
				fish.dir = nextdir;
			}
		}

	}

}
