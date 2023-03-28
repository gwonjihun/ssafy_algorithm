package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
/*
 1. 승객 정보를 기준으로 가장 짧은 위치를 찾는다
 2. 짧은 거리만큼 연료를 제외하고 
 
  
 * 
 **/
public class Main_boj_19238_스타트택시 {
	static class person{
		int sx,sy,ex,ey;

		public person(int sx, int sy, int ex, int ey) {
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}
	}
	static int[] dx = {1,0,0,-1}, dy= {0,1,-1,0};
	static int car_x,car_y,fuel;
	static int[][] map,length;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
	}
	
}
