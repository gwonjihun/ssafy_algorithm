package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D4_1249_서울_20반_권지훈 {
	static int[][] arr, cost;
	static boolean[][] v;
	static int[] dx = { -1,  0,1, 0 }, dy = { 0,1, 0,  -1 };
	static int N;
	static final int INF = 10000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			cost = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++)
				Arrays.fill(cost[i], INF);
			cost[0][0] = 0;
			for (int i = 0; i < N; i++) {
				char[] str = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = (int) str[j] - '0';
				}

				
			}
//			for(int[] a: arr) {
//				System.out.println(Arrays.toString(a));
//			}
//				System.out.println("---------------");
				PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[2], o2[2]) );
				q.add(new int[] {0,0,arr[0][0]});
				cost[0][0] = 0;
				while(!q.isEmpty()) {
					int[] xy = q.poll();
					for(int d= 0 ; d<4; d++) {
						int nx = xy[0]+dx[d];
						int ny = xy[1]+dy[d];
						if(0<=nx && nx<N && 0<= ny && ny<N ) {
							if(cost[nx][ny] > arr[nx][ny]+cost[xy[0]][xy[1]]) {
							cost[nx][ny] = arr[nx][ny]+cost[xy[0]][xy[1]];
							q.offer(new int[] {nx,ny,cost[nx][ny]});
							}
						}
					}
				}


				sb.append("#").append(t).append(" ").append(cost[N - 1][N - 1]).append("\n");
			}

			System.out.println(sb);
		}
	}
