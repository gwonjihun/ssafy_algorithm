package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_22862 {
	static int N, K;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int k = 0;
		int max_l = 1;
		int l=0,r=0;
		//0. 짝수로 시작한다.
		//1.다음 값이 짝수이면 R을 증가시키면서 Max_l을 갱신한다
		//2.다음 값이 짝수이고 k!=K이면 R을 증가시키면서 Max_l은 갱신하지 않는다
		//Max_l -> R-L+1-k로 값을 확인한다.
		while(r<N) {
			if(k<K) {
				if(arr[r]%2==1) {
					k++;
				}
				r++;
				max_l = Math.max(max_l, r-l-k);
			}else if(arr[r]%2==0) {
				r++;
				max_l = Math.max(max_l, r-l-k);
			}else {
				if(arr[l]%2==1) {
					k--;
				}
				l++;
			}
		}
		
		System.out.println(max_l);
	}
	
}
 