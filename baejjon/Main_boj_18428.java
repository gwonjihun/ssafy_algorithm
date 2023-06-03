package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_18428 {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static int N;
	static char[][] map;
	static ArrayList<Node> teach;
	static boolean answer = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		teach = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			char[] st = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = st[j * 2];
				if (map[i][j] == 'T') {
					teach.add(new Node(i, j));
				}
			}
		}

		dfs(0);
		System.out.println("NO");

	}

	static void dfs(int wall) {
		if (wall == 3) {
			check();//
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='X')
				{
					map[i][j]='O';
					dfs(wall+1);
					map[i][j]='X';
				}
			}
		}
		// 여기서 3개의 벽을 고른다.

	}
	static void check() {
		for(Node cur : teach ) {
			int x = cur.x;
			int y = cur.y;
			for(int d = 0; d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				while(0<=nx&&nx<N&&0<=ny&&ny<N) {
					if(map[nx][ny]=='S') {
						return;
					}
					if(map[nx][ny]=='O') {
						break;
					}
					nx+=dx[d];
					ny+=dy[d];
				}
			}
			
		}
		System.out.println("YES");
		System.exit(0);
	}
}
