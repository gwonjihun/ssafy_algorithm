package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1253 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		for(int target = 0 ;target < N ; target ++) {
			int s = 0 , e = N-1;
			while(true) {
				if(s==target) {
					s++;
				}
				if(e==target) {
					e--;
				}
				if(e<=s) break;
				
				if(arr[e]+arr[s] <arr[target]) {
					s++;
				}else if(arr[e]+arr[s] > arr[target]) {
					e--;
				}else {
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
