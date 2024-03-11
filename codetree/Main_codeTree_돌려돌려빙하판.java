package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_codeTree_돌려돌려빙하판 {
	static int n, c;
	static int l;

	static int[][] arr;
	static int cnt;// 모든 얼음의 값
	static int size;// 최대 군집 크기
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[] rx = {0,1,0,-1}, ry  = {1,0,-1,0};
	static int[][] temp ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		l = (int) Math.pow(2, n);
		arr = new int[l][l];
		visited = new boolean[l][l];
		temp = new int[l][l];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < l; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			System.out.println((i+1)+"번째 회전");
			int len = Integer.parseInt(st.nextToken());
			if (len != 0) {
				rotate((int) Math.pow(2, len));

//				for (int t = 0; t < l; t++) {
//					System.out.println(Arrays.toString(arr[t]));
//				}
//				System.out.println("_____________________");
			}
			
			melt();
//			for (int t = 0; t < l; t++) {
//				System.out.println(Arrays.toString(arr[t]));
//			}
//			System.out.println("________녹였당___________");
		}
		cnt = 0;
		size = 0;

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (visited[i][j]||arr[i][j]==0) {
					continue;
				}

				bfs(i,j);
			}
		}
		System.out.println(cnt +"\n"+size);
	}
	static void bfs(int x,int y) {
		Deque<int[]> q = new ArrayDeque<>();
		visited[x][y]= true;
		cnt+=arr[x][y];
		q.add(new int[] {x,y});
		int land =1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d= 0 ; d<4;d++) {
				int nx = cur[0]+dx[d];
				int ny = cur[1]+ dy[d];
				if(inRange(nx, ny)&&!visited[nx][ny]&&arr[nx][ny]>0) {
					q.add(new int[] {nx,ny});
					visited[nx][ny]= true;
					cnt+= arr[nx][ny];
					land++;
				}
			}
		}
		size = Math.max(size, land);
	}
	static boolean inRange(int x, int y) {
		return 0 <= x && x < l && 0 <= y && y < l;
	}

	static void melt() {
		temp = new int[l][l];
		for(int i = 0 ; i< l ; i++) {
			for(int j = 0 ; j < l ; j++) {
				temp[i][j] = 0;
			}
		}
		for (int x = 0; x < l; x++) {
			for (int y = 0; y < l; y++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (inRange(nx, ny) && arr[nx][ny] > 0) {
						cnt++;
					}
				}
				if (cnt < 3) {
					temp[x][y]= arr[x][y]+(arr[x][y] > 0 ? -1 : 0);
				}else {
					temp[x][y]= arr[x][y];
				}

//					temp[x][y] = arr[x][y];
//				}
			}
		}
		arr = temp;
	}
	static void move(int sx,int sy,int len, int dir) {
		for(int x = sx; x<sx+len;x++) {
			for(int y = sy; y<sy+len; y++) {
				temp[x+rx[dir]*len][y+ry[dir]*len] = arr[x][y];
			}
		}
	}
	static void rotate(int len) {
		temp = new int[l][l];
		for(int i = 0 ; i< l ; i++) {
			for(int j = 0 ; j < l ; j++) {
				temp[i][j] = 0;
			}
		}
		int half = len/2;

//		static int[] rx = {0,1,0,-1}, ry  = {1,0,-1,0};
		for (int i = 0; i < l; i = i + len) {
			for (int j = 0; j < l; j = j + len) {
				move(i,j,half,0);
				move(i,j+half,half,1);
				move(i+half,j+half,half,2);
				move(i+half,j,half,3);
				
			}
		}
		arr = temp;
	}
}

//0 1 2 0 1 2 0 1 2 0