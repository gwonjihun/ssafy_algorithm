package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D0_프로세스연결하자 {
	static int N;
	static int[][] map;
	static int Min_len;
	static List<int[]> node_list, chose_list;
	static int[] dx = {0,0,1,-1}, dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc =1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			node_list = new ArrayList<>();
			for(int i = 0 ; i < N ; i ++ ) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j< N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(i==0||i==N-1||j==0||j==N-1) continue;
						node_list.add(new int[] {i,j});
					}
				}
			}
			Min_len = Integer.MAX_VALUE;
			for(int i = node_list.size();i>=0;i--) {
				chose_list = new ArrayList<>();
				comb(0,0,i);
				if(Min_len<Integer.MAX_VALUE)
					break;
			}
			System.out.println("#"+tc+" "+Min_len);
		}
	}
	
	static void comb(int idx, int cnt, int goal) {
		if(cnt == goal) {
//			for(int[] a : chose_list)
//				System.out.println(Arrays.toString(a));
//			System.out.println("---------------------");
			dfs(0,0,goal);
			return ; 
		}
		for(int i = idx; i<node_list.size();i++) {
			chose_list.add(node_list.get(i));
			comb(i+1,cnt+1,goal);
			chose_list.remove(chose_list.size()-1);
		}
	}
	
	static void dfs(int idx,int cnt_len, int goal) {
		if(idx==goal) {
			Min_len = Math.min(cnt_len, Min_len);
			return;
		}
		for(int d = 0 ; d< 4;d++) {
			//프로세스를 4방향을 기준으로 탐색하기 위한 for문
			int len= 0;
			int x = chose_list.get(idx)[0];
			int y = chose_list.get(idx)[1];
			boolean flag = false;
			while(true) {
				x += dx[d];
				y += dy[d];
				if(!inRange(x,y)) {
					flag = true;
					break;
				}
				if(map[x][y]!=0) {
					break;
				}
				map[x][y]=2;
				len++;
			}
			if(flag) {
				dfs(idx+1,cnt_len+len,goal);
			}
			while(true) {
				x -= dx[d];
				y -= dy[d];
				if (map[x][y] != 2) break;

				map[x][y] = 0;
			}
		}
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
}
