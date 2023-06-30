package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2003 {

	
	static int N,M;
	static int arr[];
	static int cnt= 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int l = 0, r=0;
		int sum = 0 ; 
		while(l<N) {
			if(sum>M || r == N) sum-=arr[l++];
			else {sum +=arr[r++];}
			if(sum==M){cnt++;}
		}
		System.out.println(cnt);
	}
}
