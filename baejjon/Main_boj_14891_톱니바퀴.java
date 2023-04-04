package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14891_톱니바퀴 {

	static int[][] map = new int[4][8];
	static int[] cmd;

	// cmd 는 -1,0,1로 구성되어 있다. -1은 반시계 1은 시계 0은 회전하지 않는다.
	// idx 0이 12시방향 2는 오른쪽 6은 왼쪽
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				map[i][j] = arr[j] - '0';
			}
		}
		int k = Integer.parseInt(br.readLine());
		while (k-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int st_gear = Integer.parseInt(st.nextToken()) - 1;
			int rot = Integer.parseInt(st.nextToken());

			cmd = new int[4];
			cmd[st_gear] = rot;
			check_roate(st_gear);
			for (int i = 0; i < 4; i++) {
				if (cmd[i] == 1) {
					rotate(i);
				} else if (cmd[i] == -1) {
					rev_rotate(i);
				}
			}


		}
		cal_score();
	}

	static void check_roate(int idx) {
		for (int i = idx - 1; i >= 0; i--) {
			// 톱니기준 왼쪽
			if (map[i + 1][6] != map[i][2]) {
				cmd[i] = cmd[i + 1] * -1;
			} else {// 회전을 안한다
				break;
			}
		}
		for (int i = idx + 1; i < 4; i++) {
			// 톱니기준 왼쪽
			if (map[i - 1][2] != map[i][6]) {
				cmd[i] = cmd[i - 1] * -1;
			} else {// 회전을 안한다
				break;
			}
		}
	}

	static void rotate(int idx) {
		int[] temp = map[idx];
		int last_va = temp[7];
		for (int i = 7; i > 0; i--) {
			temp[i] = temp[i - 1];
		}
		temp[0] = last_va;
		/*
		 * 1234 4123 -> 시계방향이야
		 */ 
		map[idx] = temp;
	}

	static void rev_rotate(int idx) {
		int[] temp = map[idx];
		int last_va = temp[0];
		for (int i = 0; i <7; i++) {
			temp[i] = temp[i+1];
		}
		temp[7] = last_va;

		map[idx] = temp;
	}
	static void cal_score() {
		int sum = 0;
		for(int i = 0; i<4;i++) {
			sum = (int) (sum+map[i][0]*Math.pow(2, i));
		}
		System.out.println(sum);
	}
}
