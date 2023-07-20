package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_20366 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		int[] snow = new int[N];
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < N ; i++) {
			snow[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(snow);
//		System.out.println(Arrays.toString(snow))
//		;
		for(int i = 0 ; i < N;i++) {
			//머리쪽 공
			for(int j=i+1;j<N;j++) {
				// 몸쪽 눈덩이
				int s=0, e= N-1;
				int man = snow[i]+snow[j];
				while(s<e) {
					if(s==i||s==j) {
						s++;
						continue;
					}
					if(e==i||e==j) {
						e--;
						continue;
					}
					
					int tempsnow = snow[s]+snow[e];
					min = Math.min(min, Math.abs(tempsnow-man));
					
					if(man<tempsnow) {
						e--;
					}else if(man>tempsnow) {
						s++;
					}else {
						break;
					}
					
				}
			}
		}
		System.out.println(min);
	}

}
