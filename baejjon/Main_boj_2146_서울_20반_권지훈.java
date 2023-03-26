package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2146_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {

	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static boolean[][] v;
	static int N;
	static int[][] tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		tmp = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int land = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j]) {
					continue;
				}
				// ?„¬ë§ˆë‹¤
				if (!v[i][j] && map[i][j] != 0) {
					bfs(i, j, land);
					land += 1;
				}
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0) continue;
				boolean flag = false;
				for(int d = 0; d<4;d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					if(0 <= nx && nx < N && 0 <= ny && ny < N&& map[nx][ny]==0) {
						flag =true;
					}
				}
				
				if(flag) {
//					System.out.println("i : "+i+ "j : " + j);
					v= new boolean[N][N];
					bfs(i,j);
				}
			}
		}
		
		

		System.out.println(min);

	}
	static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.add(new int[] { x, y , 0 });
		int start = map[x][y];
		while(!q.isEmpty()){

			int[] xy = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = xy[0] + dx[d];
				int ny = xy[1] + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny] && map[nx][ny]!= start) {
					// ?žê¸? ?ž?‹ ?˜ ?„¬?„ ? œ?™¸?•˜ê³ ëŠ” ëª¨ë“  ë°”ë‹¤?? ?„¬?„ ë°©ë¬¸?•  ?ˆ˜ ?žˆ?–´?•¼?•œ?‹¤.
					v[nx][ny]=true;
					if(map[nx][ny]==0){
						q.addLast(new int[]{nx,ny, xy[2]+1});
					}else{
						min = Math.min(min,xy[2]);
					}
				}
			}
		}
	}

	static void bfs(int x, int y, int land) {
		Deque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			map[xy[0]][xy[1]] = land;
			for (int d = 0; d < 4; d++) {
				int nx = xy[0] + dx[d];
				int ny = xy[1] + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (!v[nx][ny] && map[nx][ny] == 1) {
						v[nx][ny] = true;
						q.addLast(new int[] { nx, ny });
					}
				}
			}

		}
	}
}
