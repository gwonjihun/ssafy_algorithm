package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_10610 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
	
		Arrays.sort(input);
		
		int len = input.length;
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = len -1; i>=0;i--) {
			int num = input[i]-'0';
			sum +=num;
			sb.append(num);
		}
		
		if(input[0]!='0'|| sum%3!=0) {
			System.out.println(-1);
		}else {
			System.out.println(sb);
		}
	}

}
