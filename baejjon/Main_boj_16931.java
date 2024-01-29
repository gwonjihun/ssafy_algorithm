package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16931 {
	
	static int[][] map;
	static int n,m;
	static int cnt;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0 ; i <n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<m;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		cnt = (n*m)*2;//위 아랫값은 항상 n*m으로 고정
		for(int i = 0 ; i < n;i++) {
			for(int j = 0 ; j < m;j++) {
				int heigh = map[i][j];
				for(int d=  0; d<4;d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					int temp = 0;
					if(0<=nx && nx<n && 0<=ny && ny<m) {
						//여기서는 heigh을 뺴주는역할을 하고
						temp = map[nx][ny];
					}
					
					cnt+=(heigh-temp)>=0 ? heigh-temp : 0;
					
				}
			}
		}
		System.out.println(cnt);
	}
}
