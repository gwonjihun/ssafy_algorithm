package gwonjihun.codetree;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main_포탑_부수기 {
	static class Tower implements Comparable<Tower> {
		int x, y;
		int power;
		int time; // time이 클수록 가장 최근 공격한 포탑
		boolean part; //

		public Tower(int x, int y, int power) {
			this.x = x;
			this.y = y;
			this.power = power;
			this.time = 0;
			this.part = false;
		}

		@Override
		public String toString() {
			return "Tower [x=" + x + ", y=" + y + ", power=" + power + ", time=" + time + ", part=" + part + "]";
		}

		@Override
		public int compareTo(Tower o) {
			if(this.power==o.power) {
				if(this.time==o.time) {
					if(this.x+this.y == o.x+o.y) {
						return this.y-o.y;
					}
					return this.x+this.y- o.x+o.y;
				}
				return this.time-o.time;
			}
			// TODO Auto-generated method stub
			return Integer.compare(this.power,o.power);
		}
	}

	static int n, m, k;
	static List<Tower> list;
	static int[][] map;
	static int[] dx= {0,1,0,-1}, dy= {1,0,-1,0};
	static List<Tower> at_list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		list = new ArrayList<>();
		for(int i = 0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j< m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0)
				list.add(new Tower(i, j, map[i][j]));
			}
		}
		for(int i =1;i<=k;i++) {
			if(list.size()==1) {
				break;
			}
			at_list = new ArrayList<>();
			Collections.sort(list);
//		for(Tower t : list) {
//			System.out.println(t);
//		}
			int len = choose_ack();
			if(len>0) {
				
				int sx = list.get(0).x;
				int sy = list.get(0).y;
				int ex = list.get(list.size()-1).x;
				int ey = list.get(list.size()-1).y;
				back_tracking(sx,sy,ex,ey,0);
			}else {}// 포탑 공격
			broke_check();
			repair();
//			System.out.println(choose_ack());
		}
		int Max = 0;
		for(Tower t : list) {
			if(Max < t.power) {
				Max = t.power;
			}
		}
		System.out.println(Max);
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<m;
	}
	static void back_tracking(int sx,int sy,int ex,int ey,int cnt) {
		if(sx==ex&&sy==ey) {
			//여기서 최종 타겟을 공격해야하기 때문에
			list.get(list.size()-1).power -= list.get(0).power;
			for(Tower t : at_list) {
				t.power -= list.get(0).power/2;
			}
			return;
		}
	}

	static int choose_ack() {
		Tower target = list.get(list.size()-1);
		Tower start = list.get(0);
		boolean[][] v = new boolean[n][m];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start.x,start.y,0});
		v[start.x][start.y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d =0 ; d<4;d++) {
				int nx = cur[0]+dx[d];
				int ny = cur[1]+dy[d];
				if(!inRange(nx,ny)) {
					//-1, 0 이면 +n하고%n으로가는거고
					//0, -1이면 +n하고 %m으로하면 해당 위치로 가지고
					nx = (nx+n)%n;
					ny = (ny+m)%m;
				}
				if(nx== target.x && ny==target.y) {
					return cur[2]+1;
				}
				if(!v[nx][ny]&&map[nx][ny]!=0) {
					q.add(new int[] {nx,ny,cur[2]+1});
					v[nx][ny] = true;
				}
			}
		}
		return 0;
	}
	static void broke_check() {
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).power==0) {
				list.remove(i);
				i--;
			}
		}
	}
	static void repair() {
		for (Tower t : list) {
			if (!t.part) {
				t.power += 1;
			}
		}
	}
}
