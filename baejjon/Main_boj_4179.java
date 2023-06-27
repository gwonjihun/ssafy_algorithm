package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_4179 {

	static int[] dx= {0,0,1,-1}, dy= {1,-1,0,0};
	static char[][] map;
	static int r,c;

	static int jx,jy;
	// 불이 먼저 확산하고 그 뒤에 지훈이가 움직이면 된다 그러면 방문처리가 알아서 처리되고
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		Deque<position> q = new ArrayDeque<>();
		for(int i = 0 ; i < r; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0 ; j < c;j++) {
				map[i][j] = tmp[j];
				if(map[i][j]=='J') {
					jx = i;
					jy = j;
				}
				if(map[i][j]=='F') {
					q.add(new position(i,j,0,'F'));
				}
			}
		}
		int result = bfs(q);
		System.out.println(result==-1?"IMPOSSIBLE": result);
	}
	
	static int bfs(Deque<position> q) {
		boolean[][] v = new boolean[r][c];
		q.add(new position(jx,jy,0,'J'));
		v[jx][jy]= true;
		while(!q.isEmpty()) {
			position cur = q.poll();
			if(cur.kind=='F') {
				//불은 범위를 벗어나면 안된다
				for(int d=0; d<4;d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(0<=nx&&nx<r&&0<=ny&&ny<c&&(map[nx][ny]=='.'||map[nx][ny]=='J')) {
						map[nx][ny] ='F';
						q.add(new position(nx, ny, cur.time+1, cur.kind));
					}
				}
			}else {
				for(int d=0; d<4;d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(0>nx|| nx>=r || 0> ny || ny>=c) {
						return cur.time+1;
					}
					if(map[nx][ny]=='.'&& !v[nx][ny]) {
						v[nx][ny]=true;
						q.add(new position(nx, ny, cur.time+1, cur.kind));
					}
				}
			}
		}
		return -1;
	}
	static class position{
		int x,y,time;
		char kind;
		public position(int x, int y, int time, char kind) {
			this.x =x;
			this.y =y;
			this.time =time;
			this.kind = kind;
		}
	}
}
