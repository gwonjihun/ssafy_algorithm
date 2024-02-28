package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16917 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int answer = (x > y ? a * (x - y) : b * (y - x));

		answer += ((x > y ? x : y) - Math.abs(x - y)) * ((a + b) > 2 * c ? 2 * c : a + b);
		int max = Math.max(x,y)*Math.min(a+b, 2*c);
		System.out.println(Math.min(answer,max) );
	}

}
