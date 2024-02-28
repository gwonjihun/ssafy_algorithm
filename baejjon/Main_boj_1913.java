package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1913 {

	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int tx, ty;
	static int N;
	static int num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		int x = N / 2;
		int y = N / 2;
		int idx =1 ;
		arr[x][y] = 1;
		int d = 0;
		int size = 1;
		if (num==1) {
			tx = x;
			ty = y;
		}
		while (x != 0 || y != 0) {

//			System.out.println(t);
			for (int i = 0; i < size; i++) {

				int nx = x + dx[d];
				int ny = y + dy[d];

				x = nx;
				y = ny;

				arr[x][y] = ++idx;
				if (idx == num) {
					tx = x;
					ty = y;
				}
//				System.out.println(x + " " + y +" " + (idx-1));
			}
//			System.out.println("---------");
			d = (d + 1) % 4;
			if(d%2==0&&y!=0) {
				size++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append(tx+1).append(" ").append(ty+1);
		System.out.println(sb);
	}
}
