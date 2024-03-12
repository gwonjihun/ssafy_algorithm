package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17088 {
	static int n;
	static int[] arr;
	static int result;//

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		result = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (n <= 2) {
			result = 0;
		} else {
			dfs(2, arr[0] - 1 - (arr[1] - 1), arr[1] - 1, 2);
			dfs(2, arr[0] - 1 - arr[1], arr[1], 1);
			dfs(2, arr[0] - (arr[1] - 1), arr[1] - 1, 1);

			dfs(2, arr[0] + 1 - (arr[1] - 1), arr[1] - 1, 2);
			dfs(2, arr[0] - arr[1], arr[1], 0);
			dfs(2, arr[0] - 1 - (arr[1] + 1), arr[1] + 1, 2);

			dfs(2, arr[0] + 1 - (arr[1] + 1), arr[1] + 1, 2);
			dfs(2, arr[0] + 1 - arr[1], arr[1], 1);
			dfs(2, arr[0] - (arr[1] + 1), arr[1] + 1, 1);

		}
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
//	      bw.write(result + "");
//	      bw.close();
	}

	public static void dfs(int index, int num, int prev, int cnt) {
		if (arr.length == index) {
			result = Math.min(result, cnt);
			return;
		}
		if (prev - arr[index] == num) {
			dfs(index + 1, num, arr[index], cnt);
		}
		if (prev - (arr[index] + 1) == num) {
			dfs(index + 1, num, (arr[index] + 1), cnt + 1);
		}
		if (prev - (arr[index] - 1) == num) {
			dfs(index + 1, num, (arr[index] - 1), cnt + 1);
		}
	}
}
