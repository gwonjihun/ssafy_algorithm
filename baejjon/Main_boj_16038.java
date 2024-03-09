package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16038 {

	static int N, L, R, X;
	static int[] arr;// 문제의 난이도
	static int cnt = 0;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
//		System.out.println(arr[2]);
		subSet(0, 0);
		System.out.println(cnt);
	}

	static void subSet(int depth, int sum) {
//		System.out.println("_______");
//		System.out.println(depth);

		if (depth == N) {
//			System.out.println(sum);
			if (sum > R)
				return;
			if (sum >= L) {
//				System.out.println(sum);
				int min = list.get(0);
				int max = list.get(list.size()-1);
				if(max-min >=X) {
					cnt++;
				}
				return;
			}
			return;
		}
		list.add(arr[depth]);
		subSet(depth+1,sum+arr[depth]);
		list.remove(list.size()-1);
		subSet(depth+1,sum);
	}
}
