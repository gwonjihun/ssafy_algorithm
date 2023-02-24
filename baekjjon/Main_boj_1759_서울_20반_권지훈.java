package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_1759_서울_20반_권지훈 {

	static int L,C;
	static char[] a,b = {'a','e','i','o','u'};
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		v= new boolean[C];
		a = new char[C];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<C; i++) {
			a[i] =  st.nextToken().charAt(0);
		}
		Arrays.sort(a);
//		System.out.println(Arrays.toString(a));
		
		perm(0,0,0,0);
		System.out.println(sb);
	}
	
	static void perm(int cnt,int start,int ja, int mo) {
		if(cnt == L) {
			if(ja>=2 && mo>=1) {
				for(int i = 0 ;i <C;i++) {
					sb.append(v[i] ? a[i]:"");
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=start; i<C; i++) {
			if(v[i]) continue;
			boolean flag = false;
			v[i]= true;
			for(int j = 0;j<5;j++) {
				if(a[i]==b[j]){
					flag = true;
					break;
				}
			}
			if(flag) {
				perm(cnt+1,i+1,ja,mo+1);
			}else {
				perm(cnt+1,i+1,ja+1,mo);
			}
			v[i]=false;
			
		}
	}
}
