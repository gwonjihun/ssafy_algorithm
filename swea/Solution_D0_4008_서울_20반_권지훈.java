package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D0_4008_서울_20반_권지훈 {

	static int[] arr, su = new int[4];
	static int N;
	static int Min, Max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int T = 1; T <= tc; T++) {
			Max = Integer.MIN_VALUE;
			Min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				su[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(1, arr[0], su[0], su[1], su[2], su[3]);
			sb.append("#").append(T).append(" ").append(Max-Min).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int cnt, int result, int add, int minus, int mul, int divs) {
		if (cnt == N) {
			Max = Math.max(Max, result);
			Min = Math.min(Min, result);

			return;

		}
		if (add > 0) {
			dfs(cnt+1, result+arr[cnt],add-1,minus,mul,divs);
		}
		if (minus > 0) {
			dfs(cnt+1, result-arr[cnt],add,minus-1,mul,divs);

		}
		if (mul > 0) {
			dfs(cnt+1, result*arr[cnt],add,minus,mul-1,divs);

		}
		if (divs > 0) {
			dfs(cnt+1, result/arr[cnt],add,minus,mul,divs-1);

		}
	}
}
