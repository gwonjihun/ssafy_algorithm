package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;

public class Main_boj_1992_서울_20반_권지훈 {

	static int[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		dfs(0,0,N);
		
		System.out.println(sb);
	}

	public static void dfs(int x, int y, int n) {
		if (check_arr(x, y, n)) {
			sb.append(arr[x][y]);
			return;
		}
		else {
			sb.append("(");
			n = n/2;
			dfs(x,y,n);
			dfs(x,y+n,n);
			dfs(x+n,y,n);
			dfs(x+n,y+n,n);
			
			sb.append(")");
		}
		
	}

	public static boolean check_arr(int x, int y, int n) {
		int tmp = arr[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (tmp != arr[i][j])
					return false;
			}
		}
		return true;
	}
}
