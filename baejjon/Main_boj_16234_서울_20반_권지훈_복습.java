package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_16234_?„œ?š¸_20ë°?_ê¶Œì??›ˆ_ë³µìŠµ {
	static int[][] arr ;
	static int[] dx = {0,0,1,-1},dy = {1,-1,0,0};
	static boolean[][] v;
	static int N, L, R, cnt_n, sum_p; //cnt_n -> sum_pê°? ?•„?š”?•œ ?´?œ ?Š” ?
	
	static List<int[]> li; // ?‰ê· ê°’ ?„£?–´ì¤˜ì•¼?•˜?Š” ?…¸?“œ?“¤ ë¦¬ìŠ¤?Š¸
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 1. ë¨¼ì? ê³µìœ ?„ ?´ ê°??Š¥?•œì§?ë¥? bfsë¡? ?ƒ?ƒ‰?•œë©? arraylist?— ???¥ x,y,cntë¥? ???¥?•œ?‹¤
		 * 2. ?•©ì³ì„œ 
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
					if(v[i][j]) continue; // ?´ë¯? ë°©ë¬¸?˜?–´ ?ˆ?œ¼ë©?  -> ?—¬ê¸°ì„œ ë¬¸ì œ ?—†ê³?
					li = new ArrayList<>();
					int sum = bfs(i,j);// ?˜ˆë¥¼ë“¤?–´ ?‘˜?˜ ì°¨ì´?¼ 20?¸?° ?•˜?‚˜ê°? 20?´ê³? ?•˜?‚˜ê°? 0?´ë©?? -> 10?´?˜ë²„ë¦¬ë©??
					//
//					if(sum/li.size() != arr[i][j]) { //
//					if(sum != arr[i][j]) { // -> // 
					if(li.size()>1) { // ->? •?‹µ
						//?´ê±°ë¡œ ?‚˜?ˆ„ë©? ?•ˆ?˜?Š” ?´?œ ?Š” -> 1. 0 
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
		if(li.size()==0) return;// ?•ˆ? „?¥ì¹? 1
		int avg = sum/li.size();
		for(int[] a : li) {
			arr[a[0]][a[1]] = avg;
		}
	}




}
