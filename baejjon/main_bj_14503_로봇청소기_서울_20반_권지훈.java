package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class main_bj_14503_로봇�??���?청소기_?��?��_20�?_권�??�� {
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
//		map?�� �? ?��?��
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
//			북동 ?��?�� ?��?�� 
			// ?��기서 ?��?��?�� ?�� ?��?�� 경우?��?�� break�? �?�??���? ?��?���?
//			?��?��?�� ?��?��?��?�� flag True?�� 그렇?���? �??�� ?��?��?�� 진행 ?��?�� 것이�?�? ?���? ?���?
//			?��진이 불�??���? if 문에?�� break?��주고 최종?��?���? cnt 리턴?��주면 ?��꺼같???��?
			for(int i =0;i<4;i++) {
				// 4방향?�� ?��?�� ?��?��?��
//				System.out.println("!!! X : "+ x + " Y : "+y + " D : "+d);
//				?��쪽으�? ?��?��
				int nd = (d+3)%4;
				int nx = x+dx[nd];
				int ny = y+dy[nd];
				if ( (0<=nx&&nx<N) && (0<=ny&&ny<M) ) {
					
					if (map[nx][ny]== 0) {
//						?��기서 �??�� �??��
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
				// ?���?
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
				
				// flag True?��?�� ?��미는 ?��?��?�� ?��?��?��?��?�� �??��?�� 곳이 ?��?��?�� ?���? 그러�? ?��?�� ?���?
				
			}
			
		}
		
		
	}
}
