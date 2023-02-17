package gwonjihun.swea;

import java.util.*;
import java.io.*;

public class Solution_D4_7733_서울_20반_권지훈_DFS {
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int answer = 0;
	static int cnt;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int T = 1; T <= Tc; T++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			answer = 1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i <= 100; i++) {
				visited = new boolean[N][N];
				cnt =0;
				for(int x=0;x<N;x++) {
					for(int y=0;y<N;y++) {
//						System.out.println(x+" "+ y);
						if( visited[x][y] || arr[x][y]<=i )continue;
						cnt++;
						dfs(x,y,i);
					}
				}
				answer = Math.max(answer,cnt);
			}
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y, int day) {
//			System.out.println(cnt);
			visited[x][y]=true;
			for(int i = 0;i<4;i++) {
				int nx = x+dx[i], ny = y+dy[i];
				if(0>nx || nx>=N ||0>ny || ny>=N ) {continue;}
				if(visited[nx][ny] || arr[nx][ny]<=day ) {continue;}
				dfs(nx,ny,day);
			}
			
			
	}

}
