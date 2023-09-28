package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * 1. 모든 경로를 찾는 문제이다.
 * 2. goal을 통해서 이전 dfs에서 얻은 경우 중 특정 x,y좌표로 오면 최종 목적지에 도착이 가능하다
 * 3. 라는 것을 저장해놔 준다면..? 그러면 예를 들어 1,1이 중간점에 있는 경우면 무조건 도착이 가능하닌깐
 * 4. 추가적으로 dfs가 안돌아도 된다 -> goal이라는 boolean 2차원을 가지고
 * 5. true인 경우는 바로 return을 해준다. 
 * --> 정정 x,y-> 도착지점까지 갈 수 있는 방법이 2가지 이상인 경우를 1개로 카운트하기 때문에
 * 설계 x
 * 6. dp[][] = -1로 설계하고 초기에 거길 방문하면 dp[x][y]=0으로 정정해준다.
 * */

public class Main_boj_1520 {
	static int map[][];
	static int[] dx = {0,0,1,-1}, dy= {1,-1,0,0};
	static int[][] goal;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		goal = new int[n][m];
		
		for(int i = 0 ; i< n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
				goal[i][j]= -1;
			}
		}// 초기 데이터 입력
		System.out.println(dfs(0,0));
		
	}
	
	static int dfs(int x, int y) {
		if(x==n-1&&y==m-1) {
			return 1;
		}
		
		if(goal[x][y]!=-1) {
			return goal[x][y];
		}else {
			goal[x][y]= 0;
			for(int d = 0 ; d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx>=0 && nx<n&&ny>=0 && ny<m && map[x][y] >map[nx][ny]) {
					goal[x][y]+= dfs(nx,ny);
				}
			}
		}
		
		return goal[x][y];
	}
}
