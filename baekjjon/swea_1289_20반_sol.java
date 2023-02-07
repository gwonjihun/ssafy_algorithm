package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea_1289_20반_sol {
	static int Test_case;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		Test_case = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int T=1; T<=Test_case;T ++) {
			String ca = sc.next();
			int cnt=(ca.charAt(0)=='1')? 1:0;
			for(int i=1;i<ca.length(); i++) {
				if(ca.charAt(i-1)!=ca.charAt(i)) cnt++;
			}
			System.out.println("#"+T+" "+cnt);
		}
	}
}
