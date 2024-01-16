package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14889 {
	static int N;
	static int[][] info;// 각 사람별 정보
	static boolean[] visited;
	static int max = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		info = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t = 1; t<N;t++) {
		comb(0,0,t);
		}
		System.out.println(max);
		
		
		
	}
	static void comb(int idx,int depth,int target) {
		if(depth==target){
			int x = 0; int y = 0;
			//x,y팀으로 만들고
			for(int i = 0 ; i < N;i++) {
				for(int j = 0 ; j<N;j++) {
					if(visited[i]==visited[j]) {
//						System.out.println("!!!");
						if(visited[i]) {
							x+= info[i][j];
						}else {

							y+= info[i][j];
						}
					}
				}
			}
//			System.out.println(Math.abs(x-y));
			max = Math.min(Math.abs(x-y), max);
			if(max == 0) {
				System.out.println(max);
				System.exit(0);			}
			return;
		}
		
		for(int i= idx; i<N;i++) {
//			if(visited[i])continue;
			visited[i]=true;
			comb(i+1,depth+1,target);
			visited[i]=false;
		}
	}
}
