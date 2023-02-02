package ssafy_algorithm.baekjjon;

import java.io.*;
import java.util.*;

public class main_bj_14503_로봇청소기_서울_20반_권지훈 {
	static int[][] map;	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int N,M;
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		map = new int[N][M];
		arr = br.readLine().split(" ");
		int x,y,d;
		x = Integer.parseInt(arr[0]);
		y = Integer.parseInt(arr[1]);
		d = Integer.parseInt(arr[2]);
//		map의 값 입력
		for(int i=0;i<N;i++) {
			arr = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		int cnt = 0;
		map[x][y] = 2;
		cnt++;
		while(true) {
			boolean flag = true;
//			북동 남서 동서 
			// 여기서 회전이 다 안된 경우에는 break로 가지닌깐 노상관
//			회전이 끝났는데 flag True다 그렇다면 청소 동작이 진행 안된 것이므로 후진 하고
//			후진이 불가하면 if 문에서 break해주고 최종적으로 cnt 리턴해주면 될꺼같은디?
			for(int i =0;i<4;i++) {
				// 4방향을 다돌 았을때
//				System.out.println("!!! X : "+ x + " Y : "+y + " D : "+d);
//				왼쪽으로 회전
				int nd = (d+3)%4;
				int nx = x+dx[nd];
				int ny = y+dy[nd];
				if ( (0<=nx&&nx<N) && (0<=ny&&ny<M) ) {
					
					if (map[nx][ny]== 0) {
//						여기서 청소 가능
						map[nx][ny]=2;
						x = nx;
						y = ny;
						d = nd;
						flag = false;
						cnt ++;
						break;
					}else {
						d = nd;
					}
				}
					
			}
			
			if (flag == true) {
//				System.out.println("x: " + x + "y : " + y + "d : " + d);
//				for(int i=0;i<N;i++) {
//					
//					for(int j=0;j<M;j++) {
//						System.out.printf("%d",map[i][j]);
//					}
//					System.out.println();
//				}
				// 후진
				int nx = x-dx[d];
				int ny = y-dy[d];
				
				System.out.println("nx : "+ nx + "ny:"+ ny);
				if(map[nx][ny]==1) {
					System.out.println(cnt);
					break;
				}
				else {
					x= nx;
					y= ny;
				}
				
				// flag True라는 의미는 회전을 다했는데도 청소할 곳이 없었단 의미 그러면 이제 후진
				
			}
			
		}
		
		
	}
}
