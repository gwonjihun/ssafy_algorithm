package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17135_서울_20반_권지훈 {
	static int[][] map;
	static int N, M;
	static boolean[] column; // 궁수?�� ?���?
	static boolean[][] die; // 궁수?�� ?���?
	static int row; // 궁수?�� ?��?�� ?���?
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
			// ?��기서 ?��?�� 궁수�? ?��?��?�� ?���? ?��?��?�� ?��?�� ?��?�� �?른다.
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
		// ?��기서?�� 먼�? ?��?���?
		for (int time = 0; time < N; time++) {// ?��기서 N번을 ?��?���?
			if(row <= 0 ) break;
			// ?��?��?�� 기�??��로해?�� ?��?���? 좋겠�??
//			System.out.println( time + "?���? " +"궁수 ?��?�� ?��?��");
			for (int c = 0; c < M; c++) {
				if (!column[c])
					continue;

				// ?��기서 궁수�? �? ?�� ?��?�� 최�? ?�� 최�? ?��?�� 값을 기�??���? 2�? ?��문을 ?��?��?��
				// ?��릴때?�� 먼�?
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
//				System.out.println("궁수 1�? ?��?�� 종료");
			}
//			System.out.println("궁수 ?��?�� ?��?�� 종료");
			

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
