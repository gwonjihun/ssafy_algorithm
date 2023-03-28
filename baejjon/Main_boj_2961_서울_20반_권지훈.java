package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_2961_서울_20반_권지훈  {
	static int[][] arr;
	static boolean[] v;
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		comb(0);

		System.out.println(min);
	}

	//
	static void comb(int cnt) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(v));
			int pl = 1, ms = 0;
			for (int i = 0; i < N; i++) {
				pl = pl * (chekc(i) ? arr[i][0] : 1);
				ms = ms + (chekc(i) ? arr[i][1] : 0);
//				System.out.println(chekc(i)? arr[i][0]:1);
//				System.out.println(chekc(i)? arr[i][1]:0);
			}
			if (pl != 1 && ms != 0)
				min = Math.min(min, Math.abs(pl - ms));

			return;
		}
		// 중복 불�??��
		v[cnt] = true;
		comb(cnt + 1);
		v[cnt] = false;
		comb(cnt + 1);

	}

	static boolean chekc(int i) {
		if (v[i])
			return true;
		return false;
	}
}
