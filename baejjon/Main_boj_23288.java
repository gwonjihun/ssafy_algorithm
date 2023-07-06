package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_23288 {
	static int[] dx = {0,1,0,-1} ,dy= {1,0,-1,0}; 
	static int[][] map;
	static int[] dice = {1,2,3,4,5,6}; // 0 1 2 3 4 5// 1이 맨 윗면 아래가 밑면
	static int dir = 0%4;
	static int score= 0;
	static int N,M,K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sx = 0 , sy = 0;
		while(K-->=1) {
			sx = sx + dx[dir];
			sy = sy + dy[dir];
			if(0>sx || 0>sy || sx>=N ||sy>=M) {
				dir = (dir+2)%4;
				sx = sx + 2*dx[dir];
				sy = sy + 2*dy[dir];
			}
			rotate(dir);
//			System.out.println(Arrays.toString(dice));
			int cnt = bfs(sx,sy);
//			System.out.println(cnt);
//			System.out.println(cnt*map[sx][sy]);
			score += cnt*map[sx][sy];
			if(dice[5]>map[sx][sy]) {
				dir = (dir+1)%4;
			}else if(dice[5]<map[sx][sy]) {
				dir = (4+dir-1)%4;
			}
//			System.out.println(score);
//			System.out.println(dir);
//			System.out.println("------------");
		}
		System.out.println(score);
	}
	static int bfs(int x,int y) {
		boolean[][] v= new boolean[N][M];
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {x,y});
		int target = map[x][y];
		int cnt = 1;
		v[x][y] =true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			for(int d=0; d<4;d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(0<=nx&& nx<N&& 0<=ny &&ny<M && !v[nx][ny] && map[nx][ny]==target) {
					q.add(new int[] {nx,ny});
					v[nx][ny]= true;
					cnt++;
				}
			}
		}
		return cnt;
	}
	static void rotate(int dir) {
		switch(dir) {
		case 0:// d
			// 1->3 3->6 6->4 4-> 1
			int temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
			
			break;
		case 1:
			// 1->5 5->6 6->2 2->1
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
			break;
		case 2:
			//1> 4 4>6 6>3 3>1
			temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
			break;
		case 3://o
			// 1->2 2->5 5-> 6 6>1
			temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
			break;
			
		}
	}
}
