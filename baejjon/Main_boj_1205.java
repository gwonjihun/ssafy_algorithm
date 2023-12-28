package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1205 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, Collections.reverseOrder());
//		System.out.println(Arrays.toString(arr));
		if (N == P && input <= arr[arr.length - 1]) {
			System.out.println(-1);
		} else {
			int rank = 1;
			for (int i = 0; i < N; i++) {
				if (input < arr[i]) {
					rank++;
				} else {
					break;
				}
			}

			System.out.println(rank);
		}
	}
}
