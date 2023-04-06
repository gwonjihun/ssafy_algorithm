package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16954 {

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static char[][] map = new char[8][8];
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1, 0 }, dy = {0, -1, 0, 1, 1, 1, 0, -1, -1 };
	static node person;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		System.out.println(bfs() ? 1 : 0);

	}

	static boolean bfs() {
		Deque<node> q = new ArrayDeque<node>();
		q.add(new node(7, 0));
		while (!q.isEmpty()) {
			int size= q.size();

			boolean[][] v = new boolean[8][8];
			for(int i =0 ; i<size;i++) {
				node cur = q.poll();
				if(map[cur.x][cur.y]=='#') continue;
				if(cur.x ==0 && cur.y ==7) return true;
				for(int d = 0; d<9;d++) {
					int nx = cur.x +dx[d];
					int ny = cur.y +dy[d];
					if(inRange(nx, ny)&&!v[nx][ny]&&map[nx][ny]=='.') {
						q.add(new node(nx,ny));
						v[nx][ny]= true;
					}
					
				}
			}
			
			downwall();

		}
		return false;
	}
	static void downwall() {
		for(int i=7;i>0;i-- ) {
			for(int j = 0 ; j<8;j++) {
				map[i][j]=map[i-1][j];
			}
		}
			
		for(int i = 0 ; i<8;i++) {
			map[0][i]='.';
		}
	}
	
	static boolean inRange(int x, int y) {
		return 0 <= x && x < 8 && 0 <= y && y < 8;
	}
}
