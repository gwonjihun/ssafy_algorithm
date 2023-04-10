package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17136_색종이를붙이자 {
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	static int paper[] = {0,5,5,5,5,5};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		
		System.out.println(result!=Integer.MAX_VALUE? result:-1);

	}
	
	static void dfs(int x, int y, int cnt) {
		if(x>=9&&y>9) {
			if(cnt<result) {
				result =cnt;
			}
			return;
		}
		if(cnt>=result) {
			return;
		}
		if(y>9) {
			dfs(x+1,0,cnt);
			return;
		}
		if(map[x][y]==1) {
			for(int i =5; i>0;i--) {
				if(paper[i]>0 && check(x,y,i)) {
					fill(x,y,i,0);
					paper[i]--;
					dfs(x,y+1,cnt+1);
					fill(x,y,i,1);
					paper[i]++;
					
				}
			}
		}else {
			dfs(x,y+1,cnt);
		}
	}
	static void fill(int x,int y,int kind, int val) {
		for(int i = x;i<x+kind;i++) {
			for(int j = y;j<y+kind;j++) {
				map[i][j] = val;
			}
		}
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<10&&0<=y&&y<10;
	}
	static boolean check(int x, int y, int kind) {
		for(int i = x;i<x+kind;i++) {
			for(int j = y;j<y+kind;j++) {
				if(!inRange(i,j)) return false;
				if(map[i][j]==0) return false;
			}
		}
		return true;
	}
}
