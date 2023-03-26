package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_1074_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	static int N, X,Y,cnt=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		count((int)Math.pow(2, N),X,Y);
	}
	
	static void count(int size,int r,int c) {
		if (size == 1) {
			System.out.println(cnt);
			return;
		}

		int n = size / 2;
		if (r < n && c < n) { // 1?‚¬ë¶„ë©´
			cnt += n * n * 0;
			count(n, r, c);
		} else if (r < n && c < n + n) { // 2?‚¬ë¶„ë©´
			cnt += n * n * 1;
			count(n, r, c - n);
		} else if (r < n + n && c < n) { // 3?‚¬ë¶„ë©´
			cnt += n * n * 2;
			count(n, r - n, c);
		} else if (r < n + n && c < n + n) { // 4?‚¬ë¶„ë©´
			cnt += n * n * 3;
			count(n, r - n, c - n);
		}
	}
}
