package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17144 {

	static int[][] board;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int[][] temp;// 이거 확산할 떄 temp용
	static int T, R, C;
	static int cx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		temp = new int[R][C];
		cx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					cx = cx == 0 ? i : cx;
				}
			}
		}
		while (T > 0) {
		spread();
		up();
//		up();
			down();
		
		temp = new int[R][C];
		T--;
		}
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(board[i][j]==-1)continue;
				cnt+=board[i][j];
			}
		}
		System.out.println(cnt);
	}
	static void down() {
		int tmp = board[cx+1][C - 1];// 임시 저장할 값
		for (int i = C - 1; i >= 1; i--) {
			board[cx+1][i] = board[cx+1][i - 1];
//			}
			if (i == 1) {
				board[cx+1][i]= 0;
			}
		}
		int tmp_e = board[R-1][C-1];
		for(int i = R-1 ; i>cx+2;i--) {
			board[i][C-1]=board[i-1][C-1];
		}
		board[cx+2][C-1]= tmp;
		
		tmp = board[R-1][0];
		for(int i = 0 ;i<C-2;i++) {
			board[R-1][i] = board[R-1][i+1];
		}
		board[R-1][C-2]= tmp_e;
		
		for(int i = cx+2;i<R-2;i++) {
			board[i][0]= board[i+1][0];
		}
		board[R-2][0]=tmp;
	}
	
	
	static void up() {
		// 시작할 곳은 [cx][1]부터 시작하고
		int tmp = board[cx][C - 1];// 임시 저장할 값
		for (int i = C - 1; i >= 1; i--) {
			board[cx][i] = board[cx][i - 1];
//			}
			if (i == 1) {
				board[cx][i]= 0;
			}
		}
		int tmp_e = board[0][C-1];
		for(int i = 0 ; i<cx-1;i++) {
			board[i][C-1]=board[i+1][C-1];
		
		}

		board[cx-1][C-1] = tmp;
//		System.out.println(tmp_e);
		
		tmp = board[0][0];
		for(int i = 0;i<C-1;i++) {
			board[0][i]= board[0][i+1];
		}
		board[0][C-2]= tmp_e;
		
		for(int i = cx-1;i>1;i--) {
			board[i][0] = board[i-1][0];
		}
		board[1][0]=tmp;
		
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}

	static void spread() {
		temp = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int cur = board[i][j];// 원본값을 기반으로
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (inRange(nx, ny) && board[nx][ny] != -1) {
						cnt += 1;
						temp[nx][ny] += cur / 5;
					}
				}
//				System.out.println(cnt);
				temp[i][j] += cur - ((cur / 5) * cnt);
			}
		}

		board = temp;
	}
}
