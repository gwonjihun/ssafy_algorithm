package gwonjihun.codetree;

import java.io.*;
import java.util.*;
public class Main_codeTree_육면체굴리기 {

	static int n,m;//판의 크기, 주사위를 굴리는 횟수
	static int[][] arr;
	static int[] dx = {0,1,0,-1}, dy= {1,0,-1,0};
	static int dir = 0;//주사위가 보는 방향
	static int[] dice= {1,2,3,5,4,6};// 주사위
	//바닥의 idx는 5로 고정
	static int score;
	static int x = 0 ,y=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		score =0;
		
		for(int i = 0 ; i < n ;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int M = 0  ; M < m; M++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(!inRange(nx, ny)) {
				dir = (dir+2)%4;
				nx = x+dx[dir];
				ny = y+dy[dir];
			}
			x = nx;
			y = ny;
			move();
			score += getScore(x,y);
			if(dice[5]>arr[x][y]) {
				dir= (dir+1)%4;
			}else if(dice[5]<arr[x][y]) {
				dir = (4+dir-1)%4;
			}
			
		}
		System.out.println(score);
	}
	static int getScore(int w,int h) {
		int scr= arr[w][h];
		int cnt = 1;
		boolean[][] v = new boolean[n][n];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {w,h});
		v[w][h] =true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int d= 0 ; d<4;d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if(inRange(nx, ny)&&!v[nx][ny]&&arr[nx][ny]==scr) {
					cnt++;
					v[nx][ny]=true;
					q.add(new int[] {nx,ny});
				}
			}
			
		}
		return scr*cnt;
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	//주사위가 구르는 곳

	static void move() {
		switch (dir) {
		case 0: // 
			int temp = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = temp;
			break;
//			static int[] dice= {1,2,3,5,4,6};// 주사위
//			static int[] dx = {0,1,0,-1}, dy= {1,0,-1,0};
		case 1:
			temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
			break;
		case 2:
			temp = dice[0];
			dice[0]= dice[2];
			dice[2] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
			break;
		case 3:
			temp = dice[0];
			dice[0] = dice[1];
			dice[1]= dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
			break;

		}
	}
}
