package gwonjihun.codetree;

import java.io.*;
import java.util.*;

/*
 * 변수명
 * L : map의 크기, 
 * N : 기사 수
 * Q : 명렁의 갯수
 * 
 * 1. 기사 이동 상하좌우로 "한칸씩" 이동 
 * 이동 방향에 기사가 있으면 해당 기사도 방향 맞춰서 연쇄적으로 이동하게된다.
 * 대신 끝에 벽이 있으면 실패.
 * 
 * 2. 명령 받은 기사를 제외하고는 움직였을때 해당 위치에 함정이 있는 만큼 데미지를 받게 된다.
 * */
public class Main_왕실의기사_2nd {
	static int L,N,Q;
	static int[][] map;//함정 지도
	static Knight[] knights;
	static boolean[] visited;// 이동유무를 판단한다.
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
	
		map = new int[L+1][L+1];
		
		for(int i = 1; i<=L;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=L;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		knights = new Knight[N+1];
		
		for(int i = 1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			knights[i] = new Knight(r, c, h, w, k);
		}
		//여기서부턴
		for(int q = 0;q<Q;q++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
		
			move(idx,dir);
		}
		int result = 0;
		for(int i = 1 ; i<=N;i++) {
			Knight a = knights[i];
//			System.out.println(a.toString());
			if(a.c== -1 || a.r==-1)continue;
			result+=a.dmg;
		}
		System.out.println(result);
	}
	static boolean moveAvailable(int idx, int dir) {
		Knight start = knights[idx];
		Queue<Knight> q = new ArrayDeque<>();
		q.add(start);
		while(!q.isEmpty()) {
			//while문에서는 cur이 다음 장소로 방문이 가능한지의 유무를 확인하는 역할만을 담당해주면 된다.
			//그리고 만약 다음 장소에서 기사가 있어 다음 기사에게 해당 역할을 위임하기 위해 q에 넣어줄때 해당 기사도 연쇄적으로
			//충돌을 당하는 것이기 때문에 visited에다가 방문처리를해주면 된다.
			Knight cur = q.poll();
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@");
			int nx = cur.r + dx[dir];
			int ny = cur.c + dy[dir];
			//false인경우는 기사의 직사각형이 격자 밖으로 나가는 경우
			//기사의 nx,ny로만들어진 직사각형에 벽이 있는경우
			if(nx<=0||ny<=0||nx+cur.h-1>L||ny+cur.w-1>L) return false;
			for(int i = nx; i<nx+cur.h;i++) {
				for(int j = ny; j<ny+cur.w;j++) {
					if(map[i][j]== 2) return false;
				}
			}
			for(int i = 1;i<=N;i++) {
				if(i == idx) continue;
				Knight next= knights[i];
				//next기사가 
				for(int x= next.r; x<next.r+next.h;x++) {
					for(int y = next.c; y<next.c+next.w;y++) {
						if(x>=nx&&x<nx+cur.h&&y>=ny&&y<ny+cur.w&&!visited[i]) {

							visited[i] =true;
							q.add(next);
							
						}
					}
				}

			}
			
		}
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
		//먼저 이동의 결과가 격자를 넘어가는 경우를 체크해줌.
		return true;
	}
	static void move(int idx, int dir) {
		//여기서 이동 유무 함수를 통해서 if문을 확인한 뒤에
		visited = new boolean[N+1];
		Knight cur = knights[idx];
		if(cur.r==-1||cur.c==-1) {
			return;
		}
		if(moveAvailable(idx,dir)) {
//			System.out.println(Arrays.toString(visited));
//			System.out.println("!!!!!!");
			cur.r += dx[dir];
			cur.c += dy[dir];
			for(int i = 1; i<=N;i++) {
				if(!visited[i]) continue;
				Knight night = knights[i];
				night.r += dx[dir];
				night.c += dy[dir];
				night.attack();
				//
			}
		}
	}
	static class Knight{
		int r,c,h,w,k;
		int dmg;//현재까지 받았던 데미지
		public Knight(int r, int c, int h, int w, int k) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.w = w;
			this.k = k;
			this.dmg = 0;
		}
		@Override
		public String toString() {
			return "Knight [r=" + r + ", c=" + c + ", h=" + h + ", w=" + w + ", k=" + k + ", dmg=" + dmg + "]";
		}
		void attack() {
			int cnt = 0;
			for(int i = r; i<r+h;i++) {
				for(int j = c; j<c+w;j++) {
					if(map[i][j]==1) cnt+=1;
				}
			}
			this.dmg += cnt;
			if(this.k<=this.dmg) {
				this.r = -1;
				this.c = -1;
				//죽음을 의미
			}
		}
	}
}
