package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_boj_2798_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {

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
		// input*(input-1)*(input-2) = O(n^3) arr.length?˜ ìµœë? ê¸¸ì´?Š” 100 O(100^3)
		// ?”°?¼?„œ 3ì¤? forë¬¸ì„ ?´?š©?•´?„ ì£¼ì–´ì§? ?‹œê°? ?‚´?— ?™?ž‘ ê°??Š¥.
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