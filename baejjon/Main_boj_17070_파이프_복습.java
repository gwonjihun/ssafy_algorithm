package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17070_파이프_복습 {
	static int[][] map;
	static int n;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0, 0, 1, 0);
		// dir 0,1,2가 있는데 0은 ㅡ 1은 ㅣ 2는 대각선
		System.out.println(answer);
	}

	static void bfs(int x_1, int y_1, int x_2, int y_2, int dir) {
		// x1,y1//파이프 앞
		if (x_2 == n - 1 && y_2 == n - 1) {
			answer += 1;
			return;
		}
		if(x_1 >n || y_1>n ||x_2 > n-1 || y_2>n-1) {
			return;
		}
		
		if(y_2+1<n&&map[x_2][y_2+1]==0&&(dir==0||dir==2)) {
		bfs(x_2,y_2,x_2,y_2+1,0);
		}
		if(x_2+1<n&&map[x_2+1][y_2]==0&&(dir==1||dir==2)) {

			bfs(x_2,y_2,x_2+1,y_2,1);
		}
		if(y_2+1<n&&x_2+1<n&&(map[x_2+1][y_2]==0&&map[x_2][y_2+1]==0&&map[x_2+1][y_2+1]==0)) {

			bfs(x_2,y_2,x_2+1,y_2+1,2);
		}
		

	}

}
