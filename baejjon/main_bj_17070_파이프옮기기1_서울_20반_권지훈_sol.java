
package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class main_bj_17070_?ŒŒ?´?”„?˜®ê¸°ê¸°1_?„œ?š¸_20ë°?_ê¶Œì??›ˆ_sol {
	static int[][] arr;
	static int cnt = 0;
	static int N;
	public static void dfs(int x,int y,int z) {
		if(x==N-1 && y== N-1) {
			cnt+= 1;
			return;
		}
		if(x+1<N && y+1<N) {
			if (arr[x+1][y+1]==0 && arr[x][y+1] == 0 && arr[x+1][y]==0) {
				dfs(x+1,y+1,2);
			}
		}
		if(z == 0 || z == 2) {
			if (y+1<N) {
				if(arr[x][y+1]==0) {
					dfs(x,y+1,0);
				}
			}
		}
		if(z==1 || z==2) {
			if (x+1<N) {
				if (arr[x+1][y]==0) {
					dfs(x+1,y,1);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
		String tmp = br.readLine();
		StringTokenizer sc = new StringTokenizer(tmp);
			for(int j=0; j<N;j++) {
				arr[i][j] = Integer.parseInt(sc.nextToken());
			}
		}
		
		dfs(0,1,0);
		
		System.out.println(cnt);
	}
	
}
