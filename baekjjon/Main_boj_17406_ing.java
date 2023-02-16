package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;
// 1. 회전에 대한 구현
// 2. 회전 
class cmd{
	int x;
	int y;
	int length;
	cmd(int x, int y, int length){
		this.x = x;
		this.y = y;
		this.length = length;
	}
}
public class Main_boj_17406_ing {
	static int N,M,K;
	static int[][] arr;
	static cmd[] cmd_list, cmd_result;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		arr = new int[N][M];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j= 0 ; j< N;j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}

		cmd_list = new cmd[K];
		cmd_result = new cmd[K];
		v = new boolean[K];
		perm(0);
		
	}
	
	
	
	static void minfind() {}
	static void rotate() {
	}
	
	static void perm(int cnt) {
		if(cnt == K) {
			
			
			return;
					
		}
		for(int i = 0;i<K;i++ ) {
			if (v[i]) continue;
			v[i] = true;
			cmd_result[cnt] = cmd_list[i];
			perm(cnt+1);
			v[i] = false;
			
		}
	}
}
