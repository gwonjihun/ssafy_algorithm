package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_10971_aga {

	static int[][] map;
	static int[] route;
	static boolean[] visited;
	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		route = new int[N];
		map = new int[N][N];
		visited= new boolean[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		
		System.out.println(min);
	}
	static void perm(int depth) {
		if(depth == N) {
			int sums = 0;
			for(int i = 0 ; i<N-1;i++) {
				int temp = map[route[i]][route[i+1]];
				if(temp== 0) return;
				sums += temp; 
			}

			int temp = map[route[N-1]][route[0]];

			if(temp== 0) return;
			sums += temp;
			
			min = Math.min(min, sums);
			return;
		}
		
		for(int i = 0 ; i < N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			route[depth] = i;
			perm(depth+1);
			visited[i]= false;
		}
	}
	
}
