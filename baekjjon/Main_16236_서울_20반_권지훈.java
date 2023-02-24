package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;


public class Main_16236_서울_20반_권지훈 {
	static int[][] map; // 물고기 지도
	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1}; 
	static int N;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean flag=  false;
		int x= 0 ,y= 0;
		for(int i= 0 ; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(0<map[i][j]&& map[i][j]<9) flag =true;
				if(map[i][j] == 9 ) {
					x= i; y=j;
				}
			}
		}
		if(!flag) { System.out.println("0"); 
		return;
		}
		bfs(x,y,2,0,0);
		
	}
	
	static void bfs(int x, int y , int age , int eat,int move) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y,age,eat,move});
		while(true) {
			int[] shark = q.poll();
			if(!check_f(shark[2])) {// 이걸 통해서 먹이가 없다면 종료이고
				result = shark[4];
				return;
			}
			if(map[shark[0]][shark[1]] <shark[2])
			for(int i = 0 ; i< 4; i ++) {
				
			}
		}
		
			return ;
		}
	
	
	
	
	// check_f를 통해서 현재 상어가 먹으러 갈 수 있는 것이 있는지를 확인해준다.
	static boolean check_f(int age) {
		for(int i = 0; i<N;i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j]<age) return true;
			}
		}
		return false;
	}
}
