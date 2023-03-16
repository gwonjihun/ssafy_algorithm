package gwonjihun.codetree;

import java.io.*;
import java.util.*;


public class Main_싸움땅 {
	static class person{
		int x,y,ablity,dir,gun;
		
		public person(int x, int y, int ablity, int dir, int gun) {
			super();
			this.x = x;
			this.y = y;
			this.ablity = ablity;
			this.dir = dir;
			this.gun = gun;
		}

		@Override
		public boolean equals(Object obj) {
			person other = (person) obj;
			if (x == other.x && y == other.y) {
				return true;
			}
			return false;
		}
		
	}
	
	static ArrayList<Integer>[][] map;
	static person[] p_l;
	static int[] dx= {-1,0,1,0}, dy = {0,1,0,-1};
	static int[] point;
	static int n, m, k;// n : 맵 크키 ,  m은 플레이어수 k는 턴 수
	
	static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y&& y<n;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p_l = new person[m];
		map = new ArrayList[n][n];
		for(int i = 0; i<n; i++) {
			for(int j= 0 ; j< n ; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j= 0 ; j< n ; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp !=0) {
				map[i][j].add(tmp);
				}
			}
		}
		
		for(int i = 0; i < m ;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x =  Integer.parseInt(st.nextToken())-1;
			int y =  Integer.parseInt(st.nextToken())-1;
			int d =  Integer.parseInt(st.nextToken())-1;
			int s =  Integer.parseInt(st.nextToken());
			p_l[i] = new person(x,y,d,s,0);
		}
		
		for(int i = 0; i<k;i++) {
			simulation();
		}
		
		answer();
	}
	static void simulation() {
		
	}
	static void answer() {
		for(int a : point) System.out.print(a+" ");
		System.out.println();
	}
	
	
	//true는 p1 false p2
	static boolean fight(person p1, person p2) {
		
		return true; 
	}
}
