package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_6087 {
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int N, M;
	static char[][] map;
	static int[][] nodes;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		nodes = new int[2][2];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'C') {
					nodes[idx][0] = i;
					nodes[idx][1] = j;
					idx++;
				}
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		int min = Integer.MAX_VALUE;
		int[][][] visited = new int[4][N][M];
		//여기다가 전부다 dir,x,y에 왔을떄까찌 사용한 미러의 갯수를 저장하면서 큰 녀석은 continue를
		//작으면 visited에 정보를 저장해주는 방식으로 진행이될텐데..
		Deque<int[]> q = new ArrayDeque<>();
		for(int i=0;i<4;i++) {
			for(int j = 0 ; j< N ; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		//x,y,dir,mirrosnum으로 관리한다면?
		q.add(new int[] {nodes[0][0],nodes[0][1],-10,-1});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==nodes[1][0] && cur[1]==nodes[1][1]) {
				min = Math.min(cur[3], min);
				continue;
			}
			for(int d = 0 ; d<4;d++) {
				int nx = cur[0]+dx[d];
				int ny = cur[1]+dy[d];
				int nextMir = (cur[2]==d)? cur[3]: cur[3]+1;
				
				if(0>nx||nx>=N||0>ny||ny>=M || map[nx][ny]=='*'||Math.abs(cur[2]-d)==2) {
					continue;
				}
				if(visited[d][nx][ny]>nextMir) {
					q.offer(new int[] {nx,ny,d,nextMir});
					visited[d][nx][ny] = nextMir;
				}
			}
		}
		
		
		return min;
	}
}
