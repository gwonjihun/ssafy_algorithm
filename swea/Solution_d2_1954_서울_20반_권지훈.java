package gwonjihun.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_d2_1954_서울_20반_권지훈 {
	static int[][] answer;
	static int n;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0,  -1,0 };
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Test_case = Integer.parseInt(br.readLine());

		for (int T = 1; T <= Test_case; T++) {
			n = Integer.parseInt(br.readLine());
			
			answer = new int[n][n];
			int x=0,y=0,d=0;
			for(int inputs = 1;inputs<=n*n;inputs++) {
				answer[x][y]= inputs;
				int nx = x+dx[d%4];
				int ny = y+dy[d%4];
				if(0>nx || 0> ny || n<=ny||n<=nx|| answer[nx][ny]!=0) d = (d+1)%4;
					x = x +dx[d];
					y = y + dy[d];
			}
			sb.append("#").append(T).append("\n");
			for(int[] a : answer) {
				for(int aa : a)
				{
					sb.append(aa).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
}
