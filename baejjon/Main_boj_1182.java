package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1182 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int answer = Integer.parseInt(st.nextToken());
		
		int cnt =0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1;i<(1<<N);i++) {
			int sum = 0 ;
			for(int j=0;j<N;j++) {
				if((i&(1<<j))!=0) {
					sum +=arr[j];
				}
			}
			
			if(sum==answer) {cnt++;} 
		}
		
		System.out.println(cnt);
	}
}
