package gwonjihun.swea;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Solution_D0_5656_서울_20반_권지훈_복습 {
	static int[][] arr,temp;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0}, pick;
	static int N,W,H,Min_Block;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <=TC ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			Min_Block = Integer.MAX_VALUE;
			
			arr = new int[H][W];
			pick = new int[N];
		
			for(int i = 0 ; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0 ; j < W; j++) {
					arr[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			perm(0);
			
			sb.append("#").append(t).append(" ").append(Min_Block).append("\n");
			
		}
		System.out.println(sb);
	}
	// perm으로 개수를 만들어서 진행한다 vs perm에서 선택할 때마다 벽돌을 부순다 
	// 선택마다 부수는 경우로 진행할 경우 남는경우가 최소인 경우로 진행하면 되는거닌깐?
	// 음.. 

	static void perm(int cnt) {
		if(cnt ==N) {
			temp = new int[H][W];
			copy();
			// copy한 배열을 기준으로 동작을 시켜준다
			for(int a : pick) {
				delete(a);// 블록 부셔주기
				down();// 남은 블록 내려주기

			}
			
			count();// 남은 블록 확인
			return;
		};
		for(int i = 0; i<W;i++) {
			pick[cnt] = i;
			perm(cnt+1);
			
		}
		
	}
	
	static void delete(int w) {
		int start_h = 0;
		while(temp[start_h][w]==0) {
			if(start_h==H-1) return;
			start_h++;
			
		}
		Deque<int[]> q = new ArrayDeque<>();
		q.addLast(new int[] {start_h,w,temp[start_h][w]});
		temp[start_h][w] = 0;
		//길이를 가지고 있어야하닌깐q에 넣은 뒤에 갱신해줘도 상관이없다.
		while(!q.isEmpty()) {
			int xy[] = q.poll();
			
			for(int d = 0 ; d<4;d++) {
				for(int l = 1; l<xy[2];l++) {
	
					int nx = xy[0] + dx[d]*l;
					int ny = xy[1] + dy[d]*l;
					if(0<=nx && nx<H && 0<=ny && ny<W && temp[nx][ny]!=0)
					{
						q.addLast(new int[] {nx,ny,temp[nx][ny]});
						temp[nx][ny] = 0 ;
					}
				}
			}
		}
		
	}
	static void down() {
		for(int w= 0 ; w <W; w++) {
			for(int h = H-1; h>=1 ; h--) {
				if(temp[h][w]==0) {
					for(int k = h-1; k>=0 ; k--) {
						{
							if(temp[k][w] !=0) 
							{
								temp[h][w] = temp[k][w];
								temp[k][w] = 0;
								break;
							}
						}
					}
				}
			}
		}
	}
	
	
	static void copy() {
		for(int i = 0 ; i < H; i++) {
			for (int j = 0 ; j < W; j++) {
				temp[i][j] = arr[i][j];
			}
		}
	}
	static void count() {
		int cnt=  0;
		for(int i = 0 ; i < H; i++) {
			for (int j = 0 ; j < W; j++) {
				if(temp[i][j]!=0) {
					cnt++;
				}
			}
		}
		Min_Block = Math.min(Min_Block, cnt);
	}
}
