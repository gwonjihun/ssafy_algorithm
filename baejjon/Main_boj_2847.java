package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2847 {
	static int t;
	static int[] cases;
	static int cnt = 0 ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		cases = new int[t];
		for(int i=0;i<t;i++) {
			cases[i] = Integer.parseInt(br.readLine());
		}
		if(t>1) {
		for(int i=t-2;i>=0;i--) {
			if(cases[i+1]<=cases[i]) {
				int tmp = (cases[i]-cases[i+1])+1;
				cases[i]-=tmp;
				cnt += tmp;
			}
		}
		System.out.println(cnt);
		}
		else {
			System.out.println(0);
		}
	}
}
