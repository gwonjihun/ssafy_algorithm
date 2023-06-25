package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_11501 {

	
	public static void main(String[] args) throws Exception{
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			
			int len = Integer.parseInt(br.readLine());
			
			long[] arr = new long[len];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<len;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			long Max = 0;
			long Sum = 0;//이득에 대한 값
			
			for(int i = len-1;i>=0;i--) {
				if(Max >= arr[i]) {
					//주식을 팔면된다. Max가격으로
					Sum += Max-arr[i];
				}else {
					Max = arr[i];
					
				}
			}
			System.out.println((long)Sum);
		}
	}
}
