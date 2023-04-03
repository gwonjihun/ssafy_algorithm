package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_9205_맥주가조아_ing {
	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int shop_c; // 맥주가게 갯수
	static int sx, sy, ex, ey;
	static node[] p;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			shop_c = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());

			p = new node[shop_c];
			v = new boolean[shop_c];
			for (int i = 0; i < shop_c; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p[i] = new node(x, y);
			}
			st = new StringTokenizer(br.readLine(), " ");
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			if (bfs()) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
	}

	static boolean bfs() {
		
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx,sy});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(Math.abs(cur[0]-ex)+Math.abs(cur[1]-ey)<=1000) {
				return true;
			}
			for(int i = 0;i<p.length;i++) {
				node shop = p[i];
				if(Math.abs(cur[0]-shop.x)+Math.abs(cur[1]-shop.y)<=1000&&!v[i]) {
					q.add(new int[] {shop.x, shop.y});
					v[i]=true;
				}
			}
			
		}
		return false;

	}
}
