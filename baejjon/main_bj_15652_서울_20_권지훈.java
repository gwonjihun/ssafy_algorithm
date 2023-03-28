package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main_bj_15652_서울_20_권지훈 {
	static int n,r;
	static int[] result;
//	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
//		arr = new int[n];
		result = new int[r];
		percomb(0,0);
	}
	
	static void percomb(int cnt, int start) {
		if(cnt==r) {
			for(int a : result) System.out.print(a+" ");
			System.out.println();
			return;
		}
		for(int i=start; i<n;i++) {

//			if(v[i]) continue;
//			v[i]=true;
			result[cnt] =i+1;
			percomb(cnt+1,i);// 조합
//			percomb(cnt+1,0);// ?��?��
//			percomb(cnt+1,i);// 중복?��?��조합
//			v[i]=false;
//			comb(cnt+1,i); -> ?���? 중복조합
		}
	}
}

