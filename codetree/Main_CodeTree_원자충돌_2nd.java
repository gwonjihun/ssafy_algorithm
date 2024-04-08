package gwonjihun.codetree;

import java.io.*;
import java.util.*;
/*
 * 구현 로직
 * move()를 통해서 temp에다가 이동 결과들을 저장한다.
 * combine이라는 함수를 통해서 리스트의 크기가 2이상인 것들을 전부다 함쳐주는 과정을 진행할 것입니다.
 * 
 * */

public class Main_CodeTree_원자충돌_2nd {

	static class Atom {
		int m, s, d;

		public Atom(int m, int s, int d) {

			this.m = m;
			this.s = s;
			this.d = d;
		}

	}

	static int n, m, k;
	static ArrayList<Atom>[][] board;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Atom atom = new Atom(m, s, d);
			board[x][y].add(atom);
		}
		while (k-- > 0) {
			move();
			spread();
		}
		resultprint();
	}

	static void move() {
		ArrayList<Atom>[][] temp = new ArrayList[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				temp[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for(Atom a : board[i][j]) {
					int speed = a.s %n;
					int nx = (i+ n+dx[a.d]*a.s)%n;
					int ny = (j+ n+dy[a.d]*a.s)%n;
					
					temp[nx][ny].add(new Atom(a.m,a.s,a.d));
				}
			
			}
		}
		board = temp;
	}

	static void spread() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean odd = false;
				boolean even = false;
				int m = 0;
				int s = 0;
				int len = board[i][j].size();
				if (len < 2)
					continue;
				while (board[i][j].size() != 0) {
					Atom a = board[i][j].remove(0);
					m += a.m;
					s += a.s;
					if (a.d % 2 == 0) {
						even = true;
					} else {
						odd = true;
					}
				}
				if(m/5 <= 0 )continue;
				int id = 1;
				if (!odd || !even) {
					// 둘중 하나라도 false라면 원자의 방향은 상하좌우이다.
					id = 0;
				}
				for (; id < 8; id += 2) {
					board[i][j].add(new Atom(m / 5, s / len, id));
				}
			}
		}
	}

	static void resultprint() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (Atom a : board[i][j]) {
					result += a.m;
				}
			}
		}
		System.out.println(result);
	}
}
