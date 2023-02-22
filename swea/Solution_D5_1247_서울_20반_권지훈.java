package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D5_1247_서울_20반_권지훈 {
	static int[][] cus;
	static int[] com = new int[2], home = new int[2], per;
	static int N, result = Integer.MAX_VALUE;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T ; t++) {
			
			N = Integer.parseInt(br.readLine());
			cus = new int[N][2];
			per = new int[N];
			v = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			com[0] = Integer.parseInt(st.nextToken());
			com[1] = Integer.parseInt(st.nextToken());
			
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<N;i++ ) {
				cus[i][0] = Integer.parseInt(st.nextToken());
				cus[i][1] = Integer.parseInt(st.nextToken());
			}
			result =Integer.MAX_VALUE;
			perm(0);
			sb.append("#"+t+" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			int sum = 0;
			//durltj 이제 배열 계산으로 진행

			sum += (Math.abs(cus[per[0]][0]-com[0])+Math.abs(cus[per[0]][1]-com[1]));
			for(int i = 1 ; i<N; i++) {
				sum += (Math.abs(cus[per[i]][0]-cus[per[i-1]][0])+Math.abs(cus[per[i]][1]-cus[per[i-1]][1]));
			}
			sum += (Math.abs(cus[per[N-1]][0]-home[0])+Math.abs(cus[per[N-1]][1]-home[1]));
			result = Math.min(result, sum);
			return;
		}
		for(int i = 0 ; i<N; i++) {
			if(v[i]) continue;
			v[i] = true;
			per[cnt] = i;
			perm(cnt+1);
			v[i]=false;
		}
	}
}
