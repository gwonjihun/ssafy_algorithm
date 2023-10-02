package gwonjihun.codetree;

import java.io.*;
import java.util.*;

import gwonjihun.codetree.Main_메이즈러너.node;

public class Main_메이즈러너_2023_하반기 {

	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static int[][] map;
	static int n, m, k;
	static int cnt;
	static Node exit;
	static List<Node> list;// 이걸로 사람들을 위치를 관리해준다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList<Node>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			list.add(new Node(x, y));
		}

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;

		exit = new Node(x, y);

		cnt = 0;
		for (int s = 0; s < k; s++) {
			// k초만큼 진행을 할 예정이고
			if (list.size() == 0)
				break;
			move();
			l1:
			for(int l =1;l<n;l++) {
				for(int sx = 0; sx<n-l;sx++) {
					for(int sy = 0; sy<n-l;sy++) {
						if(check(sx,sy,l)) {
							rotation();
							break l1;
						}
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println((exit.x+1)+" "+(exit.y+1));

	}

	static void move() {
		// 사람을 이동시킨다.
		for (Node cur : list) {
			for(int d = 0; d<4;d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y+dy[d];
				if(nx>=0 && nx<n && ny>=0 && ny<n &&map[nx][ny]==0
						&& Math.abs(exit.x-cur.x)+Math.abs(exit.y-cur.y)
						>Math.abs(exit.x-nx)+Math.abs(exit.y-ny)) {
					cur.x = nx;
					cur.y = ny;
					cnt++;
					break;
				}
			}
		}
		
		for(int idx = 0 ; idx<list.size();idx++) {
			Node p = list.get(idx);
			if(p.x == exit.x && p.y == exit.y) {
				list.remove(idx);
				idx--;
			}
		}
	}

	static boolean check(int x,int y, int l) {
		if(x<=exit.x&&x+l<)
		return false;
	}
	static void rotation() {
		// 벽을 회전시킨다.
		
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
