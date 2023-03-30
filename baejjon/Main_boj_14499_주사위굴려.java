package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14499_주사위굴려 {
	static int[] dx = { 0, 0, 0, -1, 1 }, dy = { 0, 1, -1, 0, 0 };
	static int[][] map;
	static int[] dice = new int[7]; // 0은 temp로 해놓는다.
	static int n, m, x, y, k,cmd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < k ; i++) {
			cmd =Integer.parseInt(st.nextToken());
			if(inRange(x,y,cmd)) {
				//여기서 주사위 동작
				dice(x,y,cmd);
			}
		}
		
	}
	static void swap(int x, int y) {
//		System.out.println(x+" "+y);
		dice[0] = dice[x];
		dice[x] = dice[y];
		dice[y] = dice[0];
	}
	static void dice(int z, int c, int cmd) {
		int nx = z +dx[cmd];
		int ny = c +dy[cmd];
		
		if(cmd == 1) {
			//왼쪽에서 오른쪽으로 굴림
			// 6->4 4->1 1->3 3->6
			int[] cx = {6,3,1,4};
			for(int i=0;i<3;i++) {
				swap(cx[i],cx[i+1]);
			}
//			6 3 1 4
//		초기 :1 2 3 4  계산 후면 2 3 4 1
		}else if(cmd == 2) {
			
			//오른쪽에서 왼쪽으로 굴림
			int[] cx = {6,4,1,3};
			for(int i=0;i<3;i++) {
				swap(cx[i],cx[i+1]);
			}
		}else if(cmd == 3) {
			//아래에서 위으로 굴림
			int[] cx = {6,5,1,2};
			for(int i=0;i<3;i++) {
				swap(cx[i],cx[i+1]);
			}
		}else if(cmd == 4) {
			//위에서 아래으로 굴림
			int[] cx = {6,2,1,5};
			for(int i=0;i<3;i++) {
//				System.out.println(i);
				swap(cx[i],cx[i+1]);
			}
			
		}
		if(map[nx][ny]==0) {
			map[nx][ny]=dice[6];
		}else if(map[nx][ny]!=0){
			dice[6]= map[nx][ny];
			map[nx][ny]=0;
		}
		x = nx;
		y= ny;
		System.out.println(dice[1]);
	}
	static boolean inRange(int a,int b,int cmd) {
		int nx = a+dx[cmd];
		int ny = b+dy[cmd];
		return 0<=nx&&nx<n&&0<=ny&&ny<m;
	}
}
