package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2210 {

	static Set<String> set;
	static int[][] arr;
	static int[] dx= {0,0,1,-1}, dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		for(int i = 0 ; i < 5;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		set = new HashSet<>();
		for(int i = 0 ; i < 5;i++) {
			for(int j = 0 ; j < 5;j++) {
				dfs(1,i,j,""+arr[i][j]);
			}
		}
//		for(String re : set) {
//			System.out.println(re);
//		}
		System.out.println(set.size());
	}
	static void dfs(int depth,int sx,int sy, String ans) {
		if(depth==6) {
//			System.out.println(ans);
			set.add(ans);
			return;
		}
		for(int d = 0 ;d<4;d++) {
			int nx = sx +dx[d];
			int ny = sy+dy[d];
			if(0<=nx&&nx<5&&0<=ny&&ny<5) {
				dfs(depth+1,nx,ny,ans+arr[nx][ny]);
			}
		}
	}
}
