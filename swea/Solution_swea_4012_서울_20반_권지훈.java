package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_swea_4012_서울_20반_권지훈 {
	
	static int map[][];
	static boolean[] team;
	static int N;
	static int Min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<= Tc ;t++) {
			N =  Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			team = new boolean[N];
			
			Min = Integer.MAX_VALUE;
			for(int i = 0; i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				
				
				for(int j = 0 ; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
				perm(0,0);
				
				sb.append("#"+t+" "+Min+"\n");
			
		}
		System.out.println(sb);
	}
	
	static void perm(int cnt,int start) {
		if(cnt == N/2) {
			int a=0,b=0;
			for(int i = 0 ; i<N;i++) {
				for(int j = 0 ; j<N;j++) {
					if(i==j) continue;
					if(team[i] == team[j])
					{
						if(team[j]) {
							a+= map[i][j];
						}else {
							b+= map[i][j];
						}
					}
				}
			}
			Min = Math.min(Min, Math.abs(a-b));
			return;
		}
		for(int i = start ; i<N;i++) {
			if(team[i]) continue;
				team[i] = true;
				perm(cnt+1,i+1);
				team[i]= false;
			
		}
	}
	
}
