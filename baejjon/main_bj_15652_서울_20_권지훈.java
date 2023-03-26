package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main_bj_15652_?Ñú?ö∏_20_Í∂åÏ??õà {
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
			percomb(cnt+1,i);// Ï°∞Ìï©
//			percomb(cnt+1,0);// ?àú?ó¥
//			percomb(cnt+1,i);// Ï§ëÎ≥µ?óà?ö©Ï°∞Ìï©
//			v[i]=false;
//			comb(cnt+1,i); -> ?ù¥Í±? Ï§ëÎ≥µÏ°∞Ìï©
		}
	}
}

