package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_왕실의기사대결_fail {
	static int L, N, Q;
	static int[][] map;
	static Night[] nights;// 기사들 정보를 저장해놓는다.
	static int[] dx= {-1,0,1,0}, dy = {0,1,0,-1};
	static Deque<Night> q;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		map = new int[L + 1][L + 1];
		for (int i = 1; i <= L; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= L; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 지도 입력
		nights = new Night[N+1];
		
		for(int n = 1; n<=N;n++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			nights[n] = new Night(r, c, h, w, k);
		}
		
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			//여기서 밀기 동작을 실행시킨다
			if(moveisAvailable(idx, dir)) {
				//여기서부터는 이제 이동이 가능하다는 부분이 있기 때문에 
				move(idx,dir);
			}
		}
		int result=0;
		for(int n = 1; n<=N;n++) {
			Night cur = nights[n];
//			System.out.println(cur.r + " "+cur.c + " "+cur.k + " "+cur.dmg + " ");
//			System.out.println(cur.r);
			if(cur.r==-1) continue;
//			System.out.println(cur.dmg);
			result+=cur.dmg;
		}
		System.out.println(result);
	}
	static void move(int idx,int dir) {
		Night night = nights[idx];// 움직임의 시작인 대상을 가져온다.
		int nx = night.r +dx[dir];
		int ny = night.c +dy[dir];
		night.r= nx;
		night.c = ny;
		//1.번 q를 이용해서 다 저장한다.
		while(!q.isEmpty()) {
			Night cur = q.poll();
			nx = cur.r +dx[dir];
			ny = cur.c +dy[dir];
//			System.out.println("?????");
//			boolean flag = false;
			cur.move(nx, ny);
		}
	}
	//기사의 이동이 가능한지에 관해 조회하는 함수
	//먼저 nx,ny값을 기반으로 그쪽값이 바로 벽이냐 아니냐를 먼저 확인해준다.
	static boolean moveisAvailable(int idx,int dir) {
		q= new ArrayDeque<>();
		Night night = nights[idx];
		int nx = night.r+ dx[dir];
		int ny = night.c+ dy[dir]; 
		if(!inRange(nx, ny)||!inRange(nx+night.h-1,ny+night.w-1)||map[nx][ny]==2) return false;// 움직일수 없다를 의미
		for(int n = 1; n<=N;n++) {
			if(n==idx ) continue;
			Night next = nights[n];
			if(nx>=next.r&&nx<next.r+next.h&&ny>=next.c&&ny<next.c+next.w) {
				q.add(next);
				return moveisAvailable(n, dir);
			}
		}
		return true;
	}
	static boolean inRange(int x, int y) {
		return (x>0&&y>0&&x<=L&&y<=L);
	}

	static class Night {
		int r, c, h, w, k;
		int dmg;

		Night(int r, int c, int h, int w, int k) {
			this.dmg = 0;
			this.r = r;
			this.c = c;
			this.h = h;
			this.w = w;
			this.k= k;
		}
		void move(int nx,int ny) {
			int cnt = 0;
			for(int i = nx; i<nx+this.h;i++) {
				for(int j = ny; j <ny+this.w;j++) {
					if(map[i][j]==1) cnt++;
				}
			}
			
			this.dmg+=cnt;
//			System.out.println(cnt+"만큼 체력 감소");
			this.r =nx;
			this.c =ny;
			if(this.k-this.dmg<=0) {
//				System.out.println(this.k + " k " + this.dmg + " "+ this.r + " " + this.c);
				this.r = -1;
				this.c= -1;
			}
			
		}
	}
}
