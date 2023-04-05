package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2458_키순서 {
	static int N,M,adj[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			
			StringTokenizer st;
			
			int a,b;
			for(int m = 0; m<M;m++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b]=1;
			}
			
			for(int k = 1;k<=N;k++) {//경유
				for(int i=1;i<=N;i++) {//시작
					if(i==k|| adj[i][k]==0) continue;
					for(int j =1; j<=N;j++) {//도착
						if(adj[i][j]==1) continue;
//						if(adj[k][j]== 1)
							adj[i][j]=adj[k][j];
					}
				}
			}
			int cnt = 0;
			for(int i=1;i<=N;i++) {//시작
				int temp = 0;
				for(int j =1; j<=N;j++) {//도착
					if(adj[i][j] == 1) temp++;
				}
				for(int j =1; j<=N;j++) {//도착
					if(adj[j][i] == 1) temp++;
				}
				if(temp==N-1) cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
