package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;

public class SubsBit {
	static int N=4,R=3,c=0;
	static int[] a= {1,2,3,4}, b= new int[R];
//	static boolean[] v = new boolean[N];
//	static int v=0;
	public static void main(String[] args) throws Exception {
		
//		for(int i=0; i<1<<N;i++) {
//			System.out.printf("%2s : %4s\n",i,Integer.toBinaryString(i));
//		}
		
//		for(int i=0; i<1<<N; i++) {
//			for(int j =0;j<N; j++)
//			{
//				System.out.print(((i&1<<j)!=0? a[j]:"X") +" ");
//			
//			}
//			System.out.println();
//			c++;
//		}
//		subs(0,0);
		perm(0,0);
		
	}
	static void subs(int cnt, int v) {
		if(cnt == N) {
			for(int i=0;i<N;i++) {
				System.out.print(((v&1<<i)!=0? a[i]: "X")+" ");
			}
			System.out.println();

			c++;
			return;
		}
		subs(cnt+1,v|1<<cnt);
//		v[cnt]=false;
		subs(cnt+1,v);
	}
	static void perm(int cnt, int v) {
		if(cnt == R) {
			System.out.println(Arrays.toString(b));
			c++;
			return;
		}
		for(int i=0;i<N;i++) {
			if((v&1<<i)!=0) continue;
			b[cnt]=a[i];
			perm(cnt+1,v|1<<i);

		}
	}
}
