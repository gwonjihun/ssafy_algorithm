package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;

public class Main_boj_16234_서울_20반_권지훈_복습 {
	static int[][] arr ;
	static int[] dx = {0,0,1,-1},dy = {1,-1,0,0};
	static boolean[][] v;
	static int N, L, R, cnt_n, sum_p; //cnt_n -> sum_p가 필요한 이유는 ?
	
	static List<int[]> li; // 평균값 넣어줘야하는 노드들 리스트
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 1. 먼저 공유선이 가능한지를 bfs로 탐색한며 arraylist에 저장 x,y,cnt를 저장한다
		 * 2. 합쳐서 
		 * */
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i = 0 ; i <N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N ; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		while(true) {
			boolean flag = false;
			v = new boolean[N][N];
			for(int i = 0 ;i<N;i++) {
				for(int j= 0 ; j<N ; j++) {
					if(v[i][j]) continue; // 이미 방문되어 있으면  -> 여기서 문제 없고
					li = new ArrayList<>();
					int sum = bfs(i,j);// 예를들어 둘의 차이라 20인데 하나가 20이고 하나가 0이면? -> 10이되버리면?
					//
//					if(sum/li.size() != arr[i][j]) { //
//					if(sum != arr[i][j]) { // -> // 
					if(li.size()>1) { // ->정답
						//이거로 나누면 안되는 이유는 -> 1. 0 
						flag= true;
						change(sum);
					}
				}
			}
			if(flag){
			day++;
			}
			else {
				break;
			}
		}
		System.out.println(day);
	
	}
	static int bfs(int x, int y) {
		
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		li.add(new int[] {x,y});
		v[x][y] = true;
		int cnt = arr[x][y];
		while(!q.isEmpty()) {
			int[] tmp = q.pollFirst();
			for(int i = 0; i<4 ; i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if( 0<= nx && nx < N && 0<= ny && ny < N && !v[nx][ny] ) {
					if(L<=Math.abs(arr[tmp[0]][tmp[1]] - arr[nx][ny]) && Math.abs(arr[tmp[0]][tmp[1]] - arr[nx][ny])<= R ) {
						li.add(new int[] {nx,ny});
						q.addLast(new int[] {nx,ny});
						v[nx][ny]=true;
						cnt += arr[nx][ny];
					}
				}
			}
		}
		return cnt;
	}
	
	static void change(int sum) {
		if(li.size()==0) return;// 안전장치 1
		int avg = sum/li.size();
		for(int[] a : li) {
			arr[a[0]][a[1]] = avg;
		}
	}




}
