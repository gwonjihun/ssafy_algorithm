package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_4375 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int N = Integer.parseInt(br.readLine());
			int i = 1;
			int cnt = 1;
			while(true) {
				if((i=i%N)==0) {
					System.out.println(cnt++);
					break;
				}else {
					i = i*10+1;
					cnt++;
				}
			}
		}
	}
}
