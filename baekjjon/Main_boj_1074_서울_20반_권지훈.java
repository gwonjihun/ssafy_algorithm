package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;

public class Main_boj_1074_서울_20반_권지훈 {
	static int N, X,Y,cnt=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		find((int)Math.pow(2, N),0,0);
		System.out.println(cnt);
	}
	
	static void find(int n,int x,int y) {
		cnt++;
		if(x==X && y==Y) {
			return;
		}
//		if {
//
//			find(n/2,x,y);
//			find(n/2,x,y+n/2);
//			find(n/2,x+n/2,y);
//			find(n/2,x+n/2,y+n/2);
//		}
	}
}
