package gwonjihun.codetree;

import java.io.*;
import java.util.*;


public class Main_CodeTree_왕실기사의대결_3st {

	static class Kngiht{
		
		
		int x,y,h,w,ik,k;
		
		@Override
		public String toString() {
			return "Kngiht [x=" + x + ", y=" + y + ", h=" + h + ", w=" + w + ", ik=" + ik + ", k=" + k + "]\n";
		}

		public Kngiht(int x, int y, int h, int w, int ik) {
//			super();
			this.x = x;
			this.y = y;
			this.h = h;
			this.w = w;
			this.ik = ik;
			this.k = ik;
		}
		
	}
	static int L,N,Q;
	static int[][] wall;
	static int[] dmgs;
	static Kngiht[] knights;
	static boolean[] v;//방문된 녀석들은 움직인다.
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		wall = new int[L][L];
		knights = new Kngiht[N];
		
		for(int i = 0 ; i < L;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < L ; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int ik = Integer.parseInt(st.nextToken());
			
			knights[i] = new Kngiht(x, y, h, w, ik);
		}
//		System.out.println(Arrays.toString(knights));
		while(Q-->0) {
			dmgs = new int[N];
			v = new boolean[N];
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			move(idx,dir);
//			System.out.println(Arrays.toString(knights));
		}
		int result = 0;
		for(int n = 0 ; n <N;n++) {
			Kngiht cur = knights[n];
			if(cur.k>0) {
				result += (cur.ik-cur.k);
			}
		}
		System.out.println(result);
		
	}
	static void move(int idx,int dir) {
//		System.out.println("move 시작");
		Kngiht cur = knights[idx];
		//현재 이동해야할 기사를 찾아왔음 
		// moveable()을 통해서 다음 위치를 찾아준다.
		if(cur.k<=0) return ;
		if(movable(idx,dir)) {
			
			
			//이제 왔으면 move를 동작한다 해당 동작을 진행할떄 dmg 배열을 참조해서 진행할 것이다.
			for(int n = 0 ; n<N;n++) {
				if(!v[n]) continue;
				Kngiht mv = knights[n];
				mv.x += dx[dir];
				mv.y += dy[dir];
				mv.k -= dmgs[n];
			}
			cur.x += dx[dir];
			cur.y += dy[dir];
		}
		
	}
	
	static boolean movable(int idx,int dir) {
		Queue<Integer> q= new ArrayDeque<>();
		q.add(idx);
		while(!q.isEmpty()) {
			int depth = q.poll();
			Kngiht cur = knights[depth];
			int nx = cur.x + dx[dir];
			int ny = cur.y + dy[dir];
			
			//기사의 다음 움직임이 벽을 나간 경우를 의미한다.
			if(nx<0|| ny <0 || nx+cur.h-1 >=L ||ny+cur.w-1>=L) {
//				System.out.println("기사가 격자를 벗어남 : " + nx + " " + ny);
				return false;}
			//다음은 기사의 다음 위치에 2가 포함되어있는지를 먼저확인해준다.
			int dmg = 0 ;
			for(int i = 0; i<cur.h;i++) {
				for(int j = 0 ; j < cur.w;j++) {
					if(wall[nx+i][ny+j]==2) {
//						System.out.println("기사의 다음 위치에 벽이 있어서 이동 불가");
						return false;
					}
					if(wall[nx+i][ny+j]== 1) dmg++;
				}
			}
			if(idx != depth) {
				//지금까지 받았던 데미지를 갱신한다.
				dmgs[depth] = dmg;
			}
			//여기까지 왔다면 첫 기사의 움직임에서 벽이 없었고 격자외부로 나간것이 아니기 때문에 다음 녀석의 움직임을 확인해야한다.
			for(int n = 0 ; n<N;n++) {
				if(v[n]|| n==idx) continue;
				Kngiht next = knights[n];
				if(next.k<=0) continue;
				if(nx>next.x+next.h-1 || ny > next.y+next.w-1) continue;
				if(nx+cur.h-1<next.x || ny+cur.w-1 <next.y) continue;
				q.add(n);
				v[n] = true;
			}
			
		}
//		System.out.println("이동 가능함.");
		return true;
	}
}
