package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * 동작을 구분한다면.
 * 
 * 1. 동작구분 : 밀폐 공기를 찾는다. 
 * 2. 최대 격자 크기는 10,000이기 때문에 완탐으로 해
 * 
 * 문제 진행 순서.
 * 1. 치즈가 남아 있는지 유무를 먼저 찾아준다.
 * 2. 치즈가 남아 있다면, 오염된 공기를 전부 찾는다. 그 방법은 bfs를 통해서 확인하고
 *    오염된 공기는 -1로 전환해준다.
 *    ++ 모눈종이 맨 가장자리는 항상 오염된 공기이다.
 * 3. 치즈를 녹인다.
 * 
 * */
public class Main_boj_2638_aga {

	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int n, m;
	static int[][] cheese, temp_ch;
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		cheese = new int[n][m];
		time = 0;

		for (int i = 0; i < n; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(check()) {
				break;
			}
			
			find_air();
			melting();
			time++;
		}
		System.out.println(time);
	}
	static boolean check() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(cheese[i][j]==1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void rollback() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
					cheese[i][j] = temp_ch[i][j];
				}
			}
		}
	}

}
