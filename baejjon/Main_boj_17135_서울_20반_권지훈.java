package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17135_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	static int[][] map;
	static int N, M;
	static boolean[] column; // ê¶ìˆ˜?˜ ?œ„ì¹?
	static boolean[][] die; // ê¶ìˆ˜?˜ ?œ„ì¹?
	static int row; // ê¶ìˆ˜?˜ ?‹œ?‘ ?œ„ì¹?
	static int D, dies; // ê±°ë¦¬

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
			// ?—¬ê¸°ì„œ ?´? œ ê¶ìˆ˜ê°? ?‚¬?ƒ¥?„ ?•˜ê³? ?´?™?„ ?•˜?Š” ?•¨?ˆ˜ ë¶?ë¥¸ë‹¤.
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
		// ?—¬ê¸°ì„œ?Š” ë¨¼ì? ?‚¬?Œê³?
		for (int time = 0; time < N; time++) {// ?—¬ê¸°ì„œ Në²ˆì„ ?•´?•¼ì§?
			if(row <= 0 ) break;
			// ?‚¬?Œ?„ ê¸°ì??œ¼ë¡œí•´?„œ ?•˜?Š”ê²? ì¢‹ê² ì§??
//			System.out.println( time + "?‹œê°? " +"ê¶ìˆ˜ ?‚¬?ƒ¥ ?‹œ?‘");
			for (int c = 0; c < M; c++) {
				if (!column[c])
					continue;

				// ?—¬ê¸°ì„œ ê¶ìˆ˜ê°? ê°? ?ˆ˜ ?ˆ?Š” ìµœë? ?–‰ ìµœë? ?—´?„ ê°’ì„ ê¸°ì??œ¼ë¡? 2ì¤? ?¬ë¬¸ì„ ?Œ? ¤?„œ
				// ?Œë¦´ë•Œ?Š” ë¨¼ì?
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
//				System.out.println("ê¶ìˆ˜ 1ëª? ?‚¬?ƒ¥ ì¢…ë£Œ");
			}
//			System.out.println("ê¶ìˆ˜ ? „?› ?‚¬?ƒ¥ ì¢…ë£Œ");
			

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
