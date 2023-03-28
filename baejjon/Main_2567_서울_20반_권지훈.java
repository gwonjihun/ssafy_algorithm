package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_2567_서울_20반_권지훈{
	static int[][] arr = new int[101][101];
	static boolean[][] v = new boolean[101][101];
	static int[] dx= {0,0,1,-1}, dy= {1,-1,0,0};
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i< N ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int X= Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			for(int x = X;x<X+10;x++) {
				for(int y= Y;y<Y+10;y++) {
					arr[x][y]= 1;
				}
			}
			
		}
		
		for(int i = 0 ; i< 101;i++) {
			for(int j = 0 ; j<101;j++) {
				if(arr[i][j]==1) {
					for(int d = 0; d< 4;d++) {
						int x = i+dx[d];
						int y = j+dy[d];
						if(0<=x && x<101 &&0<=x && x<101 && arr[x][y]==0 ) {
							cnt++;
						}
					}
					
				}
			}
		}
		System.out.println(cnt);
		
		
	}
	
	
	
}
