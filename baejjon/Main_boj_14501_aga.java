package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14501_aga {
	static boolean[] visited;
	static int maxScore = Integer.MIN_VALUE;
	static int[][] jobs;
	static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		jobs = new int[N][2];
		
		for(int i = 0 ; i <  N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			jobs[i][0] = Integer.parseInt(st.nextToken());
			jobs[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		subSet(0,0);
		
		System.out.println(maxScore);
	}
	
	static void subSet(int depth, int sum) {
		if(depth == N) {
			maxScore = Math.max(sum, maxScore);
			return;
		}
		
		if(!visited[depth]&&depth+jobs[depth][0]<=N) {
//		}else {
			for(int d = depth; d< depth+jobs[depth][0];d++) {
//				if(d==N) break;
				visited[d] =true;
			}
			subSet(depth+1,sum+jobs[depth][1]);
			for(int d = depth; d< depth+jobs[depth][0];d++) {
//				if(d==N) break;
				visited[d] =false;
			}
			
		}
		subSet(depth+1,sum);

	}

}
