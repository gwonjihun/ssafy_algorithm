package gwonjihun.swea;
import java.io.*;
import java.util.*;
public class Solution_D0_1953_서울_20반_권지훈_DFS {
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static int[][] map,arr;
	static int N,M, time,goal,cnt;
	static int[][] pipe = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 2 }, { 1, 2 }, { 3, 1 }, { 3, 0 } };
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int t =1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			goal = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			arr = new int[N][M];
			boolean[][] v = new boolean[N][M];
			
			for(int i =0; i<N;i++) {
				 st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			time = 1;
			cnt = 1;
			v[sx][sy]=true;
			dfs(sx,sy,1,v);
			sb.append("#"+t+" "+cnt);
		}
		System.out.println(sb);
	}
	static void dfs(int x,int y,int time,boolean[][] v) {

		if(time==goal) {return;}
		int[] dir = pipe[map[x][y]];
		for(int d : dir) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(inRange(nx,ny) && !v[nx][ny]&&map[nx][ny]!=0) {
				//다음 nx에 pipe가 존재하는지 확인.
				int[] tmp = pipe[map[nx][ny]];
				for(int s: tmp) {
					//다음 파이프가 존재할때 다음 파이프가 기존 x,y와 연결되어 있는지 유무 확인
					int check_x = nx+dx[s];
					int check_y = ny+dy[s];
					if(check_x == x && check_y==y) {
						//연결되어 있는 파이프는 다음 dfs 동작이 가능하다.
						v[nx][ny]=true;
						//백트랙킹시 v로만 체크해서 카운트 할 경우에는 
						//중복되는 지점을 체크한다. 따라서 time마다 방문한 곳을 추가적으로 체크해줘야한다.
						if(arr[nx][ny]==0) {
						arr[nx][ny] = time;
						cnt++;
						}
						dfs(nx,ny,time+1,v);
						v[nx][ny]=false;
					}
					
				}
			}
			
		}
	}
	static boolean inRange(int x,int y) {
		return 0<=x&&x<N&&0<=y&&y<M;
	}

}
