package gwonjihun.baejjon;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main_boj_7562_나이트 {
	
	static int[] dx= {-1,-2,-2,-1,1,2,2,1}, dy = {-2,-1,1,2,2,1,-1,-2};
	static int n,cnt;
	static int sx,sy, ex,ey;
	static boolean[][] vis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1 ; t<=tc;t++) {
			n = Integer.parseInt(br.readLine());
			vis = new boolean[n][n];
			cnt = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sx = Integer.parseInt(st.nextToken());sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			ex = Integer.parseInt(st.nextToken());ey = Integer.parseInt(st.nextToken());
			bfs();
			System.out.println(cnt);
		}
	}
	static void bfs() {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {sx,sy,0});
		vis[sx][sy]=true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==ex&&cur[1]==ey) {
				if(cnt>cur[2])
				cnt=cur[2];
//				return;
			}
			for(int d=0;d<8;d++) {
				int nx = cur[0]+dx[d];
				int ny = cur[1]+dy[d];
				if(inRange(nx, ny)&&!vis[nx][ny])
				{
					vis[nx][ny]=true;
					q.add(new int[] {nx,ny,cur[2]+1});
				}
			}
		}
	}
	static boolean inRange(int a, int b) {
		return 0<=a&&a<n&&0<=b&&b<n;
	}
}
