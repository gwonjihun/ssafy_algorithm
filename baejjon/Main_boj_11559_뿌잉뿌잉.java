package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

// 1. 먼저 전체 뿌요를 찾아서 지워준다
// 2. 바닥에서부터 뿌요 후의 값들을 찾아준다.
public class Main_boj_11559_뿌잉뿌잉 {
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static char[][] games, temps;
	static boolean[][] vis;
	static int puyopuyo = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		games = new char[12][6];
		
		for (int i = 0; i < 12; i++) {
			games[i] = br.readLine().toCharArray();
		}

	

		while (true) {// 이게 한번 연쇄작용을 해야하기 때문에 그러면 flag를 통해서 break를 걸어줘야함.
			vis = new boolean[12][6];
			boolean flag = true;
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (!vis[i][j] && games[i][j] != '.') {
						
						if(broken(i, j)) {

						flag = false;
						}
					}
				}
			}
			// 여기서 이제 모든 배열을 내려오게 해줘야함.
			if (flag) {
				break;
			}
			puyopuyo++;
			down();
//			System.out.println("------------------------");
//			for(char[]a : games) {
//				System.out.println(Arrays.toString(a));
//			}

		}
		System.out.println(puyopuyo);
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < 12 && 0 <= y && y < 6;
	}

	
	static void down() {
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j >0 ; j--) {
				if (games[j][i] == '.') {
					for (int k = j - 1; k >=0; k--) {
						if(games[k][i]!='.') {
							games[j][i]= games[k][i];
							games[k][i]='.';
							break;
						}
					}
				}
			}

		}
	}

	static boolean broken(int x, int y) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		Deque<int[]> p = new ArrayDeque<int[]>();
		q.add(new int[] { x, y });
		p.add(new int[] { x, y });
		vis[x][y] = true;
		char target = games[x][y];
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (inRange(nx, ny) && !vis[nx][ny] && games[nx][ny] == target) {
					q.add(new int[] { nx, ny });
					p.add(new int[] { nx, ny });
					vis[nx][ny] = true;
				}
			}
		}
		if(p.size()>=4) {
			while (!p.isEmpty()) {
				int[] cur = p.poll();
				games[cur[0]][cur[1]] = '.';
			}
			return true;
		}
		return false;
	}
}
