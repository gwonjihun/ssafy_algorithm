package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_boj_2798_서울_20반_권지훈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());

		int[] array = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		// N*2 => O(N^2)
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n < max) {
				array[i] = n;
			}
		}
		int result = 0;
		// input*(input-1)*(input-2) = O(n^3) arr.length의 최대 길이는 100 O(100^3)
		// 따라서 3중 for문을 이용해도 주어진 시간 내에 동작 가능.
		end: for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int a = array[i] + array[j] + array[k];
					if (a < max) {
						result = Math.max(a, result);
					} else if (a == max) {
						result = a;
						break end;
					}
				}
			}
		}

		System.out.println(result);
		br.close();
	}

}