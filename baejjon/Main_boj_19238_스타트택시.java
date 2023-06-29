package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 1. 승객 정보를 기준으로 가장 짧은 위치를 찾는다
 2. 짧은 거리만큼 연료를 제외하고 
 
  
 * 
 **/
public class Main_boj_19238_스타트택시 {
	static class person implements Comparator<person>{
		int sx, sy, ex, ey;

		public person(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}

		@Override
		public int compare(person o1, person o2) {
			// TODO Auto-generated method stub
			
			if(o1.sx == o2.sx) {
				return o1.sy-o2.sy;
			}
			return o1.sx-o2.sx;
		}
		
	}

	static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };
	static int car_x, car_y, fuel;
	static int[][] map;
	static boolean[] vis_p;
	static PriorityQueue<person> pq;
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[n][n];
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
			int ex = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			
			p[i] = new person(sx, sy, ex, ey);
		}
		bfs(tx,ty);
	}
	
	static void bfs(int x, int y) {
		boolean[][] v = new boolean[n][n];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y,0});
		v[x][y]= true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0 ; d<4;d++) {
				int nx = x+dx[d];
				int ny = y+ dy[d];
				if(inRange(x,y)&&v[nx][ny]) {
					for(person)
				}
			}
		
		}
			
	}
	static boolean inRange(int x , int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}

}
