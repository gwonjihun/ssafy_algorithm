package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main_boj_2798_서울_20반_권지훈 {
public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
	int input = Integer.parseInt(st.nextToken());
	int max = Integer.parseInt(st.nextToken());
	int result = 0;
	
	int array[] = new int [input];
	 st = new StringTokenizer(br.readLine(), " ");
	
	 // N*2 => O(N^2)
	 for(int i = 0 ; i<input ; i++) {
		int n =  Integer.parseInt(st.nextToken());
		if(n<max) {
			array[i] = n;
		}
	} 
	
	 // input*(input-1)*(input-2) = O(n^3) arr.length의 최대 길이는 100  O(100^3)
	 // 따라서 3중 for문을 이용해도 주어진 시간 내에 동작 가능.
	for(int i = 0 ; i<array.length-2; i++) {
		for(int j = i+1;j<array.length-1;j++) {
			for(int k = j+1;k<array.length;k++) {
				int a = array[i]+array[j]+array[k];
				if(a<= max) {
					result = Math.max(a, result);
				}
			}
		}
		
	}
	System.out.println(result);
}
}
