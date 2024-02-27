package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16968 {
	static final int DEC = 10;
	static final int CHAR = 26;
	static String pattern;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pattern = br.readLine();
		int answer = pattern.charAt(0) =='c' ? CHAR : DEC;
		for(int i = 1; i<pattern.length();i++) {
			if(pattern.charAt(i-1)==pattern.charAt(i)) {
				answer*= ((pattern.charAt(i) =='c' ? CHAR : DEC) -1);
			}else {
				answer*=  pattern.charAt(i) =='c' ? CHAR : DEC;
			}
		}
		System.out.println(answer);
	}
}
