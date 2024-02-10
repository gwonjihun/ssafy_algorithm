package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * 문제 접근법
 * BFS를 통해서 4방 탐색을 진행한다
 * 방문 유무를 확인할때는 (x,y),벽뚫은 횟수 를 기반으로 진행한다
 * 그리고 q에서 x,y가 된다면 바로 중단해주는것으로 진행한다.
 * 
 * */
public class Main_boj_2206_aga {

	static int[][] map;
	static int N, M;
	static boolean[][][] visited;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[2][N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		if(N==1&& M== 1) {
			System.out.println(1);
			
		}else {
		bfs();
		}
	}
	
	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();// int[] -> x,y,뚫은 횟수, 이동 횟수
		visited[0][0][0] =true;
		q.add(new int[] {0,0,0,1});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0 ; d<4;d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if(0<=nx && nx<N && 0<= ny && ny<M && !visited[cur[2]][nx][ny]) {
					if(map[nx][ny]==0) {
						if(nx==N-1&&ny==M-1) {
							System.out.println(cur[3]+1);
							return;
						}
						visited[cur[2]][nx][ny]= true;

						q.add(new int[] {nx,ny,cur[2],cur[3]+1});
					}else {
						if(cur[2]<1) {
							//1이면 더 못부숨
							visited[1][nx][ny]= true;
							q.add(new int[] {nx,ny,1,cur[3]+1});
						}
					}
					
				}
			}
			
		}
		
		System.out.println("-1");
	}

}
