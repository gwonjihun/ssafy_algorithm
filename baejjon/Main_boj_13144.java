package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_13144 {
	
	public static void main(String[] args) throws Exception{

		boolean[] ch;
		int[] arr;
		int n, left,right;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int max_n = 0;
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max_n<arr[i]) max_n = arr[i];
		}
		long cnt = 0;

		//max_n * 4byte * 100000
		//32mb
		ch = new boolean[max_n];
		right = 0;
		for(int l = 0;l<n;l++) {
			while(right<n) {
				if(ch[arr[right]-1]) {
					break;
				}else {
					ch[arr[right]-1]= true;
					right++;
				}
			}
			cnt += right-l;
			ch[arr[l]-1] = false;
		}
		System.out.println(cnt);
	}
}
