package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_17141 {
	static int N, M;
	static int[][] board;
	static boolean[] v;
	static List<int[]> virus;
	static int cnts = 0;
	// 0 빈통로 1은 벽 2는 바이러스가 놓일수 있는 칸
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virus = new ArrayList<>();
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j]==0) cnts++;
				if (board[i][j] == 2) {
					virus.add(new int[] { i, j });
					cnts++;
					}
			}
		}
		cnts-=M;
		v = new boolean[virus.size()];
		dfs(0,0);
		System.out.println(min==Integer.MAX_VALUE? -1 : min);
	}

	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	static void dfs(int depth, int idx) {
		if (depth == M) {
			int[][] map = new int[N][N];
			map = virusMap();
//			System.out.println("!!!");
			int tmp =  bfs(map);
//			System.out.println(tmp);
			min = Math.min(min,tmp);
			return;
		}
		for(int i = idx; i < virus.size();i++) {
			v[i] = true;
			dfs(depth+1,i+1);
			v[i] = false;
		}
	}
	static int[][] virusMap(){
		int[][] map = new int[N][N];
		for(int i = 0 ; i <  N ; i++) {
			for(int j = 0 ; j < N; j++) {
				map[i][j]= board[i][j]!=2? board[i][j] : 0;
			}
		}
		for(int i = 0 ; i< virus.size();i++) {
			if(v[i]) {
				int[] cur = virus.get(i);
				map[cur[0]][cur[1]] = 2;
			}
		}
		return map;
		
	}
	static int bfs(int[][] map) {
		int cnt = 0 ;
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					visited[i][j] = true;
					q.add(new int[] { i, j });
				}
			}
		}
		int time = -1;
		while (!q.isEmpty()) {
			if(time>min) {
				break;
			}
			time += 1;
			int size =  q.size();
			for (int i = 0; i <size; i++) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];

					if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && map[nx][ny] == 0) {
						q.add(new int[] { nx, ny });
						map[nx][ny]=9;
						visited[nx][ny] = true;
						cnt++;

					}

				}

			}
		}
//		for(int i = 0 ; i < N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		for(int i = 0 ; i < N;i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
//		System.out.println(cnt + " " + cnts);
		if(cnt!= cnts) {
			return Integer.MAX_VALUE;
		}
		return time;
	}
}
