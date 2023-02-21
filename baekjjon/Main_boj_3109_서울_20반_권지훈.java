package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_3109_서울_20반_권지훈 {

	static char[][] arr;
	static int R, C;
	static int[] dx = {-1,0,1}, dy = {1,1,1};
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int i=0;i<R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j<C;j++)
			{
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i=0;i<R;i++) {
			if(dfs(i,0)) cnt++;
		}
		System.out.println(cnt);
	}
	
	static boolean dfs(int x,int y) {
		arr[x][y]= '-';
		for(char[] a: arr) {
			for(char b : a) {
				System.out.print(b);
			}System.out.println();
		}
		
		System.out.println(")____________________(");
		if(y==C-1) {
			return true;
		}
		if(x>0&& x<R && arr[x-1][y+1]=='.') {
			if (dfs(x-1,y+1)) return true;
		}
		if(x>=0&& x<R && arr[x][y+1]=='.') {
			if (dfs(x,y+1)) return true;
		}
		if(x>=0&& x<R-1 && arr[x+1][y+1]=='.') {
			if (dfs(x+1,y+1)) return true;
		}
		return false;
	}
}
