package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 1. 승객 정보를 기준으로 가장 짧은 위치를 찾는다
 2. 짧은 거리만큼 연료를 제외하고 
 
  
 * 
 **/
public class Main_boj_19238_스타트택시 {
	static class person {
		int sx, sy, ex, ey;

		public person(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}
	}

	static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };
	static int car_x, car_y, fuel;
	static int[][] map;
	static person[] p;
	static boolean[] vis_p;
	static int n, m,tx,ty;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		p = new person[m];
		vis_p = new boolean[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					map[i][j]=-1;
				}
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		tx = Integer.parseInt(st.nextToken())-1;
		ty = Integer.parseInt(st.nextToken())-1;
		for(int i=0;i<m;i++) {			
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			map[sx][sy] = i+1;
			int ex = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			
			p[i] = new person(sx, sy, ex, ey);
		}
		

	}
	


}
