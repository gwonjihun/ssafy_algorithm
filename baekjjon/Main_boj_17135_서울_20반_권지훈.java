package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_17135_서울_20반_권지훈 {
	static int[][] map;
	static int N, M;
	static boolean[] column; // 궁수의 위치
	static boolean[][] die; // 궁수의 위치
	static int row; // 궁수의 시작 위치
	static int D, dies; // 거리

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		die = new boolean[N][M];
		column = new boolean[M];
		row = N;
		dies = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		
		System.out.println(dies);
	}

	static void comb(int start, int cnt) {

		if (cnt == 3) {
			// 여기서 이제 궁수가 사냥을 하고 이동을 하는 함수 부른다.
//			System.out.println(Arrays.toString(column));
			dies = Math.max(dies, fight());
			
			return;
		}
		for (int i = start; i < M; i++) {
			column[i] = true;
			comb(i + 1,cnt + 1);
			column[i] = false;
		}
	}

	static int fight() {
		int temp = 0;
		row= N;
		int[][] tmp = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j< M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		// 여기서는 먼저 사람과
		for (int time = 0; time < N; time++) {// 여기서 N번을 해야지
			if(row <= 0 ) break;
			// 사람을 기준으로해서 하는게 좋겠지?
//			System.out.println( time + "시간 " +"궁수 사냥 시작");
			for (int c = 0; c < M; c++) {
				if (!column[c])
					continue;

				// 여기서 궁수가 갈 수 있는 최대 행 최대 열을 값을 기준으로 2중 포문을 돌려서
				// 돌릴때는 먼저
				for(int d = 1; d<=D;d++) {
					for (int j = 0; j < M; j++) {
					
					boolean flag =true;

					for (int i = row - 1; i >= row - D; i--) {
						if(i<0) continue;
						if ((int)Math.abs(row - i) + (int) Math.abs(j - c) != d)
							continue;
						if (tmp[i][j] == 1) {
//							System.out.println("i :" + i + "j : " + j );
							temp++;
							tmp[i][j]=0;
							flag =false;
							break;
						}
					}
					if(!flag) break; 
				}
				}
//				System.out.println("궁수 1명 사냥 종료");
			}
//			System.out.println("궁수 전원 사냥 종료");
			

			row--;

		}

		return temp;
	}
}

/*
7 6 2
0 1 1 0 1 0
1 1 0 1 0 0
1 0 1 0 0 1
0 1 0 0 1 0
1 0 0 1 0 1
0 0 1 0 1 1
0 1 0 1 1 0 
  
 */
