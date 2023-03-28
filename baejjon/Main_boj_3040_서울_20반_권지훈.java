package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_3040_서울_20반_권지훈 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for(int i =0; i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		comb(0,0,0,new boolean[9]);
	}

	static void comb(int cnt,int idx, int sum, boolean[] v) {
		if(cnt == 7) {
			if (sum != 100) return;
				for(int i=0;i<9;i++ ) {
					if(!v[i]) continue;
					System.out.println(arr[i]);
				}
			return;
		}
		for(int i = idx; i<9;i++) {
			if(v[i]) continue;
			v[i] = true;
			comb(cnt+1,i+1,sum+arr[i],v);
			v[i]= false;
		}
	}
}
