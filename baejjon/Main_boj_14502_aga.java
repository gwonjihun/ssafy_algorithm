package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_14502_aga {

	static int[][] map;
	static int N,M;
	static int cnt;//안전영역
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	//일단 입력 다받고 dfs로 3개를 고를수있게한다음에
	//그 뒤에 if 문에서 bfs를 돌려준다.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cnt = Integer.MIN_VALUE;
		for(int i = 0 ; i  < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		
		System.out.println(cnt);
	}
	static void dfs(int depth,int x,int y) {
		if(depth ==3) {
			boolean[][] v = new boolean[N][M];
			int[][] temp = new int[N][M];
			Deque<int[]> q = new ArrayDeque<>();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j]== 2) {
						v[i][j] =true;
						q.add(new int[] {i,j});
					}
					temp[i][j] = map[i][j];
				}
			}
//			System.out.println(q.size()+"!!!!!");
			//temp를 가지고 bfs를 진행해준다.그렇게 된다면 다시 돌려줄 필요가 없다.
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				for(int d= 0; d<4;d++) {
					int nx = cur[0]+dx[d];
					int ny = cur[1]+dy[d];
					if(0<=nx &&nx<N &&0<=ny && ny<M && !v[nx][ny] && temp[nx][ny]==0) {
						v[nx][ny]= true;
						temp[nx][ny]= 2;
						q.add(new int[] {nx,ny});
					}
				}
			}
			int curcnt = 0 ;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(temp[i][j]==0) curcnt++;
				}
			}
//			if(curcnt>10) {
//			for(int i = 0 ; i < N ; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//
//			}
//			System.out.println("_____________________");
//			}
//			System.out.println(curcnt);
			cnt = Math.max(curcnt, cnt);
			
			return;
			//여기서부터 bfs를 진행 해 줘야한다.
		}
		
		for(int i = 0 ; i  <N;i++) {
			for(int j = 0; j<M;j++) {
				if(map[i][j]!=0 )continue;
				map[i][j] = 1;
				dfs(depth+1,j+1%M==0?i+1: i,j+1%M==0?0:j+1);
				map[i][j]= 0;
			}
		}
	}
}
