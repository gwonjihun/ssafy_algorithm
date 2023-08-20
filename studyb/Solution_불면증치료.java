package gwonjihun.studyb;

import java.io.*;
import java.util.*;

public class Solution_불면증치료 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int cur = 0;
			int validate = (1 << 10) - 1;
			int multi = 0;
			while (validate > 0) {
				// 새로운 숫자 만들기.
				cur = N * (multi++);
				// 검증하기
				while (cur > 0) {
					int temp = cur % 10;
					validate &= ~(1 << temp);
					cur /= 10;
				}
			}
			System.out.println("#" + test_case + " " + N * (multi - 1));
		}
	}
}
