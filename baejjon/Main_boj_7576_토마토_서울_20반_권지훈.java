package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_7576_?† ë§ˆí† _?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	static int[][] map;
	static int N, M;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	static Deque<int[]> q;
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<>();
		map = new int[N][M];
		for(int i = 0; i< N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) q.addLast(new int[] {i,j,0});
			}
		}
		

		bfs();
		for(int i = 0; i< N;i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j]==0) answer = -1;
			}
		}
//		for(int[] a: map) {
//			System.out.println(Arrays.toString(a));
//		}
		System.out.println(answer);
	}
	static void bfs() {
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			for(int d=0; d<4;d++) {
				int nx = xy[0]+dx[d];
				int ny = xy[1]+dy[d];
				if(0<= nx && nx<N && 0<= ny && ny<M && map[nx][ny]==0) {
					map[nx][ny] = xy[2]+1;
					answer = Math.max(answer, map[nx][ny]);
					q.addLast(new int[] {nx,ny,xy[2]+1});
				}
			}
		}
	}
}
