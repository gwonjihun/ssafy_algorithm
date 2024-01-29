package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14225 {
	static int N ;
	static int[] arr;
	static boolean[] check = new boolean[100001*20];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		check[0] = true;
		subset(0,0);
		int answer = 0;
		while(check[answer]) {
			answer++;
		}
		System.out.println(answer);
	}
	static void subset(int idx,int sum) {
		if(idx == N) {
			check[sum]= true;
			return;
		}
		subset(idx+1,sum+arr[idx]);
		subset(idx+1,sum);
	}
}
