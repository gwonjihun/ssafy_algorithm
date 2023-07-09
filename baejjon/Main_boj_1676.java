package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1676 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		while(N>=5) {
			N= N/5;
			sum += N;
		}
		System.out.println(sum);

	}
}
