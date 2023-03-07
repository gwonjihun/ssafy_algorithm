package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_1541_서울_20반_권지훈 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;

		String[] cal = br.readLine().split("-"); // 빼기를 기준으로 분리
		int res = 0;
		for(int i=0;i<cal.length;i++) {
			int sum = 0;
			String[] cal2 = cal[i].split("\\+");
			for(int j=0;j<cal2.length;j++) {
				sum += Integer.parseInt(cal2[j]);
			}
			if(i==0) {
				res += sum;
			}else {
				res -= sum;
			}
		}
		System.out.println(res);
	}
}
