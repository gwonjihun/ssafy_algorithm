package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17069_fail {

	static int[][] map;
	static int N;
	static int cnt;
	static boolean v[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		v = new boolean[N][N];

		dfs(0,1,0);
		System.out.println(cnt);
	}

	// dir : 0 , 1, 2 는 가로, 세로, 대각선을 의미한다.
	static void dfs(int tx, int ty, int dir) {
		if(!inRange(tx,ty)) {
			return;
		}
		if (tx == N - 1 && ty == N - 1) {
			cnt++;
			return;
		}
		if (dir == 0 || dir == 2) {
//			System.out.println("!!");
			int nx = tx ;
			int ny = ty +1;
			if(inRange(nx, ny)&&map[nx][ny]==0) {
				dfs(nx,ny,0);
			}
		}
		if (dir == 1 || dir == 2) {

//			System.out.println("!!!");
			int nx = tx +1;
			int ny = ty ;
			if(inRange(nx, ny)&&map[nx][ny]==0) {
				dfs(nx,ny,1);
			}
		}
		//여기는 대각선으로 이동하는 경우들만을 적용하는것이기 떄문에
		int nx = tx + 1;
		int ny = ty + 1;
		if(inRange(nx, ny)&&(map[nx][ny]==0&&map[tx][ny]==0&&map[nx][ty]==0)) {

//			System.out.println("!!!!");
			dfs(nx,ny,2);
		}
	}
	static boolean inRange(int x,int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
}
