package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * dfs(int x,int y,int dir, int cnt,int[][] map) 
 * 로 들어가서
 */
public class Main_boj_19236 {
	static int[][][] map = new int[4][4][2];
	static int[] dx= {-1,-1,0,1,1,1,0,-1},dy= {0,-1,-1,-1,0,1,1,1};
	static int max = Integer.MIN_VALUE;//최대 먹은 물고기 수
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < 4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0;j<4;j++) {
			
				map[i][j][0] =  Integer.parseInt(st.nextToken());
				map[i][j][1] =  Integer.parseInt(st.nextToken())-1;
				
			}
		}
	}
}
