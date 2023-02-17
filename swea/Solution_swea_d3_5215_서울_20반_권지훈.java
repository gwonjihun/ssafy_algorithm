package gwonjihun.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_d3_5215_서울_20반_권지훈 {
	static boolean[] v;
	static int[][] map;
	static int N;
	static int limit, result;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
				
		for (int T = 1; T <= tc; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			result = 0;
			visited = new boolean[N];
			map = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			subs(0);
			sb.append("#"+T+" "+result+"\n");
		}
		System.out.println(sb);
	}
	static void subs(int cnt) {
		if(cnt == N) {
			int sum_s = 0; // 만족도
			int sum_k =0;
			for(int i =0;i<N;i++) {
				if(visited[i]) {
					sum_s += map[i][0];
					sum_k += map[i][1];
				}
			}
			if(sum_k<=limit) {
				result = Math.max(result, sum_s);
			}
			return;
		}
		visited[cnt]= true;
		subs(cnt+1);
		visited[cnt]= false;
		subs(cnt+1);
		
	}
	
}
